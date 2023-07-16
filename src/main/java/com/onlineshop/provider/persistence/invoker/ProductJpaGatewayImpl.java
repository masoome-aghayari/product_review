package com.onlineshop.provider.persistence.invoker;

/*
 * @author masoome.aghayari
 * @since 7/13/23
 */

import com.onlineshop.core.entity.PageableStatistics;
import com.onlineshop.core.entity.ProductStatistics;
import com.onlineshop.core.providerapi.ProductGateway;
import com.onlineshop.provider.mapper.ProductStatisticsAssembler;
import com.onlineshop.provider.persistence.repository.CommentRepository;
import com.onlineshop.provider.persistence.repository.ProductRepository;
import com.onlineshop.provider.persistence.repository.dto.CommentDto;
import com.onlineshop.provider.persistence.repository.dto.ProductStatisticsDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ProductJpaGatewayImpl implements ProductGateway {
    private final ProductRepository productRepository;
    private final CommentRepository commentRepository;
    private final ProductStatisticsAssembler mapper;

    @Override
    public PageableStatistics<ProductStatistics> getProductsStatistics(int offset, int length) {
        int page = (offset / length);
        Pageable pageable = PageRequest.of(page, length);
        Page<ProductStatisticsDto> productsStatisticsPage = productRepository.getProductsStatistics(pageable);
        List<ProductStatisticsDto> productsStatisticsList = productsStatisticsPage.getContent();
        setLatestCommentsOnProducts(productsStatisticsList);
        setTotalNumberOfCommentsOnProducts(productsStatisticsList);
        List<ProductStatistics> productsStatisticModels = mapper.toProductStatisticsModelList(productsStatisticsList);
        boolean hasNextPage = productsStatisticsPage.getTotalPages() > page + 1;
        return new PageableStatistics<>(productsStatisticModels, hasNextPage);
    }

    private void setTotalNumberOfCommentsOnProducts(List<ProductStatisticsDto> productsStatisticsList) {
        productsStatisticsList.forEach(p ->
                p.setTotalNumberOfComments(commentRepository.countCommentByAcceptedIsTrueAndProductId(p.getProductId())));
    }

    private void setLatestCommentsOnProducts(List<ProductStatisticsDto> productsStatisticsList) {
        productsStatisticsList.forEach(p -> p.setLatestComments(getProductLatestComments(p.getProductId())));
    }

    public List<CommentDto> getProductLatestComments(Long productId) {
        return commentRepository.getLatestCommentsForProduct(productId, PageRequest.of(0, 3)).getContent();
    }
}

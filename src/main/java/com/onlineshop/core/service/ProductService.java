package com.onlineshop.core.service;

/*
 * @author masoome.aghayari
 * @since 7/13/23
 */

import com.onlineshop.api.model.ProductStatisticsResponseModel;
import com.onlineshop.api.model.StatisticsResponseModel;
import com.onlineshop.core.entity.PageableStatistics;
import com.onlineshop.core.entity.ProductStatistics;
import com.onlineshop.core.providerapi.ProductGateway;
import com.onlineshop.core.service.mapper.ProductStatisticsResponseAssembler;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductGateway productGateway;
    private final ProductStatisticsResponseAssembler responseAssembler;

    @Transactional
    public StatisticsResponseModel<ProductStatisticsResponseModel> getProductsStatistics(int offset, int length) {
        PageableStatistics<ProductStatistics> productPageableStatistics =
                productGateway.getProductsStatistics(offset, length);
        return new StatisticsResponseModel<>(
                responseAssembler.toProductStatisticsResponseModelList(productPageableStatistics.getResults()),
                productPageableStatistics.isHasNextPage());
    }
}


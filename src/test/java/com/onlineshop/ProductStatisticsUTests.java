package com.onlineshop;

import com.onlineshop.api.model.ProductStatisticsResponseModel;
import com.onlineshop.api.model.StatisticsResponseModel;
import com.onlineshop.core.entity.Comment;
import com.onlineshop.core.entity.PageableStatistics;
import com.onlineshop.core.entity.ProductStatistics;
import com.onlineshop.core.enummeration.Commentable;
import com.onlineshop.core.enummeration.Votable;
import com.onlineshop.core.providerapi.ProductGateway;
import com.onlineshop.core.service.ProductService;
import com.onlineshop.core.service.mapper.ProductStatisticsResponseAssembler;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.ZonedDateTime;
import java.util.*;

/*
 * @author masoome.aghayari
 * @since 7/16/23
 */
@SpringBootTest
class ProductStatisticsUTests {

    @Autowired
    ProductStatisticsResponseAssembler responseAssembler;

    @Mock
    ProductService productService;

    @MockBean
    ProductGateway productGateway;

    int offset = 0;
    int length = 5;

    StatisticsResponseModel<ProductStatisticsResponseModel> responseModel;
    PageableStatistics<ProductStatistics> pageableProductStatistics;

    @BeforeEach
    void setupBeforeEach() {
        pageableProductStatistics = getPageableProductStatistics();
        responseModel = getStatisticsResponseModel();
        Mockito.when(productGateway.getProductsStatistics(offset, length)).thenReturn(pageableProductStatistics);
        Mockito.when(productService.getProductsStatistics(offset, length)).thenReturn(responseModel);
    }

    @Test
    void requestForStatistics_then_return_statistics() {
        var actualResult =
                productService.getProductsStatistics(offset, length);
        var expectedResult = responseModel;
        Assertions.assertEquals(expectedResult, actualResult);
    }

    private StatisticsResponseModel<ProductStatisticsResponseModel> getStatisticsResponseModel() {
        return new StatisticsResponseModel<>(toStatisticsResponseModel(pageableProductStatistics.getResults()),
                pageableProductStatistics.isHasNextPage());
    }

    private List<ProductStatisticsResponseModel> toStatisticsResponseModel(
            Collection<ProductStatistics> productStatisticsList) {
        return responseAssembler.toProductStatisticsResponseModelList(productStatisticsList);
    }

    private PageableStatistics<ProductStatistics> getPageableProductStatistics() {
        return new PageableStatistics<>(getMockQueryResults(), false);
    }

    private List<ProductStatistics> getMockQueryResults() {
        return List.of(new ProductStatistics(1L, Commentable.COMMENTABLE_TO_BUYERS, Votable.VOTABLE_TO_BUYERS,
                        getLatestComments(1L), 4.5, 5L),
                new ProductStatistics(2L, Commentable.NON_COMMENTABLE, Votable.NON_VOTABLE,
                        Collections.emptyList(), 0.0, 0L),
                new ProductStatistics(3L, Commentable.COMMENTABLE_TO_ALL, Votable.VOTABLE_TO_ALL,
                        getLatestComments(3L), 4.0, 4L));
    }

    private List<Comment> getLatestComments(Long productId) {
        return List.of(new Comment(productId, getRandomCommentText(), getRandomName(), getRandomDate()),
                new Comment(productId, getRandomCommentText(), getRandomName(), getRandomDate()),
                new Comment(productId, getRandomCommentText(), getRandomName(), getRandomDate()));
    }

    String getRandomName() {
        List<String> names = List.of("masoome", "gelare", "hadi");
        Random random = new Random();
        return names.get(random.nextInt(3));
    }

    String getRandomCommentText() {
        List<String> names = List.of("fantastic", "not bad", "satisfying!");
        Random random = new Random();
        return names.get(random.nextInt(3));
    }

    Date getRandomDate() {
        ZonedDateTime now = ZonedDateTime.now();
        List<ZonedDateTime> dateList = List.of(now, now.minusDays(1), now.plusDays(1));
        Random random = new Random();
        return new Date(dateList.get(random.nextInt(3)).toEpochSecond());
    }
}

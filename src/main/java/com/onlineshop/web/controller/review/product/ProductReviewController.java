package com.onlineshop.web.controller.review.product;

/*
 * @author masoome.aghayari
 * @since 7/14/23
 */

import com.onlineshop.api.facade.ProductReviewFacade;
import com.onlineshop.api.model.ProductStatisticsResponseModel;
import com.onlineshop.api.model.StatisticsResponseModel;
import com.onlineshop.core.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ProductReviewFacade.BASE_PATH)
@RequiredArgsConstructor
public class ProductReviewController implements ProductReviewFacade {
    private final ProductService productService;

    @Override
    public StatisticsResponseModel<ProductStatisticsResponseModel> productsStatistics(int offset, int length) {
        return productService.getProductsStatistics(offset, length);
    }
}

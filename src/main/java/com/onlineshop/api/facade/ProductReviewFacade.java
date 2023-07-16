package com.onlineshop.api.facade;

import com.onlineshop.api.model.ProductStatisticsResponseModel;
import com.onlineshop.api.model.StatisticsResponseModel;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/*
 * @author masoome.aghayari
 * @since 7/14/23
 */
public interface ProductReviewFacade extends ReviewBaseFacade {
    String PRODUCT_STATISTICS = "/product/statistics";

    @GetMapping(value = PRODUCT_STATISTICS, produces = MediaType.APPLICATION_JSON_VALUE)
    StatisticsResponseModel<ProductStatisticsResponseModel> productsStatistics(
            @RequestParam(value = "offset", defaultValue = "0") int offset,
            @RequestParam(value = "length", defaultValue = "10") int length);

}

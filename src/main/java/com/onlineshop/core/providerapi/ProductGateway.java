package com.onlineshop.core.providerapi;

/*
 * @author masoome.aghayari
 * @since 7/13/23
 */

import com.onlineshop.core.entity.PageableStatistics;
import com.onlineshop.core.entity.ProductStatistics;

public interface ProductGateway {

    PageableStatistics<ProductStatistics> getProductsStatistics(int offset, int length);
}

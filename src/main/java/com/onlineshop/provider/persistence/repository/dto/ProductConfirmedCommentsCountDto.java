package com.onlineshop.provider.persistence.repository.dto;

/*
 * @author masoome.aghayari
 * @since 7/17/23
 */

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductConfirmedCommentsCountDto {
    Long productId;
    Long numberOfComments;
}

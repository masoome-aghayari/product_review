package com.onlineshop.provider.persistence.repository.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

/*
 * @author masoome.aghayari
 * @since 7/13/23
 */
@Data
@AllArgsConstructor
public class CommentDto {
    private String text;
    private String commenter;
    private Long productId;
    private Date commentDate;
}

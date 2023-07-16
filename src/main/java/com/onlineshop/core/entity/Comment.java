package com.onlineshop.core.entity;

/*
 * @author masoome.aghayari
 * @since 7/13/23
 */

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Comment {
    private Long productId;
    private String text;
    private String commenter;
    private Date commentDate;
}

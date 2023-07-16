package com.onlineshop.api.model;

/*
 * @author masoome.aghayari
 * @since 7/13/23
 */

import com.onlineshop.api.enummeration.Commentable;
import com.onlineshop.api.enummeration.Votable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductStatisticsResponseModel {
    private Long productId;
    private Commentable commentable;
    private Votable votable;
    private List<Comment> latestComments;
    private Double averageVoteScore;
    private Long numberOfComments;


}

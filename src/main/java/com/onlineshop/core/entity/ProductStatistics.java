package com.onlineshop.core.entity;

/*
 * @author masoome.aghayari
 * @since 7/13/23
 */

import com.onlineshop.core.enummeration.Commentable;
import com.onlineshop.core.enummeration.Votable;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ProductStatistics {
    private Long productId;
    private Commentable commentable;
    private Votable votable;
    private List<Comment> latestComments;
    private Double averageVoteScore;
    private Long numberOfComments;


}

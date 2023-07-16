package com.onlineshop.provider.persistence.repository.dto;

/*
 * @author masoome.aghayari
 * @since 7/13/23
 */

import com.onlineshop.provider.persistence.repository.enums.Commentable;
import com.onlineshop.provider.persistence.repository.enums.Votable;
import lombok.Data;

import java.util.List;

@Data
public class ProductStatisticsDto {
    private Long productId;
    private String name;
    private boolean visible;
    private Commentable commentable;
    private Votable votable;
    private List<CommentDto> latestComments;
    private Double averageVoteScore;
    private Long totalNumberOfComments;

    public ProductStatisticsDto(Long productId, String name, boolean visible, Commentable commentable, Votable votable,
                                Double averageVoteScore) {
        this.productId = productId;
        this.name = name;
        this.visible = visible;
        this.commentable = commentable;
        this.votable = votable;
        this.averageVoteScore = averageVoteScore;
    }
}

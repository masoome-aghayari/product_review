package com.onlineshop.core.service.mapper;

import com.onlineshop.api.model.ProductStatisticsResponseModel;
import com.onlineshop.core.entity.Comment;
import com.onlineshop.core.entity.ProductStatistics;
import com.onlineshop.core.enummeration.Commentable;
import com.onlineshop.core.enummeration.Votable;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;

/*
 * @author masoome.aghayari
 * @since 7/15/23
 */
@Component
@RequiredArgsConstructor

public class ProductStatisticsResponseAssembler {

    public List<ProductStatisticsResponseModel> toProductStatisticsResponseModelList(
            Collection<ProductStatistics> productStatisticsList) {
       return productStatisticsList.stream().map(this::toProductStatisticsResponseModel).toList();

    }

    public ProductStatisticsResponseModel toProductStatisticsResponseModel(ProductStatistics productStatistics) {
        return ProductStatisticsResponseModel.builder()
                .productId(productStatistics.getProductId())
                .votable(toApiVotable(productStatistics.getVotable()))
                .commentable(toApiCommentable(productStatistics.getCommentable()))
                .latestComments(toApiCommentModelList(productStatistics.getLatestComments()))
                .averageVoteScore(productStatistics.getAverageVoteScore())
                .numberOfComments(productStatistics.getNumberOfComments())
                .build();
    }

    public List<com.onlineshop.api.model.Comment> toApiCommentModelList(List<Comment> comments) {
        return comments.stream().map(this::toApiCommentModel).toList();
    }

    public com.onlineshop.api.model.Comment toApiCommentModel(Comment comment) {
        return com.onlineshop.api.model.Comment.builder()
                .productId(comment.getProductId())
                .text(comment.getText())
                .commenter(comment.getCommenter())
                .commentDate(comment.getCommentDate())
                .build();
    }

    public com.onlineshop.api.enummeration.Commentable toApiCommentable(Commentable commentable) {
        return switch (commentable) {
            case NON_COMMENTABLE -> com.onlineshop.api.enummeration.Commentable.NON_COMMENTABLE;
            case COMMENTABLE_TO_ALL -> com.onlineshop.api.enummeration.Commentable.COMMENTABLE_TO_ALL;
            case COMMENTABLE_TO_BUYERS -> com.onlineshop.api.enummeration.Commentable.COMMENTABLE_TO_BUYERS;
        };
    }

    public com.onlineshop.api.enummeration.Votable toApiVotable(Votable votable) {
        return switch (votable) {
            case NON_VOTABLE -> com.onlineshop.api.enummeration.Votable.NON_VOTABLE;
            case VOTABLE_TO_ALL -> com.onlineshop.api.enummeration.Votable.VOTABLE_TO_ALL;
            case VOTABLE_TO_BUYERS -> com.onlineshop.api.enummeration.Votable.VOTABLE_TO_BUYERS;
        };
    }
}

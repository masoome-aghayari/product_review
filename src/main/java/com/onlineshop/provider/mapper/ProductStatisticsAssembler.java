package com.onlineshop.provider.mapper;

import com.onlineshop.core.entity.Comment;
import com.onlineshop.core.entity.ProductStatistics;
import com.onlineshop.provider.persistence.repository.dto.CommentDto;
import com.onlineshop.provider.persistence.repository.dto.ProductStatisticsDto;
import com.onlineshop.provider.persistence.repository.enums.Commentable;
import com.onlineshop.provider.persistence.repository.enums.Votable;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 * @author masoome.aghayari
 * @since 7/14/23
 */
@Service
public class ProductStatisticsAssembler {

    public List<ProductStatistics> toProductStatisticsModelList(List<ProductStatisticsDto> productStatisticsDtos) {
        return productStatisticsDtos.stream().map(this::toProductStatisticsModel).toList();
    }

    public ProductStatistics toProductStatisticsModel(ProductStatisticsDto p) {
        return new ProductStatistics(p.getProductId(), toCoreCommentable(p.getCommentable()),
                toCoreVotable(p.getVotable()), p.getLatestComments().stream().map(this::toCoreComment).toList(),
                p.getAverageVoteScore(), p.getTotalNumberOfComments());
    }

    public com.onlineshop.core.enummeration.Commentable toCoreCommentable(Commentable commentable) {
        return switch (commentable) {
            case NON_COMMENTABLE -> com.onlineshop.core.enummeration.Commentable.NON_COMMENTABLE;
            case COMMENTABLE_TO_ALL -> com.onlineshop.core.enummeration.Commentable.COMMENTABLE_TO_ALL;
            case COMMENTABLE_TO_BUYERS -> com.onlineshop.core.enummeration.Commentable.COMMENTABLE_TO_BUYERS;
        };
    }

    public com.onlineshop.core.enummeration.Votable toCoreVotable(Votable votable) {
        return switch (votable) {
            case NON_VOTABLE -> com.onlineshop.core.enummeration.Votable.NON_VOTABLE;
            case VOTABLE_TO_ALL -> com.onlineshop.core.enummeration.Votable.VOTABLE_TO_ALL;
            case VOTABLE_TO_BUYERS -> com.onlineshop.core.enummeration.Votable.VOTABLE_TO_BUYERS;
        };
    }

    private Comment toCoreComment(CommentDto commentDto) {
        return Comment.builder()
                .productId(commentDto.getProductId())
                .text(commentDto.getText())
                .commenter(commentDto.getCommenter())
                .commentDate(commentDto.getCommentDate())
                .build();
    }

}

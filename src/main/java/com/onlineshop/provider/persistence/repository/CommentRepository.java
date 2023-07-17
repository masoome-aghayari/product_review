package com.onlineshop.provider.persistence.repository;

import com.onlineshop.provider.persistence.repository.dto.CommentDto;
import com.onlineshop.provider.persistence.repository.entity.Comment;
import com.onlineshop.provider.persistence.repository.enums.ConfirmationStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/*
 * @author masoome.aghayari
 * @since 7/13/23
 */
@Repository
public interface CommentRepository extends PagingAndSortingRepository<Comment, Long> {
    @Query(value = """
            SELECT new com.onlineshop.provider.persistence.repository.dto.CommentDto(
            c.text, c.user.username, c.product.id, c.commentDate)
                                        FROM Comment c
                                        WHERE c.confirmationStatus = :status and c.product.id = :productId
                                        GROUP BY c.product.id, c.text, c.user.username, c.commentDate
                                        ORDER BY c.commentDate
            """)
    Page<CommentDto> getLatestCommentsForProduct(@Param("productId") Long productId,
                                                 @Param("status") ConfirmationStatus status, Pageable pageable);

    @Query(value = """
            SELECT count(c.id) FROM Comment c
            WHERE c.confirmationStatus = :status AND c.product.id = :productId     
            """)
    Long countCommentsByConfirmationStatus(@Param("productId") Long productId,
                                           @Param("status") ConfirmationStatus status);

}

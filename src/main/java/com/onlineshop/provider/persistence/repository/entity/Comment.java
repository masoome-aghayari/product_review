package com.onlineshop.provider.persistence.repository.entity;

/*
 * @author masoome.aghayari
 * @since 7/13/23
 */

import com.onlineshop.provider.persistence.repository.enums.ConfirmationStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Setter
@Getter
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "comment_id_sequence_generator", sequenceName = "comment_id_generator", allocationSize = 1)
    @Column(name = "COMMENT_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "COMMENTER_ID")
    private User user;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;

    @Column(columnDefinition = "NVARCHAR(255)")
    private String text;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "CONFIRMATION_STATUS")
    private ConfirmationStatus confirmationStatus;

    @CreationTimestamp
    @Column(name = "COMMENT_DATE")
    private Date commentDate;
}

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
public class Vote {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "comment_id_sequence_generator", sequenceName = "comment_id_generator", allocationSize = 1)
    @Column(name = "VOTE_ID")
    private Long id;

    @Column(length = 5)
    private byte score;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "VOTER_ID")
    private User voter;

    @CreationTimestamp
    @Column(name = "VOTE_DATE")
    private Date voteDate;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "CONFIRMATION_STATUS")
    private ConfirmationStatus confirmationStatus;
}

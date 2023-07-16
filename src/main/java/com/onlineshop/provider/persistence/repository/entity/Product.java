package com.onlineshop.provider.persistence.repository.entity;

/*
 * @author masoome.aghayari
 * @since 7/13/23
 */
import com.onlineshop.provider.persistence.repository.enums.Commentable;
import com.onlineshop.provider.persistence.repository.enums.Votable;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;

@Entity
@Setter
@Getter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "product_id_sequence_generator", sequenceName = "product_id_generator", allocationSize = 1)
    @Column(name = "PRODUCT_ID")
    private Long id;

    @Column(columnDefinition = "NVARCHAR(32)")
    private String name;

    boolean visible;

    private BigInteger price;

    @Column(columnDefinition = "NVARCHAR(255)")
    private String description;

    @ManyToOne
    @JoinColumn(name = "PROVIDER_ID")
    private Provider provider;

    @Enumerated
    Commentable commentable;

    @Enumerated
    Votable votable;


}

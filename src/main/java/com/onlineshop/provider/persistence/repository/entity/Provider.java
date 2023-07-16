package com.onlineshop.provider.persistence.repository.entity;

/*
 * @author masoome.aghayari
 * @since 7/13/23
 */

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Provider {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "provider_id_sequence_generator", sequenceName = "provider_id_generator", allocationSize = 1)
    @Column(name = "PROVIDER_ID")
    private Long id;

    @Column(columnDefinition = "NVARCHAR(32)")
    private String name;
}

package com.onlineshop.provider.persistence.repository.entity;

/*
 * @author masoome.aghayari
 * @since 7/13/23
 */

import com.onlineshop.provider.persistence.repository.enums.RoleType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "role_id_sequence_generator", sequenceName = "role_id_generator", allocationSize = 1)
    @Column(name = "ROLE_ID")
    private Long id;

    @Column(columnDefinition = "NVARCHAR(32)")
    @Enumerated(value = EnumType.STRING)
    private RoleType name;
}

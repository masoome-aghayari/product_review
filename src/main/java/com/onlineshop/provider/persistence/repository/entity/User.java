package com.onlineshop.provider.persistence.repository.entity;

/*
 * @author masoome.aghayari
 * @since 7/13/23
 */

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "manager_id_sequence_generator", sequenceName = "manager_id_generator", allocationSize = 1)
    @Column(name = "USER_ID")
    private Long id;

    @Column(columnDefinition = "NVARCHAR(32)")
    private String username;

    @Column(columnDefinition = "NVARCHAR(16)")
    private String password;

    @ManyToMany
    @JoinTable(name = "USER_ROLE",
            joinColumns = @JoinColumn(name = "USER_ID"),
            inverseJoinColumns = @JoinColumn(name = "ROLE_ID"))
    Set<Role> roles;
}

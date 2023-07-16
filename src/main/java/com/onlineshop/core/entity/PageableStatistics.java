package com.onlineshop.core.entity;

/*
 * @author masoome.aghayari
 * @since 7/15/23
 */

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Collection;

@Data
@AllArgsConstructor
public class PageableStatistics<E> {
    private Collection<E> results;
    private boolean hasNextPage;
}

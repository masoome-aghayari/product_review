package com.onlineshop.provider.persistence.repository.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/*
 * @author masoome.aghayari
 * @since 7/13/23
 */
@RequiredArgsConstructor
@Getter
public enum Votable {
    VOTABLE_TO_ALL(1),
    VOTABLE_TO_BUYERS(2),
    NON_VOTABLE(3);

    private final int id;
}

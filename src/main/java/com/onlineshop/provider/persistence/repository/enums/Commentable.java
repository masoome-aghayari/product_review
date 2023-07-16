package com.onlineshop.provider.persistence.repository.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/*
 * @author masoome.aghayari
 * @since 7/13/23
 */
@RequiredArgsConstructor
@Getter
public enum Commentable {
    COMMENTABLE_TO_ALL(1),
    COMMENTABLE_TO_BUYERS(2),
    NON_COMMENTABLE(3);

    private final int id;

}

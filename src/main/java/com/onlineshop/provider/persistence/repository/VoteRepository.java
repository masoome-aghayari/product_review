package com.onlineshop.provider.persistence.repository;

import com.onlineshop.provider.persistence.repository.entity.Vote;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/*
 * @author masoome.aghayari
 * @since 7/13/23
 */
@Repository
public interface VoteRepository extends PagingAndSortingRepository<Vote, Long> {
}

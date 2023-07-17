package com.onlineshop.provider.persistence.repository;

/*
 * @author masoome.aghayari
 * @since 7/13/23
 */

import com.onlineshop.provider.persistence.repository.dto.ProductStatisticsDto;
import com.onlineshop.provider.persistence.repository.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {

    @Query(value = """
                SELECT new com.onlineshop.provider.persistence.repository.dto.ProductStatisticsDto(
                p.id ,p.name, p.visible, p.commentable, p.votable, AVG(v.score)) FROM Product p
                join Vote v on p.id = v.product.id
                where v.confirmationStatus = 'CONFIRMED' 
                group by p.id ,p.name, p.visible, p.commentable, p.votable
                order by p.id
                """)
    Page<ProductStatisticsDto> getProductsStatistics(Pageable pageable);
}

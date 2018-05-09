package com.pm.productretail.repository;

import com.pm.productretail.entity.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    List<Item> findAllByNameLikeIgnoreCaseOrderByName(String itemName);

    @Override
    Page<Item> findAll(Pageable pageable);
}

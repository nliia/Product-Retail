package com.pm.productretail.repository;

import com.pm.productretail.entity.OrderLinkItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderLinkItemRepository extends JpaRepository<OrderLinkItem, Long> {
}

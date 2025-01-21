package com.webii.comandas.repository;

import com.webii.comandas.domain.TabItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TabItemRepository extends JpaRepository<TabItem, Integer> {
}

package com.webii.comandas.repository;

import com.webii.comandas.domain.Tab;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TabRepository extends JpaRepository<Tab, Integer> {
}

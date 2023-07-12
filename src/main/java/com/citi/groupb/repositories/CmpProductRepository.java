package com.citi.groupb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.citi.groupb.models.CmpProduct;

@Repository
public interface CmpProductRepository extends JpaRepository<CmpProduct, Long>{

}

package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.product;
import com.example.demo.domain.product1;
import com.example.demo.domain.productkey;

public interface ProMasterRepo extends JpaRepository<product1, productkey> {

}

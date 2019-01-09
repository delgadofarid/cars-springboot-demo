package com.spring.workshop.carsspringbootdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.workshop.carsspringbootdemo.model.Role;

@Repository
public interface RoleJpaRepository extends JpaRepository<Role, Long> {

}

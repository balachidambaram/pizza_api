package com.fastspring.pizza.api.data.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fastspring.pizza.api.data.entity.Base;

public interface BaseRepository extends JpaRepository<Base, Integer> {

}

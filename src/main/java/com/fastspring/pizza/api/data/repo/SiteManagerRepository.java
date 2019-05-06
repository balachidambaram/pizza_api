package com.fastspring.pizza.api.data.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fastspring.pizza.api.data.entity.SiteManager;

public interface SiteManagerRepository extends JpaRepository<SiteManager, Integer> {

}

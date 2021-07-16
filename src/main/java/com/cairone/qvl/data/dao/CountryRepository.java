package com.cairone.qvl.data.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.cairone.qvl.data.model.CountryEntity;

public interface CountryRepository extends 
        JpaRepository<CountryEntity, Long>, 
        QuerydslPredicateExecutor<CountryEntity> {

}

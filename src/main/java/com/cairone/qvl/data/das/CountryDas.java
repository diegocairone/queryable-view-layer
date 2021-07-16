package com.cairone.qvl.data.das;

import java.util.function.Function;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cairone.qvl.data.dao.CountryRepository;
import com.cairone.qvl.data.model.CountryEntity;
import com.cairone.qvl.data.model.QCountryEntity;
import com.querydsl.core.types.Predicate;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CountryDas {
    
    private final CountryRepository countryRepository;
    
    @Transactional(readOnly = true)
    public Page<CountryEntity> findAll(Pageable pageable) {
        
        return findAll(null, pageable);
    }

    @Transactional(readOnly = true)
    public Page<CountryEntity> findAll(
            Function<QCountryEntity, Predicate> queryCallback, Pageable pageable) {
        
        return countryRepository.findAll(pageable);
    }
}

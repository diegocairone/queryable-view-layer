package com.cairone.qvl.core.service;

import java.util.function.Function;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cairone.qvl.core.helpers.PageModel;
import com.cairone.qvl.core.mapper.CountryMapper;
import com.cairone.qvl.core.model.CountryModel;
import com.cairone.qvl.data.das.CountryDas;
import com.cairone.qvl.data.model.QCountryEntity;
import com.querydsl.core.types.Predicate;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CountryService {

    private final CountryMapper countryMapper;
    
    private final CountryDas countryDas;
    
    @Transactional(readOnly = true)
    public PageModel<CountryModel> findAll(String expression, Pageable pageable) {
        
        Function<QCountryEntity, Predicate> query = q -> q.id.gt(0L);
        
        // Expectations ...
        /*
        Function<QCountryEntity, Predicate> query = q -> parser.f(??).parse(expression);
        */
        
        Page<CountryModel> page = countryDas.findAll(query, pageable).map(countryMapper::map);
        return PageModel.of(page);
    }
}

package com.cairone.qvl.core.mapper;

import org.mapstruct.Mapper;

import com.cairone.qvl.core.model.CountryModel;
import com.cairone.qvl.data.model.CountryEntity;

@Mapper(componentModel = "spring")
public interface CountryMapper {

    CountryModel map(CountryEntity countryEntity);
}

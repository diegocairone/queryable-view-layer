package com.cairone.qvl.data.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.cairone.qvl.data.enums.Region;

@Converter(autoApply = true)
public class RegionConverter implements AttributeConverter<Region, Integer> {

    @Override
    public Integer convertToDatabaseColumn(Region attribute) {
        return attribute.getValue();
    }

    @Override
    public Region convertToEntityAttribute(Integer dbData) {
        return Region.of(dbData);
    }
}
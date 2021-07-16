package com.cairone.qvl.core.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CountryModel {

    private Long id;

    private String name;

    private String alpha2Code;

    private String alpha3Code;

    private Integer phoneCode;

}

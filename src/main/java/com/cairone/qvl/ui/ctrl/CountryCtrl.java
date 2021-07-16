package com.cairone.qvl.ui.ctrl;

import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cairone.qvl.core.helpers.PageModel;
import com.cairone.qvl.core.model.CountryModel;
import com.cairone.qvl.core.service.CountryService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/countries")
@RequiredArgsConstructor
public class CountryCtrl {

    private final CountryService countryService;
    
    @GetMapping
    public ResponseEntity<PageModel<CountryModel>> findAll(
            @RequestParam(name = "filter", required = false) String expression,
            @PageableDefault(size = 100) Pageable pageable) {
        
        PageModel<CountryModel> countries = countryService.findAll(expression, pageable);
        return ResponseEntity.ok(countries);
    }
}

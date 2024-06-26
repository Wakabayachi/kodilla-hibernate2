package com.example.demo.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {
    @Autowired
    private CompanyRepository companyRepository;

    @GetMapping("/by-prefix")
    public List<Company> getCompaniesByPrefix(@RequestParam String prefix) {
        return companyRepository.findByFirstThreeCharacters(prefix);
    }
}
package com.example.demo.entity;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CompanyDaoTestSuite {
    @Autowired
    private CompanyRepository companyRepository;

    @Test
    public void testFindByFirstThreeCharacters() {
        // Given
        Company company1 = new Company(null, "AlphaTech");
        Company company2 = new Company(null, "BetaSoft");
        companyRepository.save(company1);
        companyRepository.save(company2);

        // When
        List<Company> companies = companyRepository.findByFirstThreeCharacters("Alp");

        // Then
        assertEquals(1, companies.size());
        assertEquals("AlphaTech", companies.get(0).getName());

        // Clean up
        companyRepository.deleteAll();
    }
}
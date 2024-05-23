package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@NamedNativeQueries({
        @NamedNativeQuery(
                name = "Company.findByFirstThreeCharacters",
                query = "SELECT * FROM Company WHERE SUBSTRING(name, 1, 3) = :prefix",
                resultClass = Company.class
        )
})
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
}
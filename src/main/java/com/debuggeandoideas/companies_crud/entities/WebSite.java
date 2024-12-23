package com.debuggeandoideas.companies_crud.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import org.hibernate.query.sql.internal.ParameterRecognizerImpl;

import java.io.Serializable;

@Entity
@Data
public class WebSite implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(columnDefinition = "category")
    @Enumerated(value = EnumType.STRING)
    private Category category;
    private String description;

}

package com.dm.training.ms.beercatalogservice.data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Beer {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    public Beer(String name) {
        this.name = name;
    }

}
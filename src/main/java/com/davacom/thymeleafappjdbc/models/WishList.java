package com.davacom.thymeleafappjdbc.models;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

    @Getter
    @Setter
    @Entity
    @NoArgsConstructor
    @AllArgsConstructor
    @Table(name= "wish_list")

    public class WishList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String price;
    private String category;
    private int Quantity;

    }

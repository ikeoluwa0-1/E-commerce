package com.davacom.thymeleafappjdbc.models;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
@Builder
@Table(name= "login")

public class Admin {
    @Id
    private Long id;
    private String email;
    private String password;
}

package com.example.admin.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name ="admin")
public class Admin {

    @Id
    private String email;
    private String password;
}

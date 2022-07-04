package com.davacom.thymeleafappjdbc.models;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user_tbl")
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String fullName;
    private String email;
    private String password;
}

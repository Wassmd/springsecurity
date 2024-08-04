package com.paxier.springsecurity.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "users")
public class UserEntity {
    @Id
    private Long id;
    private String username;
    private String password;
}

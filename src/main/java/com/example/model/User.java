package com.example.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Entity;

@Entity
@Data
@NoArgsConstructor
public class User {

    private String firstName;
    private String lastName;

}

package com.backend.entity;

import jakarta.persistence.*;
import lombok.Data; // Assuming you use Lombok. If not, add Getters/Setters manually.
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "skills")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    // Constructor for convenience
    public Skill(String name) {
        this.name = name;
    }
}
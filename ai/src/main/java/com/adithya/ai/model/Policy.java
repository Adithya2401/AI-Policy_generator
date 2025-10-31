package com.adithya.ai.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Policy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String policyType;

    @Column(columnDefinition = "TEXT")
    private String content;

    private String createdBy;
    private String createdAt;
}

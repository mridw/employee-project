package org.azalio.em_project.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="emp_db")
public class EmEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String phone;
    private String email;
}

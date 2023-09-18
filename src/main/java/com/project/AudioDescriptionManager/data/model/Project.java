package com.project.AudioDescriptionManager.data.model;

import com.project.AudioDescriptionManager.data.enums.Type;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
@Table(name = "tb_projects")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Project implements Serializable {
    private  static final Long serialUIdVersion = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_project;
    @Column(length = 39, nullable = false)
    private String projectName;
    private String description;
    private BigDecimal valuePerMinut;
    @Column(nullable = false)
    private Integer duration;
    @Enumerated(EnumType.STRING)
    private Type category;
    private BigDecimal totalValue;
}

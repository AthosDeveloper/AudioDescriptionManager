package com.project.AudioDescriptionManager.data.model;

import com.project.AudioDescriptionManager.data.enums.Position;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
@Table(name = "tb_users")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User implements Serializable {
    private static final Long serialUIdVersion = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_user;
    @Column(nullable = false)
    private String name;


    @Enumerated(EnumType.STRING)
private Position position;
    @ManyToOne
    @JoinColumn(name = "id_project")
private  Project project;
    private BigDecimal percentage;
private BigDecimal valueToReceive;
}

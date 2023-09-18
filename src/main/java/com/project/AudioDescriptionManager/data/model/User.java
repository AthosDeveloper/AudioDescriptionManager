package com.project.AudioDescriptionManager.data.model;

import com.project.AudioDescriptionManager.data.enums.Position;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
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
    @ManyToMany
    @JoinTable(name = "TB_USERS_PROJECTS", joinColumns = @JoinColumn(name = "id_user"),
            inverseJoinColumns = @JoinColumn(name = "id_project"))
private List<Project> projects;
private BigDecimal percentage;
private BigDecimal valueToReceive;
}

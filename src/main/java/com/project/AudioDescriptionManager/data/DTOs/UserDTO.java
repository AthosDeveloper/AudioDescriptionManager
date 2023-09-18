package com.project.AudioDescriptionManager.data.DTOs;

import com.project.AudioDescriptionManager.data.enums.Position;
import com.project.AudioDescriptionManager.data.model.Project;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.math.BigDecimal;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDTO {
    private String name;

    private Position position;
    private List<Project> projects;
    private BigDecimal percentage;
    private BigDecimal valueToReceive;

}

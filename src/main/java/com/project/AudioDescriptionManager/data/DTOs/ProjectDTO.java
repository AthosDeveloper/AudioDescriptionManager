package com.project.AudioDescriptionManager.data.DTOs;

import com.project.AudioDescriptionManager.data.enums.Type;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProjectDTO {
    private String projectName;
    private String description;
    private BigDecimal valuePerMinut;
    private Integer duration;


    private Type category;
    private BigDecimal totalValue;

}

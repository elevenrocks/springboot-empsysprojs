package org.lanqiao.empsys.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SalaryGrade implements Serializable {
    private static final long serialVersionUID = 1982393902802197817L;
    private Integer grade;

    private Integer losal;

    private Integer hisal;
}
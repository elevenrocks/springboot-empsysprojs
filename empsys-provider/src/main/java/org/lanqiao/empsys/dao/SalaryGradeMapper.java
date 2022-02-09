package org.lanqiao.empsys.dao;

import org.lanqiao.empsys.domain.SalaryGrade;

public interface SalaryGradeMapper {
    int insert(SalaryGrade record);

    int insertSelective(SalaryGrade record);
}
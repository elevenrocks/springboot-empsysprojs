package org.lanqiao.empsys.dao;

import org.lanqiao.empsys.domain.Department;

public interface DepartmentMapper {
    int deleteByPrimaryKey(Integer deptno);

    int insert(Department record);

    int insertSelective(Department record);

    Department selectByPrimaryKey(Integer deptno);

    int updateByPrimaryKeySelective(Department record);

    int updateByPrimaryKey(Department record);
}
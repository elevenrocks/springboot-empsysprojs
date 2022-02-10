package org.lanqiao.empsys.dao;

import org.apache.ibatis.annotations.Param;
import org.lanqiao.empsys.domain.Employee;

import java.util.List;

public interface EmployeeMapper {
    int deleteByPrimaryKey(Integer empno);

    int insert(Employee record);

    int insertSelective(Employee record);

    Employee selectByPrimaryKey(Integer empno);

    int updateByPrimaryKeySelective(Employee record);

    int updateByPrimaryKey(Employee record);

    List<Employee> selectBySelective(@Param("employee") Employee record);
}
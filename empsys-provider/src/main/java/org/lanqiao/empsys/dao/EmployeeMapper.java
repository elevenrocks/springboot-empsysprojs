package org.lanqiao.empsys.dao;

import org.lanqiao.empsys.domain.Employee;

import java.util.List;

public interface EmployeeMapper {
    int deleteByPrimaryKey(Integer empno);

    int insert(Employee record);

    int insertSelective(Employee record);

    Employee selectByPrimaryKey(Integer empno);

    int updateByPrimaryKeySelective(Employee record);

    int updateByPrimaryKey(Employee record);

    List<Employee> selectBySelective(Employee record, int pageNum, int pageSize);
}
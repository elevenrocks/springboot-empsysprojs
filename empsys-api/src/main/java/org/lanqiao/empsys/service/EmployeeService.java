package org.lanqiao.empsys.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.lanqiao.empsys.domain.Employee;

import java.util.List;

public interface EmployeeService {

    int deleteByPrimaryKey(Integer id);

    int insert(Employee record);

    int insertSelective(Employee record);

    Employee selectByPrimaryKey(Integer id);

    PageInfo<Employee> selectBySelective(Employee record, int pageNum, int pageSize);

    int updateByPrimaryKeySelective(Employee record);

    int updateByPrimaryKey(Employee record);
}

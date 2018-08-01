package com.tingyun.dao;

import com.tingyun.entity.Emp;

import java.util.List;

public interface MySQLMapper {

    public int addEmp(Emp emp);

    public int deleteEmp();

    public int updateEmp();

    public List<Emp> findAllEmp();

}

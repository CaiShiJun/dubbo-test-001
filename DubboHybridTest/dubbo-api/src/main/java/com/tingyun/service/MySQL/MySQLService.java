package com.tingyun.service.MySQL;

import com.tingyun.entity.Emp;

import java.util.List;

public interface MySQLService {

    public int addEmp(Emp emp);

    public int deleteEmp();

    public int updateEmp();

    public List<Emp> findAllEmp();

}

package top.ulna520.tlias.mapper;

import org.apache.ibatis.annotations.Mapper;
import top.ulna520.tlias.model.Dept;


import java.util.List;

@Mapper
public interface DeptMapper {

    List<Dept> selectAll();


    void deleteById(int id);

    void insertDept(Dept dept);

    Dept selectById(int id);

    void updateDept(Dept dept);
}


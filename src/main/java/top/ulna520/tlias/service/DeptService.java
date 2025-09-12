package top.ulna520.tlias.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.ulna520.tlias.mapper.DeptMapper;
import top.ulna520.tlias.model.Dept;

import java.util.List;

@Service
public class DeptService {

    @Autowired
    private DeptMapper deptMapper;

    public List<Dept> getAllDept(){
        return deptMapper.selectAll();
    }

    public void deleteDeptById(int id){
            deptMapper.deleteById(id);
    }

    public void addDept(Dept dept) {
        deptMapper.insertDept(dept);
    }

    public void updateDept(Dept dept) {
        deptMapper.updateDept(dept);
    }
}

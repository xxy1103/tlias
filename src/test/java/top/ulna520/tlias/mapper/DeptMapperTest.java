package top.ulna520.tlias.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.ulna520.tlias.model.Dept;

import java.util.Date;

@SpringBootTest
public class DeptMapperTest {

    @Autowired
    private DeptMapper deptMapper;

    @Test
    public void testInsertDept(){
        Dept dept=new Dept();
        dept.setName("测试1");
        dept.setCreateTime(new Date());
        dept.setUpdateTime(new Date());
        deptMapper.insertDept(dept);
    }

    @Test
    public void testDeleteDeptById(){
        deptMapper.deleteById(1);
    }

    @Test
    public void testSelectAll(){
        deptMapper.selectAll().forEach(System.out::println);
    }

    @Test
    public void testSelectDeptById(){
        System.out.println(deptMapper.selectById(2));
    }

    @Test
    public void testUpdateDept() {
        Dept dept = new Dept();
        dept.setId(6);
        dept.setName("测试6");
        deptMapper.updateDept(dept);
    }
}

package top.ulna520.tlias.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.ulna520.tlias.model.Dept;
import top.ulna520.tlias.model.Result;
import top.ulna520.tlias.service.DeptService;

import java.util.Date;

@Slf4j
@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    @GetMapping("/depts")
    public Result depts(){
        log.info("获取所有部门");
        return new Result(1,"success",deptService.getAllDept());
    }

    @DeleteMapping("/depts/{id}")
    public Result deleteDeptById(@PathVariable int id){
        try{
            deptService.deleteDeptById(id);
            return new Result(1,"success",null);
        } catch(Exception e){
            log.error("删除部门失败",e);
            return new Result(0, "删除错误:"+e,null);
        }
    }

    @PostMapping("/depts")
    public Result addDept(@RequestBody Dept dept){
        dept.setCreateTime(new Date());
        dept.setUpdateTime(new Date());
        try {
            deptService.addDept(dept);
            log.info("添加部门成功,创建时间:{}",dept.getCreateTime());
            return new Result(1,"success",null);
        } catch (Exception e) {
            log.error("添加部门失败",e);
            return new Result(0, "添加失败:"+e,null);
        }
    }

    @PutMapping("/depts")
    public Result updateDept(@RequestBody Dept dept){
        dept.setUpdateTime(new Date());
        try {
            deptService.updateDept(dept);
            log.info("更新部门成功,更新时间:{}",dept.getUpdateTime());
            return new Result(1,"success",null);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}

package top.ulna520.tlias.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import top.ulna520.tlias.mapper.DeptMapper;
import top.ulna520.tlias.model.Dept;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class DeptServiceTest {
    @Mock
    private DeptMapper deptMapper;

    @InjectMocks
    private DeptService deptService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllDept() {
        Dept dept1 = new Dept();
        Dept dept2 = new Dept();
        List<Dept> deptList = Arrays.asList(dept1, dept2);
        when(deptMapper.selectAll()).thenReturn(deptList);
        List<Dept> result = deptService.getAllDept();
        assertEquals(2, result.size());
        verify(deptMapper, times(1)).selectAll();
    }

    @Test
    void testDeleteDeptById() {
        int id = 1;
        deptService.deleteDeptById(id);
        verify(deptMapper, times(1)).deleteById(id);
    }

    @Test
    void testAddDept() {
        Dept dept = new Dept();
        deptService.addDept(dept);
        verify(deptMapper, times(1)).insertDept(dept);
    }
}


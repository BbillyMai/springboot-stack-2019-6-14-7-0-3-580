package com.tw.apistackbase;

import com.tw.apistackbase.Service.EmployeeService;
import com.tw.apistackbase.controller.EmployeeController;
import com.tw.apistackbase.model.Employee;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(SpringExtension.class)
@WebMvcTest(EmployeeController.class)
public class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeeService employeeService;

    @Test
    public void test() throws Exception {
        Employee employee = new Employee();
        employee.setAge(12);
        employee.setGender("female");
        employee.setId("1111");
        employee.setName("xiaoming");

        when(employeeService.findById(anyString())).thenReturn(employee);

        ResultActions resultActions = mockMvc.perform(get("/employees/{employeeId}", employee.getId()));

        resultActions.andExpect(status().isOk())
                .andExpect(jsonPath("$.name",is("xiaoming")))
                .andExpect(jsonPath("$.age",is(20)))
                .andExpect(jsonPath("$.gender",is("female")));
    }

}

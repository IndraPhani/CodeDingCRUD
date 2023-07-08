package com.example.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootApplication
class EmployeeServiceTest {
    @Autowired
    public EmployeeService empServ;
    @Test
    public void testMockingData(){
       // given(empServ).when()
    }

}
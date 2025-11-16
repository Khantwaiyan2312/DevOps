package com.napier.sem;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
public class AppIntegrationTest {
    static App app;

    @BeforeAll
    static void init()
    {
        app = new App();
        app.connect("localhost:33060", 30000);

    }

    @Test
    void testGetEmployee()
    {
        Employee emp_no = app.getEmployee(255530);
        assertEquals(255530, emp_no.emp_no);
        assertEquals("Ronghao", emp_no.first_name);
        assertEquals("Garigliano", emp_no.last_name);
    }
}

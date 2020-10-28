package com.quercusdata.awsspringboot.web;

import com.quercusdata.awsspringboot.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
//@Runwith(SpringRunner.class)
@ExtendWith(SpringExtension.class)
public class HelloWorldWSTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    UserServiceImpl userService;

    @Test
    public void helloWorldWithNameNoGenderTest() throws Exception {
        String name = "Pepe";
        mockMvc.perform(
                get("/")
                .param("name", name)
        ).andExpect(
                status().isOk()
        ).andExpect(
                content().string(containsString("Hello, Pepe"))
        );
    }

    @Test
    public void helloWorldWithNameAndMaleTest() throws Exception {
        String name = "Pepe";
        String gender = "male";
        mockMvc.perform(
                get("/")
                        .param("name", name)
                        .param("gender", gender)
        ).andExpect(
                status().isOk()
        ).andExpect(
                content().string(containsString("Hello, Mr Pepe"))
        );
    }

    @Test
    public void helloWorldWithNameAndFemaleTest() throws Exception {
        String name = "Pepa";
        String gender = "female";
        mockMvc.perform(
                get("/")
                        .param("name", name)
                        .param("gender", gender)
        ).andExpect(
                status().isOk()
        ).andExpect(
                content().string(containsString("Hello, Mrs Pepa"))
        );
    }

    @Test
    public void helloWorldNoNameNoGenderTest() throws Exception {
        String name = "";
        mockMvc.perform(
                get("/")
                        .param("name", name)
        ).andExpect(
                status().isOk()
        ).andExpect(
                content().string(containsString("Hello, World"))
        );
    }
}


package com.quercusdata.awsspringboot.web;

import com.quercusdata.awsspringboot.model.UserModel;
import com.quercusdata.awsspringboot.service.impl.UserServiceImpl;
import com.quercusdata.awsspringboot.util.TestDTOData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(UserWS.class)
public class UserWSTest {

    @Autowired
    private MockMvc             mvc;

    @MockBean
    private UserServiceImpl     userServiceImpl;


    @Test
    public void getUserByIdTest() throws Exception {

        UserModel userModel = TestDTOData.generateUser(1L, "john", "123");
        Mockito.when(userServiceImpl.findById(1L)).thenReturn( userModel);

        mvc.perform(get("/user/1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", equalTo(1)))
                .andExpect(jsonPath("$.username", equalTo("john")))
                .andExpect(jsonPath("$.password", equalTo("123")));
    }

    @Test
    public void createUserTest() throws Exception {

        UserModel userModel = TestDTOData.generateUser(null, "john", "123");
        Mockito.when(userServiceImpl.createUser(userModel)).thenReturn( userModel);

        mvc.perform(post("/user").contentType( MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(TestDTOData.asJsonString( userModel)))
                .andExpect(status().isOk());
                //.andExpect(jsonPath("$.username", equalTo("john")))
                //.andExpect(jsonPath("$.password", equalTo("123")));
    }
}

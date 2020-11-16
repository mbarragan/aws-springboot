package com.quercusdata.awsspringboot.web;

import com.quercusdata.awsspringboot.model.UserModel;
import com.quercusdata.awsspringboot.service.UserService;
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

import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(UserWS.class)
public class UserWSTest {

    @Autowired
    private MockMvc             mvc;

    @MockBean
    private UserService userService;


    @Test
    public void getUserByIdTest() throws Exception {

        UserModel userModel = TestDTOData.generateUser(1L, "john", "123");
        Mockito.when(userService.findById(1L)).thenReturn( userModel);

        mvc.perform(get("/user/1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", equalTo(1)))
                .andExpect(jsonPath("$.username", equalTo("john")))
                .andExpect(jsonPath("$.password", equalTo("123")));
    }

    @Test
    public void createUserTest() throws Exception {

        UserModel userModel = TestDTOData.generateUser(1L, "john", "123");
        Mockito.when(userService.createUser(userModel)).thenReturn( userModel);

        mvc.perform(post("/user").contentType( MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(TestDTOData.asJsonString( userModel)))
                .andExpect(status().isOk());
                //.andExpect(jsonPath("$.password", equalTo("123")));
    }

    @Test
    public void getUsersTest() throws Exception {

        List<UserModel> users = Collections.singletonList(TestDTOData.generateUser(1L, null, null));
        Mockito.when(userService.getUsers()).thenReturn( users);

        mvc.perform(get("/user").contentType( MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id", equalTo(1)));

    }

    @Test
    public void updateUserTest() throws Exception {

        UserModel mockUserToUpdate = TestDTOData.generateUser(null, "john doe", "123");
        UserModel mockUserReturned = TestDTOData.generateUser(1L, "john doe", "123");
        Mockito.when(userService.updateUser(1L, mockUserToUpdate)).thenReturn( mockUserReturned);

        mvc.perform(put("/user/1").contentType( MediaType.APPLICATION_JSON)
                .accept( MediaType.APPLICATION_JSON)
                .content( TestDTOData.asJsonString( mockUserToUpdate)))
                .andExpect(status().isOk());
//                .andExpect(jsonPath("$.password", equalTo("123")));

//        .andExpect(content()
//              .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
//              .andExpect(jsonPath("$[0].name", is("bob"))));
    }

    @Test
    public void deleteUserTest() throws Exception {

        mvc.perform(delete("/user/1").contentType( MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk());

    }
}

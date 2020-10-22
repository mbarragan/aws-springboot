package com.quercusdata.awsspringboot.repository;

import com.quercusdata.awsspringboot.entity.User;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
import com.quercusdata.awsspringboot.model.PUser;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;

//@WebMvcTest
//@ExtendWith(SpringExtension.class)
@RunWith(SpringRunner.class)
//@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
//@AutoConfigureTestDatabase(replace= NONE)
//@TestPropertySource("/test.properties")
public class UserRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository userRepository;

    @Test
    @Ignore
    public void createUserTest() {
        PUser pUser = generatePUser();

        PUser returnedPUser = userRepository.save(pUser);

        assertEquals(returnedPUser.getUserName(), pUser.getUserName());
        assertEquals(returnedPUser.getPassword(), pUser.getPassword());
    }

    @Test
    @Ignore
    public void getUserByIdTest() {
        PUser pUser = generatePUser();
        entityManager.persist(pUser);
        entityManager.flush();

        Optional<PUser> returnedPUser = userRepository.findById(1L);
        //Mockito.when(userRepository.findById(1L)).thenReturn(Optional.of(user));

        assertThat(returnedPUser.get().getUserName())
                .isEqualTo(pUser.getUserName());
        assertEquals(pUser.getId(), returnedPUser.get().getId());
    }

    private PUser generatePUser() {
        PUser user = new PUser();
        user.setId(1L);
        user.setUserName("pepe");
        user.setPassword("1234");
        return user;
    }

    private void persistData() {

    }
}

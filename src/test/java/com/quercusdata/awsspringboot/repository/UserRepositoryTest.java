package com.quercusdata.awsspringboot.repository;

//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
import com.quercusdata.awsspringboot.entity.User;
import com.quercusdata.awsspringboot.model.UserModel;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
        import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
        User user = generateUserEntity();

        User returnedUser = userRepository.save(user);

        assertEquals(returnedUser.getUsername(), user.getUsername());
        assertEquals(returnedUser.getPassword(), user.getPassword());
    }

    @Test
    @Ignore
    public void getUserByIdTest() {
        User user = generateUserEntity();
        entityManager.persist(user);
        entityManager.flush();

        Optional<User> returnedUser = userRepository.findById(1L);
        //Mockito.when(userRepository.findById(1L)).thenReturn(Optional.of(user));

        assertThat(returnedUser.get().getUsername())
                .isEqualTo(user.getUsername());
        assertEquals(user.getId(), returnedUser.get().getId());
    }

    private User generateUserEntity() {
        User user = new User();
        user.setId(1L);
        user.setUsername("pepe");
        user.setPassword("1234");
        return user;
    }

    private void persistData() {

    }
}

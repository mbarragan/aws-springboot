package com.quercusdata.awsspringboot.repository;

import com.quercusdata.awsspringboot.entity.User;
import com.quercusdata.awsspringboot.util.TestEntitiesData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void createUserTest() {
        User user = TestEntitiesData.generateEntityUser(1L, "john", "123");

        User returnedUser = userRepository.save(user);

        assertEquals(returnedUser.getUsername(), user.getUsername());
        assertEquals(returnedUser.getPassword(), user.getPassword());
    }

    @Test
    public void getUserByIdTest() {
        User user = TestEntitiesData.generateEntityUser(1L, "john", "123");
        user = entityManager.merge(user);
        entityManager.flush();

        Optional<User> returnedUser = userRepository.findById( user.getId());
        if(returnedUser.isPresent()) {
            assertThat(returnedUser.get().getUsername()).isEqualTo(user.getUsername());
            assertThat(returnedUser.get().getPassword()).isEqualTo(user.getPassword());
            assertEquals(user.getId(), returnedUser.get().getId());
        }
    }

}

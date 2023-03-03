package com.postagram.dao;

import com.postagram.domain.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static com.postagram.controller.UserControllerTest.createValidUser;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@ActiveProfiles("test")
public class UserRepositoryTest {

    @Autowired
    TestEntityManager testEntityManager;

    @Autowired
    UserRepository userRepository;

    @Test
    public void findByUsername_whenUserExists_returnsUser() {
        testEntityManager.persist(createValidUser());

        User inDB = userRepository.findByUsername("test-user");
        assertThat(inDB).isNotNull();

    }

    @Test
    public void findByUsername_whenUserDoesNotExist_returnsNull() {
        User inDataBase = userRepository.findByUsername("nonexistinguser");
        assertThat(inDataBase).isNull();
    }
}
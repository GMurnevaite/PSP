package com.psp3.repository;

import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.jupiter.api.Test;
import com.psp3.model.User;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Optional;
import java.util.List;

@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository repository;
    User user = new User(1L, "Luka","Liukaite","866123456","luka@email.com","Vilniaus g. 7","Manopass@");

    @Test
    public void save_Test(){
        repository.save(user);
        Optional<User> userById = repository.findById(1L);

        assertNotNull(userById);
    }

    @Test
    public void findAll_Test(){
        repository.save(user);
        Iterable<User> users = repository.findAll();
        assertNotNull(users);
        List<User> result = new ArrayList<>();
        users.forEach(result::add);

        assertEquals(1, result.size());
    }

    @Test
    public void delete_Test(){
        repository.save(user);
        repository.deleteById(1L);
        Iterable<User> users = repository.findAll();
        assertNotNull(user);
        List<User> result = new ArrayList<>();
        users.forEach(result::add);

        assertEquals(0, result.size());
    }
}
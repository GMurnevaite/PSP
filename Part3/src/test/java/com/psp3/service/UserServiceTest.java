package com.psp3.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;
import com.psp3.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import com.psp3.model.User;
import org.mockito.Mockito;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.Optional;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @InjectMocks
    UserService service;
    @Mock
    UserRepository repository;
    User user = new User();

    @Test
    void findAll_Test(){
        List<User> userList = new ArrayList<>();
        userList.add(user);
        when(repository.findAll()).thenReturn(userList);
        var found = service.findAll();
        verify(repository).findAll();

        assertEquals(1, found.size());
    }

    @Test
    void findById_Test(){
        when(repository.findById(anyLong())).thenReturn(java.util.Optional.of(user));
        Optional<User> found = service.findById(1L);
        verify(repository).findById(anyLong());

        assertNotNull(found);
    }

    @Test
    void add_Test(){
        when(repository.save(Mockito.any(User.class))).thenReturn(user);
        User added = service.add(user);
        verify(repository).save(Mockito.any(User.class));

        assertNotNull(added);
    }

    @Test
    void deleteByIdTest(){
        service.deleteById(1L);
        verify(repository).deleteById(Mockito.anyLong());
    }

    @Test
    void delete_Test(){
        service.delete(user);
        verify(repository).delete(Mockito.any(User.class));
    }

    @Test
    void update_Test(){
        service.update(user);
        verify(repository).save(Mockito.any(User.class));
    }
}

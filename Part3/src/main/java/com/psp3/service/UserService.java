package com.psp3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.psp3.repository.UserRepository;
import com.psp3.model.User;
import java.util.Optional;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll(){return (List<User>)repository.findAll();}

    public Optional<User> findById(Long userId){return repository.findById(userId);}

    public void update(User user){repository.save(user);}

    public User add(User user){return repository.save(user);}

    public void deleteById(Long userId){repository.deleteById(userId);}

    public void delete(User user){repository.delete(user);}

    public Long findMaxId(){
        Iterable<User> user = repository.findAll();
        Long max = 0L;
        for (User item: user) {
            if (item.getUserId() <= max) {
                continue;
            }
            max = item.getUserId();
        }
        return max;
    }
}

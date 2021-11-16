package com.psp3.repository;

import org.springframework.data.repository.CrudRepository;
import com.psp3.model.User;

public interface UserRepository extends CrudRepository<User, Long> {

}
package com.prueba.api.Dao;

import com.prueba.api.Entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserDao extends CrudRepository<User,Long> {

}

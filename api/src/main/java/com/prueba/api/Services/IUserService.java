package com.prueba.api.Services;

import com.prueba.api.Entity.User;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface IUserService {

    public List<User> findAllUsers();

    public Optional<User> findById(Long id);

    public HttpStatus save(User user);

    public  User updatePartial(Long id, Map<String,Object> fields);

    public void Delete(Long id);
}

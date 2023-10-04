package com.prueba.api.Services;

import com.prueba.api.Dao.UserDao;
import com.prueba.api.Entity.User;
import org.apache.el.util.ReflectionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService{

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> findAllUsers() {
        return (List<User>) userDao.findAll();
    }

    @Override
    public Optional<User> findById(Long id) {
        return  userDao.findById(id);
    }

    @Override
    public HttpStatus save(User user) {
        try{
            userDao.save(user);
        }catch (Exception e){
            return HttpStatus.CONFLICT;
        }
        return HttpStatus.CREATED;


    }

    @Override
    public User updatePartial(Long id, Map<String, Object> fields) {
       Optional<User> userFilter=userDao.findById(id);


       if(userFilter.isPresent()){

            fields.forEach((key,value)->{

                Field field=ReflectionUtils.findField(User.class,key);
                field.setAccessible(true);
                ReflectionUtils.setField(field,userFilter.get(),value);
            });

           return userDao.save(userFilter.get());
        }

        return null;
    }

    @Override
    public void Delete(Long id) {
        userDao.deleteById(id);
    }


}

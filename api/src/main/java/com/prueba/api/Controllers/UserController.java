package com.prueba.api.Controllers;

import com.prueba.api.Entity.User;
import com.prueba.api.Services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private IUserService iUserService;

    @GetMapping(path = "/users")
    public List<User> findAll(){
        return iUserService.findAllUsers();
    }

    @PostMapping(path = "/users")
    public HttpStatus save(@RequestBody User user){
        return iUserService.save(user);
    }

    @GetMapping(path = "/users/{id}")
    public ResponseEntity<User> findId(@PathVariable Long id) {
        Optional<User> userFilter = iUserService.findById(id);

        if (userFilter.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        // Si se encuentra el usuario, devolverlo en una respuesta HTTP con un código de estado 200 (OK)
        return ResponseEntity.ok(userFilter.get());
    }

    @PatchMapping(path = "/users/{id}")
    public User updatePartial(@PathVariable Long id,@RequestBody Map<String,Object> fields){

        return  iUserService.updatePartial(id,fields);
    }

    @DeleteMapping(path = "users/{id}")
    public HttpStatus deleteOne(@PathVariable Long id){
        try{
            iUserService.Delete(id);
        }catch (Exception e){
            return HttpStatus.BAD_REQUEST;
        }

        return HttpStatus.OK;

    }




}

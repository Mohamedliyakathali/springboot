package com.ShoppingMallManagement.UserService.Entity;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ShoppingMallManagement.UserService.Repositery.UserRepository;
import com.ShoppingMallManagement.UserService.entity.User;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserRepository repo;
	
	@PostMapping
	public User addUser(@RequestBody User U)	
	{
		return repo.save(U);
	}
      @GetMapping()
      public List<User> getUser()
      {
   	  return repo.findAll();
      }
     @GetMapping("/{id}")
      public User getUserserviceById(@PathVariable  Long id)
      {
   	  return  repo.findById(id).get();  
      }  
       @DeleteMapping("/{id}")
       public void deleteUser(@PathVariable Long id)
      
      { 	
       	repo.deleteById(id);
       }
      
       @PutMapping
       public User updateUser(@PathVariable Long id,@RequestBody User U)
       {
       	U.setId(id);
       	return repo.save(U);
       }
       
       
      
}


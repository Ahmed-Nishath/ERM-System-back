package com.ERMSystem.auth;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ERMSystem.exception.ResourceNotFoundException;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("protech/api/")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	//Get all technicians
	@GetMapping("/technicians")
	public List<SystemUser> getAllTechnicians(){
		return userRepository.findAll();
	}
	
	
	//Register technicians
	@PostMapping("/technicians/register")
	public SystemUser createTechnician(@RequestBody SystemUser user) {
		SystemUser sysUser = new SystemUser();
		
		sysUser.setUserName(user.getUserName());
		sysUser.setEmail(user.getEmail());
		sysUser.setPhone(user.getPhone());
		sysUser.setFeild(user.getFeild());
		sysUser.setPassword("P@ssw0rd");
		sysUser.setRole(Role.TECHNICIAN);
		
		userRepository.save(sysUser);
		return sysUser;
	}
	
	
	//Login technicians
	@PostMapping("/technicians/login")
	public ResponseEntity<SystemUser> loginTechnician(@RequestBody SystemUser user){
		SystemUser sysUser = userRepository.findByEmail(user.getEmail());
		
		if(sysUser == null) throw new ResourceNotFoundException("Users not found");
		
		if(sysUser.getPassword().equals(user.getPassword())) return ResponseEntity.ok(sysUser);
		
		else throw new ResourceNotFoundException("Incorrect credentials");
	}

	
	//Get technicians by Id
	@GetMapping("/technicians/{id}")
	public ResponseEntity<SystemUser> getTechnicianById(@PathVariable Long id) {
		SystemUser user = userRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Users not found with id : " + id)) ;
		return ResponseEntity.ok(user);
	}
	
	//Update technicians
	@PutMapping("/technicians/{id}")
	public ResponseEntity<SystemUser> updateTechnician(@PathVariable Long id, @RequestBody SystemUser user){
		SystemUser sysUser = userRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User not found with id : " + id)) ;
		
		sysUser.setUserName(user.getUserName());
		sysUser.setEmail(user.getEmail());
		sysUser.setPhone(user.getPhone());
		sysUser.setFeild(user.getFeild());
		
		
		SystemUser updatedUser = userRepository.save(sysUser);
		return ResponseEntity.ok(updatedUser);
	}
	
	//Delete technicians
	@DeleteMapping("/technicians/{id}")
	public ResponseEntity<HttpStatus> deleteTechnician(@PathVariable Long id){
		SystemUser user = userRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User not exsit with id : " + id));
		
		userRepository.delete(user);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}




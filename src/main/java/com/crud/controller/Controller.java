package com.crud.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.crud.model.StudentEntity;
import com.crud.repository.RepoStudent;

@RestController
@CrossOrigin(origins = "*") 
public class Controller {

	@Autowired
	RepoStudent service;
	//get all
	@GetMapping("/get")
	public List<StudentEntity> getstudent()
	{
		return service.findAll();
	}
	
	
	@GetMapping("/getid/{id}")
	public StudentEntity getbyid(@PathVariable int id)
	{
		StudentEntity student= service.findById(id).get();
		return student;
	}
	
	@PostMapping("/addstudent")
	public StudentEntity addstudent(@RequestBody StudentEntity ref)
	{
		
			return service.save(ref);
	}
	
	@PutMapping("/update/{id}")
	public StudentEntity updatestudenr(@PathVariable int id ,@RequestBody StudentEntity ref)
	{
		 Optional<StudentEntity> obj = service.findById(id);
		 boolean valuw = obj.isPresent();
		 StudentEntity old = service.findById(id).get();
		if(valuw)
		{	
			 
			 old.setName(ref.getName());
			 old.setLname(ref.getLname());
			 old.setAge(ref.getAge());
			 
			 service.save(old);
			 
			 
		}
		
		
		return old;
	}
	
	@DeleteMapping("/delete/{id}")
	public StudentEntity delete(@PathVariable int id)
	{
		StudentEntity obj=service.findById(id).get();
		service.delete(obj);
		return obj;
	}
	
	
	
}

package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Tache;
import com.example.demo.repository.*;

@RestController
@RequestMapping("/tache")
@CrossOrigin
public class TacheController {
	@Autowired
	TacheRepository tacheRepository;
	
	@GetMapping(value="/all")
	public List<Tache> getToutesTaches() {
		return tacheRepository.findAll();
	}
	
	@GetMapping(value="/{id}")
	public Tache getTache(@PathVariable(name="id") int id) {
		return tacheRepository.findById(id).get();
	}
	@PostMapping(value="/new")
	public Tache newTache (@RequestBody Tache tache) {
		return tacheRepository.save(tache);
	}
	@PutMapping(value="/update")
	public Tache updateTache (@RequestBody Tache tache) {
		return tacheRepository.save(tache);
	}
	@DeleteMapping(value="/delete/{id}")
	public void deleteTache (@PathVariable(name="id") int id) {
	    tacheRepository.deleteById(id);
	}
	
	
	
}

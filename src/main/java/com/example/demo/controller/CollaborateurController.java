package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.*;

import java.util.List;
import com.example.demo.model.*;

@RestController
public class CollaborateurController {
	@Autowired
	CollaborateurRepository collaborateurRepository;

	@GetMapping(value="/all")
	public List<Collaborateur> all() {
		return collaborateurRepository.findAll();
	}
	
	@GetMapping(value="/{codecollaborateur}")
	public Collaborateur getcollaborateur(@PathVariable(name="codecollab") int codecollab) {
		return collaborateurRepository.findById(codecollab).get();
	}
	@PostMapping(value="/new")
	public Collaborateur newcollaborateur (@RequestBody Collaborateur collaborateur) {
		return collaborateurRepository.save(collaborateur);
	}
	@PutMapping(value="/update")
	public Collaborateur updatecollaborateur(@RequestBody Collaborateur collaborateur) {
		return collaborateurRepository.save(collaborateur);
	}
	@DeleteMapping(value="/delete/{codecollab}")
	public void deletecollaborateur (@PathVariable(name="codecollab") int codecollab) {
		collaborateurRepository.deleteById(codecollab);
	}

}

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

import com.example.demo.model.*;
import com.example.demo.repository.*;

@RestController
@RequestMapping("/projet")
@CrossOrigin

public class ProjetController {
	@Autowired
	ProjetRepository projetRepository;
	
	@GetMapping(value="/all")
	public List<Projet> all() {
		return projetRepository.findAll();
	}
	
	@GetMapping(value="/{codeProjet}")
	public Projet getProjet(@PathVariable(name="codeProjet") int codeProjet) {
		return projetRepository.findById(codeProjet).get();
	}
	@PostMapping(value="/new")
	public Projet newProjet (@RequestBody Projet projet) {
		return projetRepository.save(projet);
	}
	@PutMapping(value="/update")
	public Projet updateProjet(@RequestBody Projet projet) {
		return projetRepository.save(projet);
	}
	@DeleteMapping(value="/delete/{codeProjet}")
	public void deleteProjet (@PathVariable(name="codeProjet") int codeProjet) {
		projetRepository.deleteById(codeProjet);
	}
    

}

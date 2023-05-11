package com.example.demo.controller;

import com.example.demo.model.Tache;
import com.example.demo.service.TacheService;
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

@RestController
@RequestMapping("/tache")
@CrossOrigin(origins = "http://localhost:4200")
public class TacheController {

  @Autowired
  TacheService tacheService;

  @GetMapping(value = "/all")
  public List<Tache> getToutesTaches() {
    return tacheService.findAllTaches();
  }

  @GetMapping(value = "/{id}")
  public Tache getTache(@PathVariable(name = "id") int id) {
    return tacheService.findByCodeTache(id);
  }

  @PostMapping(value = "/new")
  public Tache newTache(@RequestBody Tache tache) {
    return tacheService.save(tache);
  }

  @PutMapping(value = "/update")
  public Tache updateTache(@RequestBody Tache tache) {
    return tacheService.update(tache);
  }

  @DeleteMapping(value = "/delete/{id}")
  public void deleteTache(@PathVariable(name = "id") int id) {
    tacheService.deleteById(id);
  }
}

package com.example.demo.service;

import com.example.demo.model.Projet;
import com.example.demo.repository.ProjetRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjetService {

  @Autowired
  ProjetRepository projetRepository;

  public Projet save(Projet p) {
    return projetRepository.save(p);
  }

  public Projet update(Projet p) {
    return projetRepository.save(p);
  }

  public void delete(Projet p) {
    projetRepository.delete(p);
  }

  public void deleteById(Integer codeProjet) {
    projetRepository.deleteById(codeProjet);
  }

  public Projet findByCodeProjet(Integer codeProjet) {
    return projetRepository.findById(codeProjet).get();
  }

  public List<Projet> findAllProjects() {
    return projetRepository.findAll();
  }
}

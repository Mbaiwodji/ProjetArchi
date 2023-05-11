package com.example.demo.service;

import com.example.demo.model.Tache;
import com.example.demo.repository.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TacheService {

  @Autowired
  TacheRepository tacheRepository;

  @Autowired
  CollaborateurRepository collaborateurRepository;

  public Tache save(Tache t) {
    return tacheRepository.save(t);
  }

  public Tache update(Tache t) {
    return tacheRepository.save(t);
  }

  public void delete(Tache t) {
    tacheRepository.delete(t);
  }

  public void deleteById(Integer codeTache) {
    tacheRepository.deleteById(codeTache);
  }

  public Tache findByCodeTache(Integer codeTache) {
    return tacheRepository.findById(codeTache).get();
  }

  public List<Tache> findAllTaches() {
    return tacheRepository.findAll();
  }
}

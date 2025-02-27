package com.example.demo.repository;

import com.example.demo.model.*;

import java.util.List;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;

public interface CollaborateurRepository
  extends JpaRepository<Collaborateur, String> {
  Collaborateur findByCodeCollab(String codeCollab);

  @Query(
    "select c.codeCollab, c.nom, c.prenom, type(c) from Collaborateur c where c.codeCollab=:codeCollab and c.motPasse=:motPasse"
  )
  public Object getProfilCollaborateur(
    @Param("codeCollab") String codeCollab,
    @Param("motPasse") String motPasse
  );

  @Query(
    "select c.codeCollab, c.nom, c.prenom, type(c) from Collaborateur c where type(c)=Collaborateur"
  )
  public List<Object[]> getAllCollaborateurs();

  @Query(
    "select c.codeCollab, c.nom, c.prenom, type(c) from Collaborateur c where type(c)=Manager"
  )
  public List<Object[]> getOnlyManagers();
}

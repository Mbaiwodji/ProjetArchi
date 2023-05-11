package com.example.demo.model;

import jakarta.persistence.*;
import java.util.*;
import lombok.Data;

@Entity
@Data
public class Projet {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int codeProjet;

  private String intituleProjet;
  private int chargeHoraireProjet;

  @OneToMany(mappedBy = "projet")
  private List<Tache> taches = new ArrayList<Tache>();
}

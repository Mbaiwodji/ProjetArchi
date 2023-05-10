package com.example.demo.model;


import java.util.*;
import jakarta.persistence.*;
import lombok.Data;
@Entity
public class Projet {
	@Id
	private int codeProjet;
	private String intituleProjet;
	private int chargeHoraireProjet;
	
	@OneToMany(mappedBy="projet")
	private List<Tache> tachess=new ArrayList<Tache>(); 

}

package com.example.demo.model;

import java.util.*;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data //it contains( getter,setter,toString,contrustor sans arguments)
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name="profil")


public class Collaborateur {
	@Id
	private String codeCollab;
	private String nom;
	private String prenom;
	private String motPasse;
	
	@ManyToMany(mappedBy="collaborateurs")
	private Set<Tache> taches =new HashSet<Tache>();
	
	
}	
	
	
	
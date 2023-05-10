package com.example.demo.model;



import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class TacheRealisee {
	@EmbeddedId
	TacheRealiseePK tacheRealiseePK;
	
	private int chargeHoraireRealisee;
	private String status;
	
}

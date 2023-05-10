package com.example.demo.model;


import java.io.Serializable;

import jakarta.persistence.Embeddable;
import lombok.Data;


@Embeddable
@Data

public class TacheRealiseePK implements Serializable {
	private int codeTache;
	private int codeCollab;

}

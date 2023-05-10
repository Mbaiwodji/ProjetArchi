package com.example.demo.model;

import jakarta.persistence.DiscriminatorValue;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@DiscriminatorValue(value="Admin")
public class Admin extends Collaborateur {
	

}

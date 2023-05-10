package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.*;


@Service
public class ManagerService {


	@Autowired TacheRepository tacheRepository;
	@Autowired TacheRealiseeRepository tacheRealiseeRepository;
	
	public void valider() {};
	public void affecterTache() {};
	
	

}

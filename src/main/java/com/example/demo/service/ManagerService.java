package com.example.demo.service;

import com.example.demo.model.Collaborateur;
import com.example.demo.model.Tache;
import com.example.demo.model.TacheRealisee;
import com.example.demo.model.TacheRealiseePK;
import com.example.demo.repository.*;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class ManagerService {

  @Autowired
  TacheRepository tacheRepository;

  @Autowired
  TacheRealiseeRepository tacheRealiseeRepository;

  @Autowired
  CollaborateurRepository collaborateurRepository;

  public void valider() {}

  public void affecterTache() {}

  public TacheRealisee affectTacheCollaborateur(
    Integer codeTache,
    String codeCollab,
    String status,
    String chargeHoraireRealisee
  ) {
    //Recherche du collaborateur s'il existe
    Optional<Collaborateur> collab = collaborateurRepository.findById(
      codeCollab
    );
    Optional<Tache> t = tacheRepository.findById(codeTache);

    if (collab.isPresent() && t.isPresent()) {
      //Collaborateur et Tache existent dejà

      TacheRealisee colT = new TacheRealisee();
      TacheRealiseePK pk = new TacheRealiseePK();

      pk.setCodeTache(t.get().getCodeTache());
      pk.setCodeCollab(collab.get().getCodeCollab());

      colT.setTacheRealiseePK(pk);
      colT.setStatus(status);
      colT.setChargeHoraireRealisee(Integer.parseInt(chargeHoraireRealisee));

      return tacheRealiseeRepository.save(colT);
    } else {
      return null;
    }
  }
}

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

  public void valider(Integer codeTache,String codeCollab) {
    TacheRealiseePK pk = new TacheRealiseePK();
    pk.setCodeTache(codeTache);
    pk.setCodeCollab(codeCollab);

    Optional<TacheRealisee> tacheRea = tacheRealiseeRepository.findById(pk);
    if(tacheRea.isPresent() && tacheRea.get().getStatus().equals("done")){
      TacheRealisee t = tacheRea.get();
      t.setStatus("validated");
      tacheRealiseeRepository.save(t);
    }

  }

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

      TacheRealisee tacheRea = new TacheRealisee();
      TacheRealiseePK pk = new TacheRealiseePK();

      pk.setCodeTache(t.get().getCodeTache());
      pk.setCodeCollab(collab.get().getCodeCollab());

      tacheRea.setTacheRealiseePK(pk);
      tacheRea.setStatus(status);
      tacheRea.setChargeHoraireRealisee(Integer.parseInt(chargeHoraireRealisee));

      return tacheRealiseeRepository.save(tacheRea);
    } else {
      return null;
    }
  }
}

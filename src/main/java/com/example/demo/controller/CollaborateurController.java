package com.example.demo.controller;

import com.example.demo.model.*;
import com.example.demo.service.CollaborateurService;
import com.example.demo.service.ManagerService;
import com.example.demo.service.TacheRealiseeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/collaborateur")
@CrossOrigin(origins = "http://localhost:4200")
public class CollaborateurController {

  @Autowired
  CollaborateurService collaborateurService;

  @Autowired
  ManagerService managerService;

  @GetMapping(value = "/all")
  public List<Collaborateur> all() {
    return collaborateurService.findAllCollaborateurs();
  }

  @GetMapping(value = "/only")
  public List<Object[]> allCollaborateurs() {
    return collaborateurService.getAllCollaborateurs();
  }

  @GetMapping(value = "/only-manager")
  public List<Object[]> getOnlyManagers() {
    return collaborateurService.getOnlyManagers();
  }

  @PostMapping(value = "/getByCodeAndMotPass")
  public Object getCollaborateurByCodeAndPass(
    @RequestParam("codeCollab") String code,
    @RequestParam("motPasse") String pass
  ) {
    return collaborateurService.getProfilCollaborateur(code, pass);
  }

  @GetMapping(value = "/{codecollaborateur}")
  public Collaborateur getcollaborateur(
    @PathVariable(name = "codecollab") String codecollab
  ) {
    return collaborateurService.findById(codecollab);
  }

  @PostMapping(value = "/new")
  public Collaborateur newcollaborateur(
    @RequestBody Collaborateur collaborateur
  ) {
    return collaborateurService.save(collaborateur);
  }

  @PostMapping(value = "/newManager")
  public Manager newManager(@RequestBody Manager manager) {
    return collaborateurService.saveManager(manager);
  }

  @PostMapping(value = "/newAdmin")
  public Admin newAdmin(@RequestBody Admin admin) {
    return collaborateurService.saveAdmin(admin);
  }

  @PostMapping(value = "/affectTacheCollaborateur")
  public TacheRealisee affectTacheCollaborateur(
    @RequestParam("codeTache") Integer codeTache,
    @RequestParam("codeCollab") String codeCollab,
    @RequestParam("status") String status,
    @RequestParam("chargeHoraireRealisee") String chargeHoraireRealisee
  ) {
    return managerService.affectTacheCollaborateur(
      codeTache,
      codeCollab,
      status,
      chargeHoraireRealisee
    );
  }

  @PutMapping(value = "/update")
  public Collaborateur updatecollaborateur(
    @RequestBody Collaborateur collaborateur
  ) {
    return collaborateurService.update(collaborateur);
  }

  @PutMapping(value = "/updateManager")
  public Manager updateManager(@RequestBody Manager manager) {
    return collaborateurService.updateManager(manager);
  }

  @PutMapping(value = "/updateAdmin")
  public Admin updateAdmin(@RequestBody Admin admin) {
    return collaborateurService.updateAdmin(admin);
  }

  @DeleteMapping(value = "/delete/{codecollab}")
  public void deletecollaborateur(
    @PathVariable(name = "codecollab") String codecollab
  ) {
    collaborateurService.deleteByCodeCollab(codecollab);
  }
}

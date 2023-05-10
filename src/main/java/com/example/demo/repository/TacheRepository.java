package com.example.demo.repository;

import org.springframework.data.jpa.repository.*;
import com.example.demo.model.*;

public interface TacheRepository extends JpaRepository<Tache,Integer> {

}

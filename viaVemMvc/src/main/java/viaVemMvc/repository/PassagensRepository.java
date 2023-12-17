package viaVemMvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import viaVemMvc.model.Passagens;

public interface PassagensRepository extends JpaRepository<Passagens, Integer> {
   
}
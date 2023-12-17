package viaVemMvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import viaVemMvc.model.Usuarios;

public interface UsuariosRepository extends JpaRepository<Usuarios, Integer> {
   
}
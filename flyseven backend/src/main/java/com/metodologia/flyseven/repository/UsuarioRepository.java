package com.metodologia.flyseven.repository;

import com.metodologia.flyseven.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by efalcon
 */
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
}

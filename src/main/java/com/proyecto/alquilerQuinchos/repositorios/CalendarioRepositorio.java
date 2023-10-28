
package com.proyecto.alquilerQuinchos.repositorios;

/**
 * @author Agustina
 */

import com.proyecto.alquilerQuinchos.entidades.Calendario;
import com.proyecto.alquilerQuinchos.entidades.Comentarios;
import com.proyecto.alquilerQuinchos.entidades.Imagen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CalendarioRepositorio extends JpaRepository <Calendario, String> {

    @Query("SELECT c FROM Calendario c WHERE c.id = :id ")
    public Calendario buscarCalendarioPorId(@Param("id") Long id);

}
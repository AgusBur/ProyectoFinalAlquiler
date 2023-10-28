
package com.proyecto.alquilerQuinchos.servicios;

/**
 * @author Agustina
 */

import com.proyecto.alquilerQuinchos.entidades.Calendario;
import com.proyecto.alquilerQuinchos.entidades.Reserva;
import com.proyecto.alquilerQuinchos.repositorios.CalendarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service
public class CalendarioServicio {
    @Autowired
    private CalendarioRepositorio calendarioRepositorio;

    @Transactional
    public Calendario  crearCalendario(){

        Calendario calendario = new Calendario();
        Set<Reserva> listaReserva = new HashSet<>();
        calendario.setReserva(listaReserva);
        calendarioRepositorio.save(calendario);
        return calendario;
    }
}

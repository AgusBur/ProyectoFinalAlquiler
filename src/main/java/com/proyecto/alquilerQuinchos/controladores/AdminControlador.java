
package com.proyecto.alquilerQuinchos.controladores;

/**
 * @author Agustina
 */

import com.proyecto.alquilerQuinchos.entidades.Usuario;
import com.proyecto.alquilerQuinchos.excepciones.MiException;
import com.proyecto.alquilerQuinchos.servicios.InmuebleServicio;
import com.proyecto.alquilerQuinchos.servicios.ReservaServicio;
import com.proyecto.alquilerQuinchos.servicios.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;
import javax.servlet.http.HttpSession;

@Controller
@PreAuthorize("hasRole('ROLE_ADMIN')")
@RequestMapping("/admin")
public class AdminControlador {

    @Autowired
    private UsuarioServicio usuarioServicio;
    
    @Autowired
    private InmuebleServicio inmuebleServicio;
    
    @Autowired
    private ReservaServicio reservaServicio;
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/dashboard")
    public String panelAdministrativo() {

        return "dashboard.html";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/usuarios")

    public String listar(ModelMap modelo) {

        List<Usuario> usuarios = usuarioServicio.listarUsuarios();

        modelo.addAttribute("usuarios", usuarios);

        return "dashboard.html";
    }

    
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/perfil/usuarios/eliminar/{id}")
    public String eliminarUsuario(@PathVariable String id, HttpSession session) throws MiException {
        usuarioServicio.borrarUsuarioPorId(id);
        return "index.html";
    }
}
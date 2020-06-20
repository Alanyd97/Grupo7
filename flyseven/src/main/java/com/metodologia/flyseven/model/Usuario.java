package com.metodologia.flyseven.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * Created by efalcon
 */
@Entity
@Data
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUsuario;

    private String nombre;

    private String apellido;

    private String contrasenia;

    private String email;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Viaje> viajes;

    public static Usuario fromId(Integer idUsuario) {
        Usuario usuario = new Usuario();
        usuario.setIdUsuario(idUsuario);
        return usuario;
    }
}

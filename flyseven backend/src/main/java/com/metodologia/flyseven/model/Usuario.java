package com.metodologia.flyseven.model;

import lombok.Data;

import javax.persistence.*;

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

    public static Usuario fromId(Integer idUsuario) {
        Usuario usuario = new Usuario();
        usuario.setIdUsuario(idUsuario);
        return usuario;
    }
}

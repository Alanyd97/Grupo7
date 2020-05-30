package com.metodologia.flyseven;

import com.metodologia.flyseven.model.Aeropuerto;
import com.metodologia.flyseven.model.Usuario;
import com.metodologia.flyseven.model.Viaje;
import com.metodologia.flyseven.model.Vuelo;
import com.metodologia.flyseven.repository.AeropuertoRepository;
import com.metodologia.flyseven.repository.UsuarioRepository;
import com.metodologia.flyseven.repository.ViajeRepository;
import com.metodologia.flyseven.repository.VueloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Time;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class FlysevenApplication implements CommandLineRunner {

    private UsuarioRepository usuarioRepository;
    private AeropuertoRepository aeropuertoRepository;
    private VueloRepository vueloRepository;
    private ViajeRepository viajeRepository;

    @Autowired
    public FlysevenApplication(UsuarioRepository usuarioRepository, AeropuertoRepository aeropuertoRepository, VueloRepository vueloRepository, ViajeRepository viajeRepository) {
        this.usuarioRepository = usuarioRepository;
        this.aeropuertoRepository = aeropuertoRepository;
        this.vueloRepository = vueloRepository;
        this.viajeRepository = viajeRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(FlysevenApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Usuario usuario = new Usuario();
        usuario.setNombre("Nombre");
        usuario.setApellido("Apellido");
        usuario.setContrasenia("Contrasenia");
        usuario.setEmail("email@gmail.com");

        Aeropuerto aeropuerto = new Aeropuerto();
        aeropuerto.setNombre("NombreDeAeropuerto");
        aeropuerto.setCiudad("CiudadDeAeropuerto");
        aeropuerto.setPais("PaisDeAeropuerto");

        Aeropuerto aeropuerto2 = new Aeropuerto();
        aeropuerto2.setNombre("NombreDeAeropuerto2");
        aeropuerto2.setCiudad("CiudadDeAeropuerto2");
        aeropuerto2.setPais("PaisDeAeropuerto2");

        Vuelo vuelo = new Vuelo();
        vuelo.setUsuario(usuario);
        vuelo.setAerolinea("Aerolinea");
        vuelo.setAeronave("Aeronave");
        vuelo.setAsiento("Asiento");
        vuelo.setClase("ClaseDelVuelo");
        vuelo.setCodReserva(12314123);
        vuelo.setDestino(aeropuerto);
        vuelo.setOrigen(aeropuerto2);
        vuelo.setDistancia(12345.2F);
        Time duracion = Time.valueOf(LocalTime.now());
        vuelo.setDuracion(duracion);
        vuelo.setInicio(LocalDateTime.now());
        vuelo.setFin(LocalDateTime.of(2021,2,3,1,3));

        List<Viaje> viajes = new ArrayList<>();
        viajes.add(new Viaje(1,
                LocalDateTime.of(2020,5,15,1,1),
                LocalDateTime.of(2020,6,1,1,1),
                "Visita a Arg",
                "Argentina",
                "Abuelos",
                usuario,
                Arrays.asList(vuelo)));

        viajes.add(new Viaje(2,
                LocalDateTime.of(2020,6,1,1,1),
                LocalDateTime.of(2020,7,1,1,1),
                "Visita Colombia",
                "Colombia",
                "Turismo",
                usuario,
                Arrays.asList(vuelo)));

        usuarioRepository.save(usuario);
        aeropuertoRepository.save(aeropuerto);
        aeropuertoRepository.save(aeropuerto2);
        vueloRepository.save(vuelo);
        viajeRepository.saveAll(viajes);
    }
}

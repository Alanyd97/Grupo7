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
        aeropuerto.setCiudad("Tandil");
        aeropuerto.setPais("Argentina");

        Aeropuerto aeropuerto2 = new Aeropuerto();
        aeropuerto2.setNombre("NombreDeAeropuerto2");
        aeropuerto2.setCiudad("Azul");
        aeropuerto2.setPais("Argentina");

        Aeropuerto aeropuerto3 = new Aeropuerto();
        aeropuerto3.setNombre("NombreDeAeropuerto2");
        aeropuerto3.setCiudad("Olavarria");
        aeropuerto3.setPais("Argentina");



        Vuelo vuelo = new Vuelo();
        vuelo.setUsuario(usuario);
        vuelo.setAerolinea("Aerolinea");
        vuelo.setAeronave("Aeronave");
        vuelo.setAsiento("Asiento");
        vuelo.setClase("ClaseDelVuelo");
        vuelo.setCodReserva(12314123);
        vuelo.setOrigen(aeropuerto);
        vuelo.setDestino(aeropuerto3);
        vuelo.setDistancia(12345.2F);
        vuelo.setDuracion(Time.valueOf(LocalTime.now()));
        vuelo.setInicio(LocalDateTime.now());
        vuelo.setFin(LocalDateTime.of(2021,2,3,1,3));

        Vuelo vuelo2 = new Vuelo();
        vuelo2.setUsuario(usuario);
        vuelo2.setAerolinea("Aerolinea");
        vuelo2.setAeronave("Aeronave");
        vuelo2.setAsiento("Asiento");
        vuelo2.setClase("ClaseDelVuelo");
        vuelo2.setCodReserva(12314123);
        vuelo2.setOrigen(aeropuerto);
        vuelo2.setDestino(aeropuerto2);
        vuelo2.setDistancia(12345.2F);
        vuelo2.setDuracion(Time.valueOf(LocalTime.now()));
        vuelo2.setInicio(LocalDateTime.now());
        vuelo2.setFin(LocalDateTime.of(2021,2,3,1,3));

        vuelo.setEscalas(Arrays.asList(vuelo2));

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
        aeropuertoRepository.save(aeropuerto3);
        vueloRepository.save(vuelo2);
        vueloRepository.save(vuelo);
        viajeRepository.saveAll(viajes);
    }
}

package com.metodologia.flyseven.email;

import com.metodologia.flyseven.model.Aeropuerto;
import com.metodologia.flyseven.model.Usuario;
import com.metodologia.flyseven.model.Viaje;
import com.metodologia.flyseven.model.Vuelo;
import com.metodologia.flyseven.repository.ViajeRepository;
import com.metodologia.flyseven.repository.VueloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.mail.dsl.Mail;
import org.springframework.integration.scheduling.PollerMetadata;
import org.springframework.scheduling.support.PeriodicTrigger;

import java.sql.Time;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;

/**
 * Created by efalcon
 */
@Configuration
public class EmailReceiver {

    private ViajeRepository viajeRepository;

    @Autowired
    public EmailReceiver(ViajeRepository viajeRepository) {
        this.viajeRepository = viajeRepository;
    }

    @Bean
    public IntegrationFlow imapMailFlow() {
        return IntegrationFlows
                .from(Mail.imapInboundAdapter("imap://flyseventp:Flyseven7#@imap.gmail.com:993/INBOX")
                                .simpleContent(true)
                                .javaMailProperties(p -> {
                                    p.put("mail.debug", "false");
                                    p.put("mail.imap.ssl.enable", "true");
                                }),
                        e -> e.autoStartup(true)
                                .poller(p -> p.fixedDelay(3000)))
                .handle(x -> this.addVueloOnMessage())
                .get();
    }

    @Bean(name = PollerMetadata.DEFAULT_POLLER)
    public PollerMetadata defaultPoller() {
        PollerMetadata pollerMetadata = new PollerMetadata();
        pollerMetadata.setTrigger(new PeriodicTrigger(10));
        return pollerMetadata;
    }

    public void addVueloOnMessage() {
        Usuario usuario = Usuario.fromId(1);
        Aeropuerto aeropuerto = Aeropuerto.fromId(1);
        Aeropuerto aeropuerto2 = Aeropuerto.fromId(2);
        Vuelo vuelo = new Vuelo();
        vuelo.setUsuario(usuario);
        vuelo.setAerolinea("Aerolinea");
        vuelo.setAeronave("HARDCODED AEROLINE");
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
        Viaje viaje = new Viaje(1,
                LocalDateTime.of(2020,5,1,1,1),
                LocalDateTime.of(2020,12,1,1,1),
                "MIAMEEE",
                "Miami",
                "En la pera",
                usuario,
                Arrays.asList(vuelo));
        this.viajeRepository.save(viaje);
    }
}
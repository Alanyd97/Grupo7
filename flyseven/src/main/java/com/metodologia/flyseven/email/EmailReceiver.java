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
        Vuelo vuelo = Vuelo.fromId(1);
        Viaje viaje = new Viaje(0,
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
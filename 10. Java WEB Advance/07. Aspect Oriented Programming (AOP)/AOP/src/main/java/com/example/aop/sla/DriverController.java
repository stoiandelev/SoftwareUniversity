package com.example.aop.sla;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DriverController {



    @TrackLatency(latency = "local_operation")
    @GetMapping("/drivers")
    public ResponseEntity<List<Driver>> allDrivers() {
        return ResponseEntity.ok(List.of(
                new Driver().setName("Stoian").setLicenceCategory("B"),
                new Driver().setName("Marian").setLicenceCategory("A")
        ));
    }

    @TrackLatency(latency = "remote_operation")
    @GetMapping("/sync-drivers")
    public ResponseEntity<List<Driver>> remoteDrivers() {

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.interrupted();
        }

        return ResponseEntity.ok(List.of(
                new Driver().setName("Stoian").setLicenceCategory("B"),
                new Driver().setName("Marian").setLicenceCategory("A")
        ));
    }

    //In application.yml we have configuration see it.
    //if this work bellow 1s to ALERT!!!!
}

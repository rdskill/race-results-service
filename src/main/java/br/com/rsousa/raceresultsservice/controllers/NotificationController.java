package br.com.rsousa.raceresultsservice.controllers;

import br.com.rsousa.raceresultsservice.domain.notification.Notification;
import br.com.rsousa.raceresultsservice.dtos.NotificationDTO;
import br.com.rsousa.raceresultsservice.services.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
        RequestMethod.DELETE }, allowedHeaders = "*")
@RestController
@RequestMapping("/notifications")
public class NotificationController {

    @Autowired
    private NotificationService service;

    @PostMapping
    public ResponseEntity<Notification> create(@RequestBody NotificationDTO notificationDTO) {
        return ResponseEntity.ok(this.service.save(notificationDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody NotificationDTO notificationDTO) {
        boolean isUpdated = service.update(id, notificationDTO);
        if (!isUpdated) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/last")
    public ResponseEntity<Notification> findLast() throws Exception {
        return ResponseEntity.ok(this.service.findLast());
    }
}

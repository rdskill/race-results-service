package br.com.rsousa.raceresultsservice.services;

import br.com.rsousa.raceresultsservice.domain.notification.Notification;
import br.com.rsousa.raceresultsservice.dtos.NotificationDTO;
import br.com.rsousa.raceresultsservice.repositories.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class NotificationService {

    @Autowired
    private NotificationRepository repository;

    public Notification save(NotificationDTO notificationDTO) {
        Notification notification = new Notification();
        notification.setMessage(notificationDTO.message());

        return this.repository.save(notification);
    }

    public boolean update(long id, NotificationDTO notificationDTO) {
        return this.repository.findById(id).map(record -> {
            record.setMessage(notificationDTO.message());
            record.setUpdatedAt(LocalDateTime.now());

            repository.save(record);

            return true;
        }).orElse(false);
    }


    public Notification findLast() {
        return this.repository.findFirstByOrderByUpdatedAtDesc();
    }

}

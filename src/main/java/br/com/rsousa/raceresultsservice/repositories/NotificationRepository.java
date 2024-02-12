package br.com.rsousa.raceresultsservice.repositories;

import br.com.rsousa.raceresultsservice.domain.notification.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
    Notification findFirstByOrderByUpdatedAtDesc();
}

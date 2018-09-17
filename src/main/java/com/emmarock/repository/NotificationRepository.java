package com.emmarock.repository;

import com.emmarock.model.Contribution;
import com.emmarock.model.Notifications;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NotificationRepository extends MongoRepository<Notifications, String> {
}

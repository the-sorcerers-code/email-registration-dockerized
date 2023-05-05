package com.sorcererscode.notifications.templates;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface NotificationTemplateRepository extends JpaRepository<NotificationTemplate, Long> {
    NotificationTemplate findFirstByUniqueIdentifierOrderByCreatedAt(String uniqueIdentifier);
}
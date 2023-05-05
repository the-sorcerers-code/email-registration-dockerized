package com.sorcererscode.adventurermanagement.adventurers.notifications;

import lombok.Data;

import java.time.LocalDate;

@Data
public class TemplateResponseDto {
    private Long id;
    private String uniqueIdentifier;
    private String subject;
    private String body;
    private LocalDate createdAt;
    private LocalDate updatedAt;
}

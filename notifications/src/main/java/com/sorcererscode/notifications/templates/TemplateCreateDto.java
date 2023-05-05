package com.sorcererscode.notifications.templates;

import lombok.Data;

@Data
public class TemplateCreateDto {
    private String uniqueIdentifier;
    private String body;
    private String subject;
}

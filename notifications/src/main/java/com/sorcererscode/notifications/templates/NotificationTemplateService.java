package com.sorcererscode.notifications.templates;

public interface NotificationTemplateService {

    TemplateResponseDto createTemplate(TemplateCreateDto input);

    TemplateResponseDto getTemplateByIdentifier(String identifier) throws Exception;

}

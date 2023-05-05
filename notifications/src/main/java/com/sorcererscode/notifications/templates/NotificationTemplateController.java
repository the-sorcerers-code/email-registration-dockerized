package com.sorcererscode.notifications.templates;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/notification-templates")
public class NotificationTemplateController {

    @Autowired
    private NotificationTemplateService templateService;

    @PostMapping
    public TemplateResponseDto createNotificationTemplate(@RequestBody TemplateCreateDto input) {
        return templateService.createTemplate(input);
    }

    @GetMapping("/{identifier}")
    public TemplateResponseDto getNotificationTemplate(@PathVariable("identifier") String identifier)
            throws Exception {
        return templateService.getTemplateByIdentifier(identifier);
    }

}

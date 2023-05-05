package com.sorcererscode.notifications.templates;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class NotificationTemplateServiceImpl implements NotificationTemplateService{

    @Autowired
    private NotificationTemplateRepository templateRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public TemplateResponseDto createTemplate(TemplateCreateDto input) {
        NotificationTemplate template = modelMapper.map(input, NotificationTemplate.class);
        templateRepository.save(template);
        return modelMapper.map(template, TemplateResponseDto.class);
    }

    @Override
    public TemplateResponseDto getTemplateByIdentifier(String identifier) throws Exception {
        NotificationTemplate template = templateRepository.findFirstByUniqueIdentifierOrderByCreatedAt(identifier);

        if (template == null) {
            throw new Exception("Template with identifier " + identifier + " not found");
        }

        return modelMapper.map(template, TemplateResponseDto.class);
    }
}

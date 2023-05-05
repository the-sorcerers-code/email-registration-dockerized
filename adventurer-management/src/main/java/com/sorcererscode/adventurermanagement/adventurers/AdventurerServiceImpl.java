package com.sorcererscode.adventurermanagement.adventurers;

import com.sorcererscode.adventurermanagement.adventurers.notifications.EmailData;
import com.sorcererscode.adventurermanagement.adventurers.notifications.TemplateResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class AdventurerServiceImpl implements AdventurerService{

    @Autowired
    private AdventurerRepository repository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ModelMapper modelMapper;

    @Value("notification.service.url")
    private String notificationServiceUrl;

    @Override
    public AdventurerResponseDto createAdventurer(AdventurerCreateDto input) throws URISyntaxException {

        // save adventurer first
        Adventurer adventurer = modelMapper.map(input, Adventurer.class);
        repository.save(adventurer);

        // send email notification
        EmailData emailData = new EmailData();
        emailData.setRecipient(adventurer.getEmail());
        emailData.setTemplateId("template1"); // need to find a way to stop hardcoding templates

        var templateInfo = new HashMap<String, Object>();
        templateInfo.put("firstname", adventurer.getFirstName());
        emailData.setTemplateInfo(templateInfo);

        URI uri = new URI( "http://notifications-api:8080/api/v1/emails/send-email");

        restTemplate.postForObject(uri, emailData, Void.class);

        return modelMapper.map(adventurer, AdventurerResponseDto.class);
    }

    @Override
    public TemplateResponseDto connectToNotificationService() {

        return restTemplate.getForObject("http://notifications-api:8080/api/v1/notification-templates/{templateId}",
                TemplateResponseDto.class,
                "template1");

    }

    @Override
    public List<AdventurerResponseDto> getAdventurers(int page, int perPage) {
        return repository.findAll(PageRequest.of(page - 1, perPage))
                .stream()
                .map(adventurer -> modelMapper.map(adventurer, AdventurerResponseDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public long getTotalAdventurers() {
        return repository.count();
    }
}

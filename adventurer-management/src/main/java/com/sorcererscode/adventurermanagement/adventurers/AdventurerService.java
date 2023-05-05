package com.sorcererscode.adventurermanagement.adventurers;

import com.sorcererscode.adventurermanagement.adventurers.notifications.TemplateResponseDto;

import java.net.URISyntaxException;
import java.util.List;

public interface AdventurerService {
  AdventurerResponseDto createAdventurer(AdventurerCreateDto input) throws URISyntaxException;

  TemplateResponseDto connectToNotificationService();

  List<AdventurerResponseDto> getAdventurers(int page, int perPage);

  long getTotalAdventurers();
}

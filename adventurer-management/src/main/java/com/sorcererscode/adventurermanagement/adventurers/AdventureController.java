package com.sorcererscode.adventurermanagement.adventurers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import java.net.URISyntaxException;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/adventurers")
public class AdventureController {

    @Autowired
    private AdventurerService adventurerService;

    @GetMapping
    public ResponseEntity<List<AdventurerResponseDto>> getAdventurers(@RequestParam(defaultValue = "1") int page,
                                         @RequestParam(defaultValue = "10") int perPage) {
        List<AdventurerResponseDto> adventurers = adventurerService.getAdventurers(page, perPage);
        long numAdventurers = adventurerService.getTotalAdventurers();
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("X-Total-Count",
                String.valueOf(numAdventurers));
        responseHeaders.set("Access-Control-Expose-Headers", "X-Total-Count");
        return ResponseEntity.ok()
                .headers(responseHeaders)
                .body(adventurers);
    }

    @PostMapping
    public AdventurerResponseDto registerAdventurer(@RequestBody AdventurerCreateDto input) throws URISyntaxException {
        return adventurerService.createAdventurer(input);
    }
}

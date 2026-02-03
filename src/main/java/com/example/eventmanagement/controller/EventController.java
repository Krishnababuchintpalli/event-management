package com.example.eventmanagement.controller;

import com.example.eventmanagement.dto.EventRequestDTO;
import com.example.eventmanagement.dto.EventResponseDTO;
import com.example.eventmanagement.service.EventService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/events")
public class EventController {

    private final EventService service;

    public EventController(EventService service) {
        this.service = service;
    }

    // ✅ CREATE EVENT
    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseStatus(HttpStatus.CREATED)
    public EventResponseDTO createEvent(
            @Valid @RequestBody EventRequestDTO dto) {

        return service.createEvent(dto);
    }

    // ✅ GET EVENT BY ID
    @GetMapping("/{id}")
    public EventResponseDTO getEvent(@PathVariable Long id) {
        return service.getEventById(id);
    }

    // ✅ UPDATE EVENT
    @PutMapping(
            value = "/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public EventResponseDTO updateEvent(
            @PathVariable Long id,
            @Valid @RequestBody EventRequestDTO dto) {

        return service.updateEvent(id, dto);
    }
}

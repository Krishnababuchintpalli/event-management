package com.example.eventmanagement.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class EventRequestDTO {
    private String title;
    private String description;
    private String location;
    private LocalDateTime eventDate;
    private String organizer;
}


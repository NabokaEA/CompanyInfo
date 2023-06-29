package ru.naboka.companyinfo.api.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@Data
@NoArgsConstructor
public class ErrorDto {

    private int status;
    private List<String> messages;
    private LocalDateTime timestamp;

    public ErrorDto(int status, String message) {
        this.messages = Collections.singletonList(message);
        this.status = status;
        this.timestamp = LocalDateTime.now();
    }

    public ErrorDto(int status, List<String> messages) {
        this.messages = messages;
        this.status = status;
        this.timestamp = LocalDateTime.now();
    }
}

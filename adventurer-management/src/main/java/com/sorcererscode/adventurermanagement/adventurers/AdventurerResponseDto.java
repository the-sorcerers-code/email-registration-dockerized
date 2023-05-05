package com.sorcererscode.adventurermanagement.adventurers;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
public class AdventurerResponseDto {
    private Long id;
    private String firstName;
    private String middleName;
    private String lastName;
    private String email;
    private String phone;
    private String homeAddress;
    private LocalDate createdAt;
    private LocalDate updatedAt;

    @JsonFormat(pattern="yyyy-MM-dd")
    public LocalDate getCreatedAt() {
        return createdAt;
    }

    @JsonFormat(pattern="yyyy-MM-dd")
    public LocalDate getUpdatedAt() {
        return updatedAt;
    }
}

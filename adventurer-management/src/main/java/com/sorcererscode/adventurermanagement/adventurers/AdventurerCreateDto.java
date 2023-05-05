package com.sorcererscode.adventurermanagement.adventurers;

import lombok.Data;

@Data
public class AdventurerCreateDto {
    private String firstName;
    private String middleName;
    private String lastName;
    private String email;
    private String phone;
    private String homeAddress;
}

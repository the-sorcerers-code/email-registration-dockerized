package com.sorcererscode.notifications.emails;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailData {
    private String recipient;
    private String templateId;
    private HashMap<String, Object> templateInfo = new HashMap<>();
}

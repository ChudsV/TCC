package com.tcc.Service;

import org.springframework.stereotype.Service;

@Service
public class StringService {
    public String convertToCamelCase(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }

        String[] words = input.split("\\s+");
        StringBuilder camelCaseName = new StringBuilder();

        for (String word : words) {
            if (word.isEmpty()) continue;

            camelCaseName.append(Character.toUpperCase(word.charAt(0)))
                    .append(word.substring(1).toLowerCase())
                    .append(" ");
        }

        return camelCaseName.toString().trim();
    }
}

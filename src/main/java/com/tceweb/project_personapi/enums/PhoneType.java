package com.tceweb.project_personapi.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PhoneType {
    HOME("Home"),
    MOBIILE("Mobile"),
    COMERCIAL("Comercial");

    private final String description;

}

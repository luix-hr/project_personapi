package com.tceweb.project_personapi.dto.request;

import com.tceweb.project_personapi.entity.Phone;
import com.tceweb.project_personapi.enums.PhoneType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PhoneDTO {

    private Long id;

    @Enumerated(EnumType.STRING)
    private PhoneType type;

    @NotBlank
    @Size(min = 11, max = 14)
    private String number;


    public PhoneDTO(Phone phone) {
        this(phone.getId(), phone.getType(), phone.getNumber());
    }
}

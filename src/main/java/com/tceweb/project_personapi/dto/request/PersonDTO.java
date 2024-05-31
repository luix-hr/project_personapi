package com.tceweb.project_personapi.dto.request;

import com.tceweb.project_personapi.entity.Person;
import com.tceweb.project_personapi.entity.Phone;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.ui.ModelMap;

import java.time.LocalDateTime;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PersonDTO {

    private Long id;

    @NotBlank
    @Size(min = 2, max = 100)
    private String firstName;

    @NotBlank
    @Size(min = 2, max = 100)
    private String lastName;

    @NotBlank
    private String cpf;

    private LocalDateTime birthDate;

    @NotEmpty
    @Valid
    private List<PhoneDTO> phones;


    public PersonDTO(Person person) {
        this(person.getId(), person.getFirstName(), person.getLastName(), person.getCpf(), person.getBirthDate(), person.getPhones().stream().map(PhoneDTO::new).toList());
    }


}

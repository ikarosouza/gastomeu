package br.com.reiosse.gastomeu.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreditCardRequestDTO {

    private Long id;

    private String name;

    private String brand;

    private LocalDate dueDate;
}


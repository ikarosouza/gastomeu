package br.com.reiosse.gastomeu.dto.request;

import br.com.reiosse.gastomeu.model.Periodicity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@AllArgsConstructor
public class TransactionRequestDTO {
    private Long id;
    private Long categoryId;
    private Long creditCardId;
    private BigDecimal totalValue;
    private LocalDateTime transactionDate;
    private LocalDateTime billingDate;
    private String description;
    private String title;
    private Boolean isCreditCardTransaction;
    private Integer installments;
    private BigDecimal installmentValue;
    private Long originalTransactionId;
    private Periodicity periodicity;
    private Boolean isRecurring;
}

package br.com.reiosse.gastomeu.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "credit_card_id")
    private CreditCard creditCard;

    private BigDecimal totalValue;

    private LocalDateTime transactionDate;

    private LocalDateTime billingDate;

    private String description;

    private String title;

    private Boolean isCreditCardTransaction;

    private Integer installments;

    private BigDecimal installmentValue;

    private Long originalTransactionId;

    @Enumerated(EnumType.STRING)
    private Periodicity periodicity;

    private Boolean isRecurring;

}

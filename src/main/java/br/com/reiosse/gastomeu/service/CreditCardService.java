package br.com.reiosse.gastomeu.service;

import br.com.reiosse.gastomeu.model.CreditCard;

import java.util.List;

public interface CreditCardService {
    CreditCard saveCreditCard(CreditCard creditCard);
    List<CreditCard> getAllCreditCards();
    CreditCard getCreditCardById(Long id);
    void deleteCreditCardById(Long id);
}

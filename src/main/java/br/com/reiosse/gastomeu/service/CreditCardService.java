package br.com.reiosse.gastomeu.service;

import br.com.reiosse.gastomeu.dto.request.CreditCardRequestDTO;
import br.com.reiosse.gastomeu.model.CreditCard;

import java.util.List;

public interface CreditCardService {

    CreditCard saveCreditCard(CreditCardRequestDTO creditCardRequestDTO);

    List<CreditCard> getAllCreditCards();
    CreditCard getCreditCardById(Long id);
    void deleteCreditCardById(Long id);
}

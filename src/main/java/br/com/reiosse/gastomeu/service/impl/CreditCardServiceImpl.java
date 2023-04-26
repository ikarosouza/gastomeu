package br.com.reiosse.gastomeu.service.impl;

import br.com.reiosse.gastomeu.dto.request.CreditCardRequestDTO;
import br.com.reiosse.gastomeu.mapper.CreditCardMapper;
import br.com.reiosse.gastomeu.model.CreditCard;
import br.com.reiosse.gastomeu.repository.CreditCardRepository;
import br.com.reiosse.gastomeu.service.CreditCardService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CreditCardServiceImpl implements CreditCardService {

    private final CreditCardRepository creditCardRepository;
    private final CreditCardMapper creditCardMapper;

    @Override
    public CreditCard saveCreditCard(CreditCardRequestDTO creditCardRequestDTO) {
        CreditCard creditCard = creditCardMapper.toCreditCard(creditCardRequestDTO);
        return creditCardRepository.save(creditCard);
    }

    @Override
    public List<CreditCard> getAllCreditCards() {
        return creditCardRepository.findAll();
    }

    @Override
    public CreditCard getCreditCardById(Long id) {
        return creditCardRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteCreditCardById(Long id) {
        creditCardRepository.deleteById(id);
    }
}

package br.com.reiosse.gastomeu.controller;

import br.com.reiosse.gastomeu.dto.request.CreditCardRequestDTO;
import br.com.reiosse.gastomeu.model.CreditCard;
import br.com.reiosse.gastomeu.service.CreditCardService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/credit-cards")
@AllArgsConstructor
public class CreditCardController {

    private final CreditCardService creditCardService;

    @GetMapping
    public List<CreditCard> getAllCreditCards() {
        return creditCardService.getAllCreditCards();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CreditCard> getCreditCardById(@PathVariable Long id) {
        CreditCard creditCard = creditCardService.getCreditCardById(id);
        if (creditCard == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(creditCard);
    }

    @PostMapping
    public ResponseEntity<CreditCard> createCreditCard(@RequestBody CreditCardRequestDTO creditCardRequestDTO) {
        CreditCard savedCreditCard = creditCardService.saveCreditCard(creditCardRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCreditCard);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CreditCard> updateCreditCard(@PathVariable Long id, @RequestBody CreditCardRequestDTO creditCardRequestDTO) {
        CreditCard existingCreditCard = creditCardService.getCreditCardById(id);
        if (existingCreditCard == null) {
            return ResponseEntity.notFound().build();
        }
        creditCardRequestDTO.setId(id);
        CreditCard updatedCreditCard = creditCardService.saveCreditCard(creditCardRequestDTO);
        return ResponseEntity.ok(updatedCreditCard);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCreditCard(@PathVariable Long id) {
        CreditCard existingCreditCard = creditCardService.getCreditCardById(id);
        if (existingCreditCard == null) {
            return ResponseEntity.notFound().build();
        }
        creditCardService.deleteCreditCardById(id);
        return ResponseEntity.noContent().build();
    }
}


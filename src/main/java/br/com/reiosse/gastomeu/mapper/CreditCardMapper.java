package br.com.reiosse.gastomeu.mapper;

import br.com.reiosse.gastomeu.dto.request.CreditCardRequestDTO;
import br.com.reiosse.gastomeu.model.CreditCard;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CreditCardMapper {

    CreditCard toCreditCard(CreditCardRequestDTO requestDTO);

//    CreditCardResponseDTO toResponseDTO(CreditCard creditCard);

}

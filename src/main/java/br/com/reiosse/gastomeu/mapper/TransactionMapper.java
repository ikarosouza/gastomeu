package br.com.reiosse.gastomeu.mapper;

import br.com.reiosse.gastomeu.dto.request.TransactionRequestDTO;
import br.com.reiosse.gastomeu.model.Transaction;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface TransactionMapper {

    @Mapping(source = "categoryId", target = "category.id")
    @Mapping(source = "creditCardId", target = "creditCard.id")
    Transaction toTransaction(TransactionRequestDTO transactionRequestDTO);
}


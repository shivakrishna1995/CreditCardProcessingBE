package com.creditcardprocessing.api.service;

import com.creditcardprocessing.api.dao.CreditCardRepository;
import com.creditcardprocessing.api.dto.CreditCardRequest;
import com.creditcardprocessing.api.model.CreditCardModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreditCardService {

    @Autowired
    private CreditCardRepository ccRepository;

    public CreditCardModel addCreditCard(CreditCardRequest ccRequest) {
        CreditCardModel ccModel = CreditCardModel.build(
                (long) 0L,
                ccRequest.getName(),
                ccRequest.getCard_number(),
                ccRequest.getCard_limit(),
                ccRequest.getBalance()
        );
        return ccRepository.save(ccModel);
    }

    public List<CreditCardModel> getAllCreditCards() {
        return ccRepository.findAll(Sort.by("id").descending());
    }
}

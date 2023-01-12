package com.creditcardprocessing.api.controller;

import com.creditcardprocessing.api.dto.CreditCardRequest;
import com.creditcardprocessing.api.model.CreditCardModel;
import com.creditcardprocessing.api.service.CreditCardService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("credit-card")
public class CreditCardController {

    @Autowired
    private CreditCardService ccService;

    @PostMapping("/add")
    public ResponseEntity<CreditCardModel> addCreditCard(@RequestBody @Valid CreditCardRequest ccRequest) {
        CreditCardModel ccModel = ccService.addCreditCard(ccRequest);
        return new ResponseEntity<>(ccModel, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<CreditCardModel>> getAllCreditCards() {
        List<CreditCardModel> ccList = ccService.getAllCreditCards();
        if(ccList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(ccList, HttpStatus.OK);
    }
}

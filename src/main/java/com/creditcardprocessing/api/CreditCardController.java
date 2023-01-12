package com.creditcardprocessing.api;

import com.creditcardprocessing.api.dto.CreditCardRequest;
import com.creditcardprocessing.api.model.CreditCardModel;
import com.creditcardprocessing.api.service.CreditCardService;
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
    public ResponseEntity<CreditCardModel> addCreditCard(@RequestBody CreditCardRequest ccRequest) {
        try {
            CreditCardModel ccModel = ccService.addCreditCard(ccRequest);
            return new ResponseEntity<>(ccModel, HttpStatus.CREATED);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<CreditCardModel>> getAllCreditCards() {
        try {
            List<CreditCardModel> ccList = ccService.getAllCreditCards();
            if(ccList.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(ccList, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

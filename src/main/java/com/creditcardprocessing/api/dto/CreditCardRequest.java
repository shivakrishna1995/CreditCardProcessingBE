package com.creditcardprocessing.api.dto;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class CreditCardRequest {
    private String name;

    private String card_number;

    private long card_limit;

    private long balance = 0;
}

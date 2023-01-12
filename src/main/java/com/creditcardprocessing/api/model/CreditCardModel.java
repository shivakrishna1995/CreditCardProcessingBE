package com.creditcardprocessing.api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreditCardModel {

    @Id
    @GeneratedValue
    private long id;

    private String name;

    private String card_number;

    private long card_limit;

    private long balance = 0;
}

package com.creditcardprocessing.api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "build")
public class CreditCardModel {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String card_number;

    private Long card_limit;

    private Long balance = 0L;
}

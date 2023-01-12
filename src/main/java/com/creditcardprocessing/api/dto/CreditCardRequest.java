package com.creditcardprocessing.api.dto;

import com.creditcardprocessing.api.annotation.ValidateCreditCardNumber;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class CreditCardRequest {

    @NotNull
    @Size(min=1, message = "provide valid name")
    private String name;

    @NotNull
    @ValidateCreditCardNumber
    private String card_number;

    @NotNull
    @Min(0)
    private Long card_limit;

    private Long balance = 0L;
}

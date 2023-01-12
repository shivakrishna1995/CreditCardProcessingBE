package com.creditcardprocessing.api.dao;

import com.creditcardprocessing.api.model.CreditCardModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditCardRepository extends JpaRepository<CreditCardModel, Long> {
}

package com.example.smallbankapp.generate;

import com.example.smallbankapp.model.Card;
import com.example.smallbankapp.model.Currency;

import java.math.BigDecimal;

public class GenerateCard {
    public static Card generateCard (Currency currency) {
        Card card = new Card();
        card.setBalance(new BigDecimal(0));
        card.setNumber(GenerateCheckDigit.generateCheckDigit());
        card.setCurrency(currency);
        card.setExpirationDate(GenerateExpirationDate.generateExpirationDate());
        card.setCcv(GenerateCCV.generateCCV());
        return card;
    }
}

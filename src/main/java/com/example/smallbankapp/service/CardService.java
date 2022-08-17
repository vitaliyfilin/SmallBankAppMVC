package com.example.smallbankapp.service;

import com.example.smallbankapp.generate.GenerateCCV;
import com.example.smallbankapp.generate.GenerateCard;
import com.example.smallbankapp.generate.GenerateCheckDigit;
import com.example.smallbankapp.generate.GenerateExpirationDate;
import com.example.smallbankapp.model.Card;
import com.example.smallbankapp.model.Currency;
import com.example.smallbankapp.model.User;
import com.example.smallbankapp.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
public class CardService {
    @Autowired
    CardRepository cardRepository;


    public Card saveCard(Currency currency, User user) {
        //if (!cardRepository.existsCardByNumber(GenerateCheckDigit.generateCheckDigit())) {
        Card card = GenerateCard.generateCard(currency);
        card.setUser(user);
        cardRepository.save(card);
        return card;

    }
    public Card updateCard (BigDecimal bigDecimal, Long id) {
        Card card = cardRepository.findById(id).orElse(null);
        assert card != null;
        card.setBalance(card.getBalance().add(bigDecimal));
        cardRepository.save(card);
        return card;
    }


    public List<Card> getAllCards(User user) {
        return cardRepository.findAllByUser(user);
       // return user.getCardList();

        //return cardRepository.findAll();

    }
    public Card getCardById(Long id) {
        return cardRepository.findById(id).get();
        // return user.getCardList();

        //return cardRepository.findAll();

    }


}
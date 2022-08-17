package com.example.smallbankapp.controller;

import com.example.smallbankapp.model.Card;
import com.example.smallbankapp.model.Currency;
import com.example.smallbankapp.model.User;
import com.example.smallbankapp.repository.CardRepository;
import com.example.smallbankapp.repository.UserRepository;
import com.example.smallbankapp.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Controller

public class CardController {
    @Autowired
    CardService cardService;
    @Autowired
    UserRepository userRepository;
    @Autowired
    CardRepository cardRepository;

    //@GetMapping("/addCard")
    //public String addCard(Model model) {
    //    model.addAttribute("currency", List.of(Currency.values()));
    //    return "add_card";
    //}

    @GetMapping("/index")
    public String viewUserPage(Model model, @AuthenticationPrincipal User user) {
        model.addAttribute("listCards", cardService.getAllCards(user));

        return "index";
    }

    @GetMapping("/showNewCardForm")
    public String showNewCardForm(@ModelAttribute("card") Card card) {
        return "new_card";
    }

    @PostMapping("/saveCard")
    public String saveCard(@ModelAttribute("currency") Currency currency, @AuthenticationPrincipal User user) {
        Card card = cardService.saveCard(currency, user);
        return "redirect:/index";
    }
    @PostMapping("/updateCard")
    public String updateCard(@ModelAttribute("balance")BigDecimal bigDecimal, Long id) {

        cardService.updateCard(bigDecimal, id);
        return "redirect:/index";
    }
    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") Long id, Model model) {
        Card card = cardService.getCardById(id);
        model.addAttribute("card", card);
        return "update_card";
    }
    @GetMapping("/landing")
    public String viewLanding() {
        return "landing";
    }
}

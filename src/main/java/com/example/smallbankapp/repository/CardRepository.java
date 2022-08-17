package com.example.smallbankapp.repository;


import com.example.smallbankapp.model.Card;
import com.example.smallbankapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {
    boolean existsCardByNumber(Long number);
    List<Card> findAllByUser (User user);

}

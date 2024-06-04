package com.example.PFA.states;

import com.example.PFA.entities.Demande;
import org.springframework.stereotype.Component;

@Component
public class Refused implements State{


    @Override
    public void handleRequest(Demande demande) {
        System.out.println("This demande has been refused.");
    }

    @Override
    public String getState() {
        return "Refused";
    }
}

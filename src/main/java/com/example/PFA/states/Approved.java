package com.example.PFA.states;

import com.example.PFA.entities.Demande;
import org.springframework.stereotype.Component;

@Component
public class Approved implements State{

    @Override
    public void handleRequest(Demande demande) {
        System.out.println("This demande is already approved.");
    }

    @Override
    public String getState() {
        return "Approved";
    }
}

package com.example.PFA.states;

import com.example.PFA.entities.Demande;
import org.springframework.stereotype.Component;

@Component
public class Pending implements State{

    @Override
    public void handleRequest(Demande demande) {
        System.out.println("This demande is pending approval.");
    }

    @Override
    public String getState() {
        return "Pending";
    }
}

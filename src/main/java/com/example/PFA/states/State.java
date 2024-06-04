package com.example.PFA.states;

import com.example.PFA.entities.Demande;

public interface State {
    void handleRequest(Demande demande);
    String getState();
}

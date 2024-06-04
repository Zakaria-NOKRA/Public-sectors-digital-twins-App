package com.example.PFA.entities;

import com.example.PFA.states.Pending;
import com.example.PFA.states.State;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "demande")
public class Demande {

    @Id
    private String id;
    private State state;

    public Demande(State state) {
        this.state = state;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void applyState() {
        state.handleRequest(this);
    }
}

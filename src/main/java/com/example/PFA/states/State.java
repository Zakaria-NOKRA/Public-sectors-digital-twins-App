package com.example.PFA.states;

import com.example.PFA.entities.Demande;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Pending.class, name = "Pending"),
        @JsonSubTypes.Type(value = Approved.class, name = "Approved"),
        @JsonSubTypes.Type(value = Refused.class, name = "Refused")
})
public interface State {
    void handleRequest(Demande demande);
    String getState();
}

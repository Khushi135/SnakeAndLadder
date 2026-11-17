package org.example.models;

import org.example.enums.SpecialMoveType;

public class SpecialMove {
    private int source;
    private int destination;
    private SpecialMoveType specialMoveType;

    public int getSource() {
        return source;
    }

    public void setSource(int source) {
        this.source = source;
    }

    public int getDestination() {
        return destination;
    }

    public void setDestination(int destination) {
        this.destination = destination;
    }

    public SpecialMoveType getSpecialMoveType() {
        return specialMoveType;
    }

    public void setSpecialMoveType(SpecialMoveType specialMoveType) {
        this.specialMoveType = specialMoveType;
    }
}

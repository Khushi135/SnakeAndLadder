package org.example.models;

import org.example.enums.SpecialMoveType;

public class Move {
    private final int playerId;
    private final int diceValue;
    private final int currentCellOfPlayer;
    private final int tentativeDestination;
    private final int finalDestination;
    private final SpecialMoveType specialMoveType;

    public int getPlayerId() {
        return playerId;
    }

    public int getDiceValue() {
        return diceValue;
    }

    public int getCurrentCellOfPlayer() {
        return currentCellOfPlayer;
    }

    public int getTentativeDestination() {
        return tentativeDestination;
    }

    public int getFinalDestination() {
        return finalDestination;
    }

    public SpecialMoveType getSpecialMoveType() {
        return specialMoveType;
    }

    public Move(int playerId, int diceValue, int currentCellOfPlayer, int tentativeDestination, int finalDestination, SpecialMoveType specialMoveType) {
        this.playerId = playerId;
        this.diceValue = diceValue;
        this.currentCellOfPlayer = currentCellOfPlayer;
        this.tentativeDestination = tentativeDestination;
        this.finalDestination = finalDestination;
        this.specialMoveType = specialMoveType;
    }
}

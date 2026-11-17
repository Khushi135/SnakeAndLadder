package org.example.models;

import org.example.enums.PlayerColorEnum;
import org.example.enums.SpecialMoveType;

public class Player {
    private final int playerId;
    private final String name;
    private final PlayerColorEnum playerColorEnum;
    private int currentPosition;

    public int getPlayerId() {
        return playerId;
    }

    public String getName() {
        return name;
    }

    public PlayerColorEnum getPlayerColorEnum() {
        return playerColorEnum;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public Player(int playerId, String name, PlayerColorEnum playerColorEnum) {
        this.playerId = playerId;
        this.name = name;
        this.playerColorEnum = playerColorEnum;
    }

    public boolean updateCurrentPosition(int newPosition){
        //validate

        if(newPosition > 100 || newPosition < 0){
            System.out.println("invalid position: " + newPosition);
            return false;
        }

        this.currentPosition = newPosition;
        return true;
    }
}
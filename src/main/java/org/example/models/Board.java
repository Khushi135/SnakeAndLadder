package org.example.models;

import java.util.HashMap;

public class Board {
    private final int dimension;
    private final HashMap<Integer, SpecialMove> specialMoveHashMap;

    public Board(int dimension, HashMap<Integer, SpecialMove> specialMoveHashMap) {
        this.dimension = dimension;
        this.specialMoveHashMap = specialMoveHashMap;
    }

    public int getDimension() {
        return dimension;
    }

    public HashMap<Integer, SpecialMove> getSpecialMoveHashMap() {
        return specialMoveHashMap;
    }

    public SpecialMoveAndDestination getFinalDestination(int currentPosition){
        SpecialMove specialMove = specialMoveHashMap.get(currentPosition);
        return new SpecialMoveAndDestination(specialMove != null, specialMove);
    }
}

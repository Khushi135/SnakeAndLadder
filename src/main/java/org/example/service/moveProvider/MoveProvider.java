package org.example.service.moveProvider;

import org.example.models.Move;

public interface MoveProvider {
    Move getMove(int currentValue , int diceValue);
}

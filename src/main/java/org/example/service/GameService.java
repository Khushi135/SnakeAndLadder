package org.example.service;

import org.example.enums.GameStatus;
import org.example.models.Dice;
import org.example.models.Game;
import org.example.models.Move;
import org.example.models.Player;
import org.example.models.SpecialMoveAndDestination;
import org.example.service.WinningStrategy.Exactly100WinningStrategy;
import org.example.service.WinningStrategy.WinningStrategy;
import org.example.service.moveProvider.BotMoveProver;
import org.example.service.moveProvider.HumanMoveProvider;
import org.example.service.moveProvider.MoveProvider;

public class GameService {
    private Dice dice;
    private MoveProvider moveProvider;
    public void startGame(Game game){
        while(game.getGameStatus() == GameStatus.IN_PROGRESS){
            playGame(game);
        }
    }

    public void playGame(Game game){
        // getCurrentPlayer
        // roll dice
        // calculate new position for that player in game service only and validate the value as we have exact 100 winning strategy
        // check for specialMove in board and get final destination
        // update player.currentPosition through its own method
        // update this move in moveHistory
        // check if player wins in same service if yes Complete game else advance turn
        // check if roll dice has value 6 if yes give another chance to same player else call game.advance turn
        Player currentPlayer = game.getCurrentPlayer();
        int diceValue = dice.rollDice();

        int newTentativePotion = currentPlayer.getCurrentPosition() + diceValue;
        if (newTentativePotion > game.getBoard().getDimension()){
            System.out.println("Turn not allowed as new Position is greater than final destination" + "for currentPlayer" + currentPlayer + "newPosition" + newTentativePotion);
            // no need to update player.currentPosition, move history

            Player player = game.nextTurn(currentPlayer);
            game.updateNextPlayer(player);
            return;
        }

        SpecialMoveAndDestination specialMoveAndDestination = game.getBoard().getFinalDestination(newTentativePotion);
        Move move ;
        if (currentPlayer.getName() == "BOT"){
            moveProvider = new BotMoveProver();
            move = moveProvider.getMove();
        }else {
            moveProvider = new HumanMoveProvider();
            move = moveProvider.getMove();
        }

        currentPlayer.updateCurrentPosition(move.getFinalDestination());
        game.addToMoveHistory(move);

        //check winner currently have only one winning strategy

        WinningStrategy winningStrategy = new Exactly100WinningStrategy();
        boolean isWinner = winningStrategy.checkWinner(move.getFinalDestination());

        if(isWinner){
            game.updateWinner(currentPlayer);
            game.setGameStatus(GameStatus.COMPLETED);
            return;
        }
        if (diceValue == 6){
            //we want current player to roll dice again so we will not update the current player value
            return;
        }
        Player player = game.nextTurn(currentPlayer);
        game.updateNextPlayer(player);
        return;
    }
}

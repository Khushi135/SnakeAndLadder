package org.example.models;
import org.example.enums.GameStatus;
import java.util.List;

public class Game {
    private final Board board;
    private final List<Player> players;
    private Player currentPlayer;
    private GameStatus gameStatus;
    private List<Move> moveList;
    private Player winner;

    public Game(Board board, List<Player> players, Player currentPlayer, GameStatus gameStatus) {
        this.board = board;
        this.players = players;
        this.currentPlayer = currentPlayer;
        this.gameStatus = gameStatus;
    }

    public Board getBoard() {
        return board;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public Player nextTurn(Player currentPlayer){
        return players.get(currentPlayer.getPlayerId()+1);
    }

    public void updateNextPlayer(Player player){
        this.currentPlayer = player;
    }

    public void addToMoveHistory(Move move){
        moveList.add(move);
    }

    public void updateWinner(Player player){
        this.winner = player;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public List<Move> getMoveList() {
        return moveList;
    }

    public void setMoveList(List<Move> moveList) {
        this.moveList = moveList;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }
}

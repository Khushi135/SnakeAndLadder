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

    public List<Move> getMoveList() {
        return moveList;
    }

    public Player getWinner() {
        return winner;
    }

    public void completeGame(Player winner) {

        if (this.gameStatus != GameStatus.IN_PROGRESS) {
            throw new IllegalStateException("Game is not in progress");
        }

        this.winner = winner;
        this.gameStatus = GameStatus.COMPLETED;
    }
}

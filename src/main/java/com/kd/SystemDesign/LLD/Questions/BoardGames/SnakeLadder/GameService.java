package com.kd.SystemDesign.LLD.Questions.BoardGames.SnakeLadder;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GameService {

    private Queue<Player> playersQueue;
    private Board board;
    private GameStatus gameStaus;

    GameService(List<Player> players) {
        playersQueue = new LinkedList<>();
        playersQueue.addAll(players);
        board = new Board();
        gameStaus = GameStatus.IN_PROGRESS;
    }

    public void startGame() {
        while (true) {
            Player player = playersQueue.poll();
            System.out.print("Player chance" + player.getName());
            int n = Dice.throwDice();
            System.out.println(" number " + n);
            board.move(player, n);
            if (board.isWinner(player)) {
                System.out.println("Player is winner" + player.getName());
                gameStaus = GameStatus.COMPLETED;
                return;
            }
            playersQueue.add(player);
        }
    }

}

package com.kd.SystemDesign.LLD.Questions.Tictactoe;

public class TicTacToeGameDemo {
    public static void main(String[] args) {
        Player player1 = new Player("Player 1", Symbol.X);
        Player player2 = new Player("Player 2", Symbol.O);

        Game ticTacToeGame = new Game(player1, player2, 3);

        ticTacToeGame.playMove(0, 0);
        ticTacToeGame.printBoard();

        ticTacToeGame.playMove(0, 1);
        ticTacToeGame.printBoard();

        ticTacToeGame.playMove(2, 2);
        ticTacToeGame.printBoard();

        ticTacToeGame.playMove(0, 2);
        ticTacToeGame.printBoard();

        ticTacToeGame.playMove(1, 1);
        ticTacToeGame.printBoard();

    }
}
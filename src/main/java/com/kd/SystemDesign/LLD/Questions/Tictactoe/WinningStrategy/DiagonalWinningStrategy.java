package com.kd.SystemDesign.LLD.Questions.Tictactoe.WinningStrategy;

import com.kd.SystemDesign.LLD.Questions.Tictactoe.Board;
import com.kd.SystemDesign.LLD.Questions.Tictactoe.Symbol;

public class DiagonalWinningStrategy implements WinningStrategy {
    @Override
    public boolean checkWinner(Board board, Symbol symbol) {
        // Main diagonal
        boolean mainDiagonalMatch = true;
        for (int i = 0; i < board.getSize(); i++) {
            if (board.getSymbol(i, i) != symbol) {
                mainDiagonalMatch = false;
                break;
            }
        }
        if (mainDiagonalMatch) return true;

        // Anti-diagonal
        boolean antiDiagonalMatch = true;
        for (int i = 0; i < board.getSize(); i++) {
            if (board.getSymbol(i, board.getSize() - 1 - i) != symbol) {
                antiDiagonalMatch = false;
                break;
            }
        }
        return antiDiagonalMatch;
    }
}

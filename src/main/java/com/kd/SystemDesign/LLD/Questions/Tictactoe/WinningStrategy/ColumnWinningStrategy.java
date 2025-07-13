package com.kd.SystemDesign.LLD.Questions.Tictactoe.WinningStrategy;

import com.kd.SystemDesign.LLD.Questions.Tictactoe.Board;
import com.kd.SystemDesign.LLD.Questions.Tictactoe.Symbol;

public class ColumnWinningStrategy implements WinningStrategy {
    @Override
    public boolean checkWinner(Board board, Symbol symbol) {
        for (int i = 0; i < board.getSize(); i++) {
            boolean allMatch = true;
            for (int j = 0; j < board.getSize(); j++) {
                if (board.getSymbol(j, i) != symbol) {
                    allMatch = false;
                    break;
                }
            }
            if (allMatch) return true;
        }
        return false;
    }
}

package com.kd.SystemDesign.LLD.Questions.Tictactoe.WinningStrategy;

import com.kd.SystemDesign.LLD.Questions.Tictactoe.Board;
import com.kd.SystemDesign.LLD.Questions.Tictactoe.Symbol;

public interface WinningStrategy {
    boolean checkWinner(Board board, Symbol symbol);
}
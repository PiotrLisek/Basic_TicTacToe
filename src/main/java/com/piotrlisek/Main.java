package com.piotrlisek;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static String winner;
    private static String currentPlayerMark;

    public static void main(String[] args) {
        String[] board = new String[9];
        Scanner scanner = new Scanner(System.in);
        String input;
        currentPlayerMark = "X";
        winner = "-";

        for (int i = 0; i < 9; i++) {
            board[i] = String.valueOf(i+1);
        }

        System.out.println("TicTacToe Game");
        System.out.println("---------\n");
        System.out.println("X's will play first. Select a number to place X:");

        while (!((winner.equals("X")) || (winner.equals("O") || (winner.equals("draw"))))) {

            showBoard(board);
            input = scanner.nextLine();

            if (input.matches("[1-9]")) {
                int index = Integer.parseInt(input);
                if (!(board[index - 1].equals("X") || board[index - 1].equals("O"))) {
                    System.out.println();
                    board[index - 1] = currentPlayerMark;
                    checkWinner(board);
                    if (winner.equals("X") || winner.equals("Y")) {
                        showBoard(board);
                        System.out.println("Player " + currentPlayerMark + " won the game");
                        break;
                    } else if (winner.equals("draw")) {
                        showBoard(board);
                        System.out.println("It's a draw");
                        break;
                    }
                    changePlayer();
                    System.out.println("Player " + currentPlayerMark + ", enter an unselected slot with number from 1 to 9");
                } else {
                    System.out.println("\nThe place have to be empty. Player " + currentPlayerMark + ", enter an unselected slot with number from 1 to 9");
                }
            } else if (input.equals("exit")) {
                System.out.println("You exited the game");
                break;
            } else {
                System.out.println("\nEnter an unselected slot with number from 1 to 9");
            }
        }
    }

    private static String checkWinner(String[] board) {
        for (int i = 0; i < 8; i++) {
            String line = null;
            switch (i) {
                case 0:
                    line = board[0] + board[1] + board[2];
                    break;
                case 1:
                    line = board[3] + board[4] + board[5];
                    break;
                case 2:
                    line = board[6] + board[7] + board[8];
                    break;
                case 3:
                    line = board[0] + board[3] + board[6];
                    break;
                case 4:
                    line = board[1] + board[4] + board[7];
                    break;
                case 5:
                    line = board[2] + board[5] + board[8];
                    break;
                case 6:
                    line = board[0] + board[4] + board[8];
                    break;
                case 7:
                    line = board[2] + board[4] + board[6];
                    break;
            }
            if (line.equals("XXX")) {
                return winner = "X";
            } else if (line.equals("OOO")) {
                return winner = "O";
            }
        }
        for (int i = 0; i < 9; i++) {
            if (Arrays.asList(board).contains(String.valueOf(i+1))) {
                break;
            }
            else if (i == 8)   return winner = "draw";
        }
        return null;
    }

    private static void changePlayer() {
        if (currentPlayerMark.equals("X")) {
            currentPlayerMark = "O";
        } else {
            currentPlayerMark = "X";
        }
    }

    private static void showBoard(String[] board) {
        System.out.println(board[0] + " | " + board[1] + " | " + board[2]);
        System.out.println("--------");
        System.out.println(board[3] + " | " + board[4] + " | " + board[5]);
        System.out.println("--------");
        System.out.println(board[6] + " | " + board[7] + " | " + board[8]);
    }
}

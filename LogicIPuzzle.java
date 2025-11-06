/* 
 * @author Antõnio Barbosa 65659 e Tomás Martins (numero)
 */

import java.util.Scanner;

public class LogicIPuzzle {
    public static void main(String[]args){
        int rows = 0;
        int cols = 0;
        String puzzle;
        if(args.length > 0){
            rows = Integer.parseInt(args[0]);
            cols = Integer.parseInt(args[1]);
            puzzle = args[2];
        }else{
            Scanner input = new Scanner(System.in);
            System.out.print("Número de linhas (1..30): ");
            rows = input.nextInt();
            System.out.print("Número de colunas (1..30): ");
            cols = input.nextInt();
            System.out.print("Puzzle (string de tamanho "+ (rows*cols) +" com '.', 'P', '1'..'9'): ");
            puzzle = input.nextLine();
        }

        if(rows < 1 || rows > 30 || cols < 1 || cols > 30){
            System.out.println("Os dados fornecidos não definem um puzzle válido. Verifique tamanho/pistas repetidas/posições.");
            return;
        }

        
        if(puzzle.length(); != rows * cols){
            System.out.println("Os dados fornecidos não definem um puzzle válido. Verifique tamanho/pistas repetidas/posições.");
            return;
        }

        if(!isValidPuzzleInConstruction(puzzle) || !IsPuzzle(rows, cols, puzzle)){
            System.out.println("Os dados fornecidos não definem um puzzle válido. Verifique tamanho/pistas repetidas/posições.");
            return;
        }

    }
}


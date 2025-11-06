/* 
 * @author Antõnio Barbosa 65659 e Tomás Martins (numero)
 */

import java.util.Scanner;

public class LogicIPuzzle {
    public static void main(String[]args){
        int rows;
        int cols;        
        String puzzle;
        if(args.length > 0){
        rows = Integer.parseInt(args[0]);
        cols = Integer.parseInt(args[1]);
        puzzle = args[2];
        } else{
            Scanner input = new Scanner(System.in);
            System.out.print("Número de linhas (1..30): ");
            rows = input.nextInt();
            System.out.print("Número de colunas (1..30): ");
            cols = input.nextInt();
            System.out.println("Puzzle (string de tamanho "+ (cols*rows) +" com '.', 'P', '1'..'9'):");
        }
    System.out.println("Puzzle Inicial: ");
    }

}

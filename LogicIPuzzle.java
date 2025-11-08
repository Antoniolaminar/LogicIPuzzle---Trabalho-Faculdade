/* 
 * @author Antônio Barbosa 65659 e Tomás Martins (numero)
 */

import java.util.Scanner;

public class LogicIPuzzle {
    public static void main(String[] args) {
        int rows = 0;
        int cols = 0;
        String puzzle;
        if (args.length > 0) {
            rows = Integer.parseInt(args[0]);
            cols = Integer.parseInt(args[1]);
            puzzle = args[2];
        } else {
            Scanner input = new Scanner(System.in);
            System.out.print("Número de linhas (1..30): ");
            rows = input.nextInt();
            System.out.print("Número de colunas (1..30): ");
            cols = input.nextInt();
            input.nextLine();
            System.out.print("Puzzle (string de tamanho " + (rows * cols) + " com '.', 'P', '1'..'9'): ");
            puzzle = input.nextLine();
        }

        if (rows < 1 || rows > 30 || cols < 1 || cols > 30) {
            System.out.println(
                    "Os dados fornecidos não definem um puzzle válido. Verifique tamanho/pistas repetidas/posições.");
            return;
        }

        if (puzzle.length() != rows * cols) {
            System.out.println(
                    "Os dados fornecidos não definem um puzzle válido. Verifique tamanho/pistas repetidas/posições.");
            return;
        }

        if (!isValidPuzzleInConstruction(puzzle) || !isPuzzle(rows, cols, puzzle)) {
            System.out.println(
                    "Os dados fornecidos não definem um puzzle válido. Verifique tamanho/pistas repetidas/posições.");
            return;
        }
        Scanner sc = new Scanner(System.in);
        play(sc, rows, cols, puzzle);
        sc.close();
    }

    public static void play(Scanner sc, int rows, int cols, String puzzle) {
        String spc = puzzle;
        boolean gameplayloopON = true;
        boolean isResolvido = false;

        System.out.println("Puzzle Inicial: ");

        printPuzzleInConstruction(rows, cols, spc);

        while (gameplayloopON && !isResolvido) {
            System.out.println("Introduza uma jogada (ou -1 para sair).");
            System.out.print("Posição: ");

            if (sc.hasNextInt()) {
                int pos = sc.nextInt();

                if (pos == -1) {
                    gameplayloopON = false;
                    System.out.println("Jogo terminado pelo utilizador.");
                } else {
                    System.out.print("Preencher com: ");
                    char c = sc.next().charAt(0);

                    if (isValidMove(spc, puzzle, pos, c)) {
                        spc = playMove(spc, puzzle, pos, c);
                        printPuzzleInConstruction(rows, cols, spc);

                        if (isSolution(rows, cols, puzzle, spc)) {
                            System.out.println("Parabéns - o puzzle está resolvido!");
                            isResolvido = true;
                        }

                    } else {
                        System.out.println("Jogada Inválida.");
                    }

                }
            } else {
                sc.next();
                System.out.println("Jogada inválida");
            }

        }
    }

    /**
     * Funcao rowOfPosition vai ser utilizada para, apartir de uma posição,
     * encontrar a sua dada linha no puzzle,
     * 
     * @param 'pos'        posição exata do ponto escolhido
     * @param 'numColumns' número de colunas do puzzle feito
     * @return o número da linha em que está a posição
     * @requires pos >= 0 (não negativo pode ser zero) && numColumns > 0 (só
     *           positivos)
     */
    public static int rowOfPosition(int pos, int numColumns) {
        return ((pos / numColumns) + 1);
    }

    /**
     * Funcao columnOfPosition vai ser utilizada para, apartir de uma posição,
     * encontrar a sua dada coluna no puzzle
     * 
     * @param 'pos'        posição exata do ponto escolhido
     * @param 'numColumns' número de colunas do puzzle feito
     * @return o número da linha em que está a posição
     * @requires pos >= 0 && numColumns > 0
     */
    public static int columnOfPosition(int pos, int numColumns) {
        return ((pos % numColumns) + 1);
    }

    /**
     * ..Funçao positionnumber..
     * serve para calcular a posiçao da grelha a partir da linha e da coluna
     * row, column e numColumns sao positivos
     * 
     * @param row        numero da linha
     * @param column     numero da coluna
     * @param numColumns numero total de colunas
     * @requires row > 0 && column > 0 && numColumns > 0
     * @ensures devolve a posiçao correspondente na grelha linearizada
     * @return posiçao correspondente na grelha
     */
    public static int positionNumber(int row, int column, int numColumns) {
        if (row <= 0 || column <= 0 || numColumns <= 0) {
            System.out.println("valor invalido");
        }
        return ((row - 1) * numColumns) + (column - 1);
    }

    /**
     * Funcao Lógica de checagem de fator, para que existam retangulos definidos, é
     * preciso checar diversas formas de formar um retangulo (i.e)
     * um retangulo pode ser de 6x1 ou 3x2, isto é importante, esta funcao serve
     * para checar estes fatores, se é de fato ou nao o modo, de um dos retangulos
     * do puzzle.
     * 
     * @param 'number' número de alguma dimensão do retangulo
     * @param 'factor' possível valor que a outra dimensao do retangulo pode tomar,
     *                 o fator do numero number
     * @return true se é um fator válido, caso contrário return false
     * @requires number > 0 && factor > 0
     */
    public static boolean isIntFactor(int number, int factor) {

        return (number % factor == 0);
    }

    /**
     * ..Funçao getintfactor..
     * a funçao vai receber dois numeros inteiros positivos : number e factor e vai
     * devolver o numero int q multiplicado por factor da number
     * 
     * @param number numero inteiro positivo
     * @param factor fator inteiro positivo
     * @requires number > 0 && factor > 0 && (number % factor ==0)
     * @ensures devolve o valor inteiro tal que n*factor==number
     * @return numero inteiro k tal q n* facotr== number
     */
    public static int getIntfactor(int number, int factor) {
        return number / factor;
    }

    /**
     * Funcao sumDigits calcula a soma de todos os números dentro d euma string e
     * ignora os seus caracteres, que nao representam numeros por causa de metodos
     * da classe character
     * 
     * @param 's' String com caracteres e numeros
     * @return 'sumString' a soma dos numeros dentro dessa string
     * @requires s != null; a String nao pode ser null
     */
    public static int sumDigits(String s) {
        int sumString = 0;
        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            // aqui foi meio estranho tentar fazer com o parseint mas depois de olhar a doc
            // da classe character eu encontrei
            // esses dois metodos que podem ser bem uteis mais pra frente 'IsDigit' e
            // 'getNumericValue'
            if (Character.isDigit(c)) {
                sumString += Character.getNumericValue(c);
            }
        }
        return sumString;
    }

    /**
     * ..Funçao countCharOccurence..
     * Recebe uma String s (nao null) e um caracter 'c'
     * devolve quantas vezes o caracter aparece na string
     * 
     * @param s String a analizar (nao null)
     * @param c é um caracter
     * @requires s !=null
     * @ensures devolve o numero de ocorrencias de c em s enqnt >=0
     * @return numero de vezes q o caracter aparece na string
     */
    public static int countCharOccurence(String s, char c) {
        int count = 0; // contador de ocorrencias

        // percorre todos os caracteres da string
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                count++;
            }
        }
        return count;
    }

    /**
     * Funcao countDigitOccurrence conta o número de vezes que um digito aparece na
     * String, isso é útil no caso dos numeros de 1-9
     * 
     * @param 's'    captura qualquer string e analisa seus caracteres
     * @param digito que se pretende contar, como existem entre 1-9 digitos, o valor
     *               será comparado em 10 possibilidades
     * @return numero de vezes que o digito(numero) 'd' aparece na String s
     * @requires s != null && d>0 && d<=9
     */
    public static int countDigitOccurrence(String s, int d) {
        char digitOccurs = Character.forDigit(d, 10);
        int count = 0;
        for (int k = 0; k < s.length(); k++) {
            if (s.charAt(k) == digitOccurs) {
                count++;
            }
        }
        return count;
    }

    /**
     * ..Funçao hasdigit..
     * recebe uma string s (nao null) e um digito inteiro d (0-9)
     * devolve true se o digito aparecer em s ou false no caso contrario
     * 
     * @param s String a analisar(nao null)
     * @param d digito inteiro entre 0 e 9
     * @return boolenao indicando se o digito d aparece em s
     * @requires s !=null && (d>=0 && d<=9)
     * @ensures devolve true se o digito d ocorre em s; false caso contrario
     */

    public static boolean hasDigit(String s, int d) {
        // converto agr o digito inteiro para caracter
        char digitChar = (char) (d + '0'); // tipo 3 passa para '3'

        // percorre todos o caracteres da string atraves de um ciclo
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == digitChar) { // se encontrar o digito
                return true;
            }
        }
        return false; // se nao encontrou
    }

    /**
     * Funcao de Suporte hasChar faz o mesmo que hasDigit mas para caracteres
     * especificos, feito para facilitar IsValidPuzzleInConstruction
     * 
     * @param String s a ser percorrida
     * @param char   c caractere especifico que se quer saber se existe na string
     * @return true se c aparecer em s
     */
    public static boolean hasChar(String s, char c) {
        for (int m = 0; m < s.length(); m++) {
            if (c == s.charAt(m)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Funcao logica isFillingChar que define se um caractere pode ou não fazer
     * parte do puzzle,(i.e) no puzzle que só contém espaços pretos 'P'
     * e espaços brancos que vão ser prenchidos pelos números, é preciso verificar
     * se é um desses caracteres 'P' ou digito de 1-9
     * 
     * @param 'c' caractere a ser filtrado
     * @return true se o caractere for 'P' ou digito de 1-9
     */
    public static boolean isFillingChar(char c) {
        return (c == 'P') || (c > '0' && c <= '9');
        // da pra comparar um char com um "número" pelo unicode do caractere do numero,
        // entao da pra fazer
        // comparacao direta pela traducao direta do ascii do numero q e tipo 47 -> 0
        // ate 56 -> 9, sobe normal
    }

    /**
     * Funcao Logica isValidPuzzleInConstruction verifica se spc é uma String valida
     * para ser um puzzle modificavel e jogavel
     * 
     * @param String spc string a ser validada como puzzle
     * @return true se contém digitos de 1-9 e caracteres . e P
     * @requires spc != null
     */
    public static boolean isValidPuzzleInConstruction(String spc) {
        if (spc == null) {
            return false;
        }
        for (int i = 0; i < spc.length(); i++) {
            char c = spc.charAt(i);
            if (c != '.' && c != 'P' && !(c >= '1' && c <= '9')) {
                return false;
            }
        }
        return true;
    }

    /**
     * ..Funçao isFilled
     * verifica se todas as funçoes de uma string estao preenchidas
     * se tiver '.' considera-se q a posiçao nao esta preenchida
     * 
     * @param spc String a analisar
     * @return booleano indicando se todas as posiçoes estao preenchidas
     * @requires spc != null
     * @ensures devolve true se nao tiver '.', false caso contrario
     */
    public static boolean isFilled(String spc) {
        for (int i = 0; i < spc.length(); i++) {
            if (spc.charAt(i) == '.') {
                return false;
            }
        }
        return true;
    }

    /**
     * ..Funçao hasAdjacentPositionWithDifferentDigits..
     * verificar se numa grelha com linhas e colunas representada pela string spc
     * existem duas posiçoes adjacentes ( ao lado ou em baixo) com digitos
     * diferentes
     * 
     * @param rows numero de linhas
     * @param cols numero de colunas
     * @param spc  string com tamanho de rows x cols que representa a grelha
     * @return true se existirem posiçoes adjacentes com digitos diferentes ou false
     *         caso contrario
     * @requires row > 0 && spc != null && spc.length() == rows*cols
     */
    public static boolean hasAdjacentPositionWithDifferentDigits(int rows, int cols, String spc) {
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                int pos = r * cols + c; // cada linha tem um nº de colunas, cols, entao andamos r*cols, tipo estamos na
                                        // linha 1 que tem 4 colunas ( 1*4, quer vai andar 4 casas para a direita e vai
                                        // parar na linha abaixo) e depois +c, que é a coluna onde estamos
                                        // comparar com a posiçao à direita

                char caractere = spc.charAt(pos);// guardar caractere :(
                if (c < cols - 1) {
                    char right = spc.charAt(pos + 1);
                    if (Character.isDigit(caractere) && Character.isDigit(right) && caractere != right) {
                        return true;
                    }
                }
                // comparar com a posiçao abaixo
                if (r < rows - 1) {
                    char down = spc.charAt(pos + cols);
                    if (Character.isDigit(caractere) && Character.isDigit(down) && caractere != down) {
                        return true;
                    }
                }
            }
        }
        return false; // se nao encontrou digitos diferentes lado a lado
    }

    /**
     * ..Funçao PrintPuzzleInConstruction..
     * imprime uma grelha do puzzle
     * 
     * @param rows numero de linhas
     * @param cols numero de colunas
     * @param spc  string de tamanho rows*cols que representa o puzzle
     * @requires rows > 0 && cols > 0 && spc!= null && spc.length()== rows*cols
     * @ensures imprime spc na forma de grelha
     */
    public static void printPuzzleInConstruction(int rows, int cols, String spc) {
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                int pos = r * cols + c; // cada linha tem um nº de colunas, cols, entao andamos r*cols,
                // tipo estamos na linha 1 que tem 4 colunas ( 1*4, quer vai andar 4 casas para
                // a direita e vai parar na linha abaixo)
                // e depois +c, que é a coluna onde estamos
                System.out.print(spc.charAt(pos) + " ");
            }
            System.out.println();
        }
    }

    /**
     * Funcao isPuzzle verifica se a string puzzle em construcao se comporta como um
     * puzzle, so pode ter digitos de pistas ou pretas
     * 
     * @param rows numero de linhas dadas
     * @param cols numero de colunas do puzzle
     * @param spc  string analisada tipo puzzle em construcao
     * @returns true se tiver tamanho rows*cols e se digitos nao sao repetidos e tem
     *          tamanho igual soma de n de pistas e pretas
     */
    public static boolean isPuzzle(int rows, int cols, String spc) {
        // tamanho do puzzle é do tamanho do input feito
        if ((rows * cols) != spc.length()) {
            return false;
        }
        for (int d = 1; d <= 9; d++) {
            if (countDigitOccurrence(spc, d) > 1) {
                return false;
            }
        }
        return true;
    }

    /**
     * Funcao isRectangle verifica se a pista formada por um digito e um retangulo,
     * pega a posicao aparicao do digito como canto superior esquerdo
     * 
     * @param rows       n de linhas do puzzle
     * @param cols       n de colunas do puzzle
     * @param spc        string do puzzle em construcao que vai ser verificado
     * @param digito     o digito do retangulo constituido
     * @param posInicial posicao inicial do digito do retangulo, aonde fica no
     *                   puzzle
     * @return true se a soma das ocorrencias do digito na linha em que se encontra
     *         forma um lado de n digitos e o mesmo para as colunas
     */
    public static boolean isRectangle(int rows, int cols, String spc, int digito, int posInicial) {
        char digitChar = Character.forDigit(digito, 10);
        int linhaInicial = rowOfPosition(posInicial, cols);
        int colunaInicial = columnOfPosition(posInicial, cols);

        if (spc.charAt(posInicial) != digitChar) {
            return false;
        }

        int largura = 1;
        int coluna = colunaInicial + 1;
        while (coluna <= cols && spc.charAt(positionNumber(linhaInicial, coluna, cols)) == digitChar) {
            largura++;
            coluna++;
        }

        if (!isIntFactor(digito, largura))
            return false;
        int altura = getIntfactor(digito, largura);

        if (linhaInicial + altura - 1 > rows || colunaInicial + largura - 1 > cols) {
            return false;
        }

        for (int r = linhaInicial; r < linhaInicial + altura; r++) {
            for (int j = colunaInicial; j < colunaInicial + largura; j++) {
                if (spc.charAt(positionNumber(r, j, cols)) != digitChar) {
                    return false;
                }
            }
        }

        return countDigitOccurrence(spc, digito) == digito;

    }

    /**
     * Funcao isSolution verifica se string puzzle em construcao é solucao valida ou
     * nao
     * 
     * @param rows   n de linhas
     * @param cols   n de colunas
     * @param puzzle
     * @param spc
     * @return true
     */
    public static boolean isSolution(int rows, int cols, String puzzle, String spc) {
        // spc e puzzle tem que ter mesmo tamanho
        if (spc.length() != puzzle.length()) {
            return false;
        }
        // spc tem que estar cheio
        if (!isFilled(spc)) {
            return false;
        }
        // tem os mesmos caracteres
        for (int i = 0; i < puzzle.length(); i++) {
            char c = puzzle.charAt(i);
            char spcChar = spc.charAt(i);
            if (c != '.' && c != spcChar) {
                return false;
            }
        }
        // cada pista d ocorre exatamente d vezes ou nao é valido
        for (int d = 1; d <= 9; d++) {
            int spcCount = countDigitOccurrence(spc, d);
            boolean temPistas = hasDigit(puzzle, d);

            if (temPistas && spcCount != d) {
                return false;
            } else if (!temPistas && spcCount > 0) {
                return false;
            }
        }

        for (int d = 1; d <= 9; d++) {
            if (hasDigit(puzzle, d)) {
                boolean isRetanguloValido = false;

                for (int j = 0; j < spc.length(); j++) {
                    if (spc.charAt(j) == Character.forDigit(d, 10) && isRectangle(rows, cols, spc, d, j)) {
                        isRetanguloValido = true;
                    }
                }
                if (!isRetanguloValido) {
                    return false;
                }
            }
        }

        // os retangulos das pistas estao de fato separados
        if (hasAdjacentPositionWithDifferentDigits(rows, cols, spc)) {
            return false;
        }
        // passa por todas as verificacoes entao e solucao
        return true;
    }

    /**
     * ..funçao isValidMove
     * verificar se a jogada é valida ou nao
     * 
     * @param spc    string que representa o puzzle
     * @param puzzle string com tamanho igual a spc que representa o puzzle(para
     *               alguma grelha)
     * @param pos    inteiro que representa a posiçao da jogada
     * @param c      caracter que representa a açao da jogada
     * @return true se o caracter for uma pista e false caso contrario
     */
    public static boolean isValidMove(String spc, String puzzle, int pos, char c) {
        if (pos < 0 || pos >= puzzle.length()) { // vemos se a posiçao esta dentro da grelha
            return false;
        }
        if (puzzle.charAt(pos) != '.') { // agr vemos se a posiçao ja tem uma pista e para isso verificamos se ja tem
                                         // alguma cena diferente de '.'
            return false;
        }
        if (c != '.' && c != 'P' && !(c >= '1' && c <= '9')) {
            return false; // se n for valido
        }
        // vericar agr se for digito, se existe ccomo pista no puzzle
        if (c >= '1' && c <= '9') {
            boolean existenopuzzle = false; // começa-se com false pq ainda n se encontrou nenhuma pista
            for (int i = 0; i < puzzle.length(); i++) {
                if (puzzle.charAt(i) == c) {
                    existenopuzzle = true;
                }
            }
            if (!existenopuzzle) {
                return false;
            }
        }
        return true;// se tiver tudo certo
    }

    /**
     * ..Funçao playMove
     * pega numa string da soluçao em construçao(spc) e substitui um dos caracteres
     * dessa string pela jogada (c) na posiçao (pos)
     * 
     * @param spc    string que representa uma soluçao-puzzle-em-construçao
     * @param puzzle string que se assume que representa um puzzle(para alguma
     *               grelha)
     * @param pos    inteiro que representa a posiçao da jogada
     * @param c      caracter que representa a açao da jogada
     * @return String que representa a soluçao-puzzle-em-construçao que resulta de
     *         efetuar a jogada em spc
     */
    public static String playMove(String spc, String puzzle, int pos, char c) {
        StringBuilder sb = new StringBuilder(spc); // criamos um stringBuilder para modificar o texto, isto pq as
                                                   // strings normais sao imutaveis logo n podemos alterá-la
        sb.setCharAt(pos, c); // por o caracter introduzido na posiçao escolhida
        return sb.toString();
    }

}

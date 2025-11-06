import java.util.Scanner;

public class FuncoesIniciais{

    /** Funcao rowOfPosition vai ser utilizada para, apartir de uma posição, encontrar a sua dada linha no puzzle,
     * @param 'pos' posição exata do ponto escolhido
     * @param 'numColumns' número de colunas do puzzle feito
     * @return o número da linha em que está a posição
     * @requires pos >= 0 (não negativo pode ser zero) && numColumns > 0 (só positivos) 
     */
    public static int rowOfPosition(int pos, int numColumns){
        return ((pos/numColumns)+1);
    }
    /** Funcao columnOfPosition vai ser utilizada para, apartir de uma posição, encontrar a sua dada coluna no puzzle
     * @param 'pos' posição exata do ponto escolhido
     * @param 'numColumns' número de colunas do puzzle feito
     * @return o número da linha em que está a posição
     * @requires pos >= 0 && numColumns > 0
     */
    public static int columnOfPosition(int pos, int numColumns){
        return ((pos%numColumns)+1);
    }
    /**
 * ..Funçao positionnumber..
 * serve para calcular a posiçao da grelha a partir da linha e da coluna
 * row, column e numColumns sao positivos
 * @param row numero da linha
 * @param column numero da coluna
 * @param numColumns numero total de colunas
 * @requires row > 0 && column > 0 && numColumns > 0
 * @ensures devolve a posiçao correspondente na grelha linearizada
 * @return posiçao correspondente na grelha
 */
public static int positionNumber(int row, int column, int numColumns){
    if(row<= 0 || column<= 0 || numColumns<=0){
        System.out.println("valor invalido");
    }
    return (row * numColumns) * column;
}
    /** Funcao Lógica de checagem de fator, para que existam retangulos definidos, é preciso checar diversas formas de formar um retangulo (i.e)
     * um retangulo pode ser de 6x1 ou 3x2, isto é importante, esta funcao serve para checar estes fatores, se é de fato ou nao o modo, de um dos retangulos
     * do puzzle.
     * @param 'number' número de alguma dimensão do retangulo
     * @param 'factor' possível valor que a outra dimensao do retangulo pode tomar, o fator do numero number
     * @return true se é um fator válido, caso contrário return false
     * @requires number > 0 && factor > 0
     */
    public static boolean isIntFactor(int number, int factor){
        
        return (number%factor == 0);
    }
    /**
 * ..Funçao getintfactor..
 * a funçao  vai receber dois numeros inteiros positivos : number e factor e vai devolver o numero int q multiplicado por factor da number
 * @param number numero inteiro positivo
 * @param factor fator inteiro positivo
 * @requires number > 0 && factor > 0 && (number % factor ==0)
 * @ensures devolve o valor inteiro tal que n*factor==number
 * @return numero inteiro k tal q n* facotr== number
 */
public static int getIntfactor(int number, int factor){
    //agr vejo se sao validos
    if(number<= 0 || factor <= 0){
        System.out.println("os valores devem ser positivos.");
    }
    //verifico se factor é realmente um fator inteiro de number, number%factor==0
    if(number%factor !=0){
        System.out.println("O valor de factor nao é um fator inteiro de number.");
    }
    //se passou calculamos o valor , o nº q multiplicado por factor da number, number/factor
    int resultado = number / factor;

    return resultado;
}
    /** Funcao sumDigits calcula a soma de todos os números dentro d euma string e ignora os seus caracteres, que nao representam numeros por causa de metodos
     * da classe character
     * @param 's' String com caracteres e numeros
     * @return 'sumString' a soma dos numeros dentro dessa string
     * @requires s != null; a String nao pode ser null
     */
    public static int sumDigits(String s){
        int sumString = 0;
            for(int r = 0; r <= s.length();r++){
                char c = s.charAt(r);
                // aqui foi meio estranho tentar fazer com o parseint mas depois de olhar a doc da classe character eu encontrei
                // esses dois metodos que podem ser bem uteis mais pra frente 'IsDigit' e 'getNumericValue'
                if (Character.isDigit(c)){
                    sumString += Character.getNumericValue(c);
                }
            }
            return sumString; 
    }
    /**
 * ..Funçao countCharOccurence..
 * Recebe uma String s (nao null) e um caracter 'c'
 * devolve quantas vezes o caracter aparece na string
 * @param s String a analizar (nao null)
 * @param c é um caracter 
 * @requires s !=null
 * @ensures devolve o numero de ocorrencias de c em s enqnt >=0
 * @return numero de vezes q o caracter aparece na string
 */
public static int countCharOccurence(String s, char c){
    int count = 0; //contador de ocorrencias

    //percorre todos os caracteres da string
    for(int i = 0; i< s.length(); i++){
        if(s.charAt(i) == c){
            count ++;
        }
    }
    return count;
}
    /** Funcao countDigitOccurrence conta o número de vezes que um digito aparece na String, isso é útil no caso dos numeros de 1-9
     * @param 's' captura qualquer string e analisa seus caracteres
     * @param digito que se pretende contar, como existem entre 1-9 digitos, o valor será comparado em 10 possibilidades
     * @return numero de vezes que o digito(numero) 'd' aparece na String s
     * @requires s != null && d>0 && d<=9
     */
    public static int countDigitOccurrence(String s, int d){
        char digitOccurs = Character.forDigit(d, 10);
        int count = 0;
        for(int k = 0; k <s.length(); k++){
            if(s.charAt(k)==digitOccurs){
                count++;
            }
        }
        return count;
    }
    /**
 * ..Funçao hasdigit..
 * recebe uma string s (nao null) e um digito inteiro d (0-9)
 * devolve true se o digito aparecer em s ou false no caso contrario
 * @param s String a analisar(nao null)
 * @param d digito inteiro entre 0 e 9
 * @return boolenao indicando se o digito d aparece em s
 * @requires s !=null && (d>=0 && d<=9)
 * @ensures devolve true se o digito d ocorre em s; false caso contrario
 */

public static boolean hasDigit(String s, int d){
    //converto agr o digito inteiro para caracter
    char digitChar = (char) (d + '0'); //tipo 3 passa para '3'

    //percorre todos o caracteres da string atraves de um ciclo
    for(int i = 0; i < s.length(); i++){
        if(s.charAt(i) == digitChar){ //se encontrar o digito
            return true;
        }
    }
    return false; // se nao encontrou
}
    /** Funcao de Suporte hasChar faz o mesmo que hasDigit mas para caracteres especificos, feito para facilitar IsValidPuzzleInConstruction
     * @param String s a ser percorrida
     * @param char c caractere especifico que se quer saber se existe na string
     * @return true se c aparecer em s
    */
    public static boolean hasChar(String s,char c){
        for(int m = 0; m<s.length();m++){
            if(c == s.charAt(m)){
                return true;
            }
        }
        return false;
    }
    /** Funcao logica isFillingChar que define se um caractere pode ou não fazer parte do puzzle,(i.e) no puzzle que só contém espaços pretos 'P'
     * e espaços brancos que vão ser prenchidos pelos números, é preciso verificar se é um desses caracteres 'P' ou digito de 1-9
     * @param 'c' caractere a ser filtrado
     * @return true se o caractere for 'P' ou digito de 1-9
     */
    public static boolean isFillingChar(char c){
            return (c == 'P')||(c > '0' && c <= '9');
            // da pra comparar um char com um "número" pelo unicode do caractere do numero, entao da pra fazer
            // comparacao direta pela traducao direta do ascii do numero q e tipo 47 -> 0 ate 56 -> 9, sobe normal
    }
    /** Funcao Logica isValidPuzzleInConstruction verifica se spc é uma String valida para ser um puzzle modificavel e jogavel
     * @param String spc string a ser validada como puzzle
     * @return true se contém digitos de 1-9 e caracteres . e P
     * @requires spc != null
     */
    public static boolean isValidPuzzleInConstruction(String spc){
        if(spc == null){
            return false;
        }
        boolean temUmDigito = false;
        for(int i = 0; i < spc.length(); i++){
            if(hasDigit(spc, i) == true){
            temUmDigito = true;
            }
        }
        if(!temUmDigito){
            return false;
        }
        boolean temPonto = hasChar(spc, '.');
        boolean temP = hasChar(spc, 'P');
        return temP && temPonto;
    }
}


/**
 * ..Funçao isFilled
 * verifica se todas as funçoes de uma string estao preenchidas
 * se tiver '.' considera-se q a posiçao nao esta preenchida
 * @param spc String a analisar
 * @return booleano indicando se todas as posiçoes estao preenchidas
 * @requires spc != null
 * @ensures devolve true se nao tiver '.', false caso contrario
 */
public static boolean isFilled (String spc) {
    for(int i = 0; i < spc.length(); i++) {
        if(spc.charAt(1) == '.') {
            return false;
        }
    }
     return true;
}

/**
 * ..Funçao hasAdjacentPositionWithDifferentDigits..
 *  verificar se numa grelha com linhas e colunas representada pela string spc existem duas posiçoes adjacentes ( ao lado ou em baixo) com digitos diferentes
 * @param rows numero de linhas
 * @param cols numero de colunas
 * @param spc string com tamanho de rows x cols que representa a grelha
 * @return true se existirem posiçoes adjacentes com digitos diferentes ou false caso contrario
 * @requires row > 0 && spc != null && spc.length() == rows*cols
 */
public static boolean hasAdjacentPositionWithDifferentDigits(int rows, int cols, String spc) {
    for(int r= 0; r < rows; r++) {
        for(int c = 0; c < cols; c++){
            int pos = r * cols + c; // cada linha tem um nº de colunas, cols, entao andamos r*cols, tipo estamos na linha 1 que tem 4 colunas ( 1*4, quer vai andar 4 casas para a direita e vai parar na linha abaixo) e depois +c, que é a coluna onde estamos
            //comparar com a posiçao à direita
            if(c < cols - 1) {
                if (spc.charAt(pos) != spc.charAt(pos + 1)) {
                    return true;
                }
            }
            //comparar com a posiçao abaixo
            if (r < rows -1) {
                if(spc.charAt(pos) != spc.charAt(pos + cols)) {
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
 * @param rows numero de linhas
 * @param cols numero de colunas
 * @param spc string de tamanho rows*cols que representa o puzzle
 * @requires rows > 0 && cols > 0 && spc!= null && spc.length()== rows*cols
 * @ensures imprime spc na forma de grelha
 */
public static void printPuzzleInConstruction(int rows, int cols, String spc) {
    for(int r = 0; r < rows; r++){
        for(int c = 0; c < cols; c++){
            int pos= r * cols + c; // cada linha tem um nº de colunas, cols, entao andamos r*cols,
            //tipo estamos na linha 1 que tem 4 colunas ( 1*4, quer vai andar 4 casas para a direita e vai parar na linha abaixo)
            //e depois +c, que é a coluna onde estamos
            System.out.print(spc.charAt(pos)+" ");
        }
        System.out.println();
    }
}





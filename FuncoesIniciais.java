/*Antonio___
 * Esse Arquivo não é o do trabalho em si, é um uma "area de trabalho" pra podermos fazermos as funcoes, testar etc e depois copiar
 * e aplicar no trabalho principal com o nome apropriado do enunciado "LogicIPuzzle" que vai ser o nome do arquivo de entrega em si
 * se sinta livre pra alterar qualquer coisa no meu código adicionar comentários etc, eu vou tentar utilizar o nome das varáveis e metódos
 * ja postos no enunciado porque desta forma ja fica tudo arrumado e nos usamos as mesmas variaveis etc
 * 
 * caracteres de loop ja utilizados: r,k
 * 
 */





import java.util.Scanner;

public class FuncoesIniciais{

    /* Funcao rowOfPosition vai ser utilizada para, apartir de uma posição, encontrar a sua dada linha no puzzle,
     * @param 'pos' posição exata do ponto escolhido
     * @param 'numColumns' número de colunas do puzzle feito
     * @return o número da linha em que está a posição
     * @requires pos >= 0 (não negativo pode ser zero) && numColumns > 0 (só positivos) 
     */
    public static int rowOfPosition(int pos, int numColumns){
        return ((pos/numColumns)+1);
    }
    /* Funcao columnOfPosition vai ser utilizada para, apartir de uma posição, encontrar a sua dada coluna no puzzle
     * @param 'pos' posição exata do ponto escolhido
     * @param 'numColumns' número de colunas do puzzle feito
     * @return o número da linha em que está a posição
     * @requires pos >= 0 && numColumns > 0
     */
    public static int columnOfPosition(int pos, int numColumns){
        return ((pos%numColumns)+1);
    }
<<<<<<< Updated upstream

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
    if(row<=o || column<= o || numColumns<=0){
        System.out.println("valor invalido");
    }
    return (row * numColumns) * column;
}
    
=======
     // -------- Função: positionNumber --------
    // Serve para calcular a posição na grelha a partir da linha e coluna
    // Assume que row, column e numColumns são positivos
    public static int positionNumber(int row, int column, int numColumns) {
        if (row <= 0 || column <= 0 || numColumns <= 0) {
            System.out.println("Valor inválido");
        }

        // Fórmula que converte (linha, coluna) em número de posição
        return (row - 1) * numColumns + (column - 1);
    }
>>>>>>> Stashed changes
    /* Funcao Lógica de checagem de fator, para que existam retangulos definidos, é preciso checar diversas formas de formar um retangulo (i.e)
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
<<<<<<< Updated upstream
    
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
=======
       // -------- Função: getIntFactor --------
    // a função vai receber dois números inteiros positivos: 'number' e 'factor'
    // Ela vai devolver o número inteiro que multiplicado por 'factor', dá exatamente 'number'.
    // Exemplo: se number = 12 e factor = 3 → retorna 4 (porque 3 × 4 = 12)
public static int getIntFactor(int number, int factor) {

    // Verifico se os valores são válidos (positivos)
    if (number <= 0 || factor <= 0) {
        System.out.println("Os valores devem ser positivos.");
    }

    // Verifico se 'factor' é realmente um fator inteiro de 'number' isto é se number % factor == 0 
    if (number % factor != 0) {
        System.out.println("O valor de 'factor' não é um fator inteiro de 'number'.");
    }

    // Se passou agr calculamos o valor
    // O número que multiplicado por 'factor' dá 'number' é: number / factor
    int resultado = number / factor;

    // Devolver o resultado
>>>>>>> Stashed changes
    return resultado;
}
    /* Funcao sumDigits calcula a soma de todos os números dentro d euma string e ignora os seus caracteres, que nao representam numeros por causa de metodos
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
<<<<<<< Updated upstream

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
        if(charAt(i)= c){
            count ++;
        }
    }
    return count;
}
    
=======
          // -------- Função: countCharOccurrence --------
    // Recebe uma String 's' (não null) e um carácter 'c'
    // Devolve quantas vezes o carácter 'c' aparece na String
    public static int countCharOccurrence(String s, char c) {
        int count = 0; // contador de ocorrências

        // Percorre todos os caracteres da String
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) { // se o carácter atual for igual a 'c'
                count++; // adiciona ao contador
            }
        }

        return count; // devolve o total do do contador
    }
>>>>>>> Stashed changes
    /* Funcao countDigitOccurrence conta o número de vezes que um digito aparece na String, isso é útil no caso dos numeros de 1-9
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
<<<<<<< Updated upstream

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

public static boolean hasdigit(String s, int d){
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
=======
    // -------- Função: hasDigit --------
    // Recebe uma String 's' (não null) e um dígito inteiro 'd' (0-9)
    // Devolve true se o dígito aparecer em 's', false caso contrário
    public static boolean hasDigit(String s, int d) {
        // Converto agr o dígito inteiro para carácter
        char digitChar = (char) (d + '0'); // ex: 3 -> '3'

        // Percorre todos os caracteres da string
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == digitChar) { // se encontrar o dígito
                return true; // encontrou ent vai devolver true
            }
        }

        return false; // n encontrou ent devolve false
    }
    /* Funcao de Suporte hasChar faz o mesmo que hasDigit mas para caracteres especificos, feito para facilitar IsValidPuzzleInConstruction
     * @param String s a ser percorrida
     * @param char c caractere especifico que se quer saber se existe na string
     * @return true se c aparecer em s
    */
    public static boolean hasChar(String s, char c){
        for(int m = 0; m<s.length();m++){
            if(c == s.charAt(m)){
                return true;
            }
        }
        return false;
    }
>>>>>>> Stashed changes
    /* Funcao logica isFillingChar que define se um caractere pode ou não fazer parte do puzzle,(i.e) no puzzle que só contém espaços pretos 'P'
     * e espaços brancos que vão ser prenchidos pelos números, é preciso verificar se é um desses caracteres 'P' ou digito de 1-9
     * @param 'c' caractere a ser filtrado
     * @return true se o caractere for 'P' ou digito de 1-9
     */
<<<<<<< Updated upstream
=======
    
>>>>>>> Stashed changes
    public static boolean isFillingChar(char c){
            return (c == 'P')||(c > '0' && c <= '9');
            // da pra comparar um char com um "número" pelo unicode do caractere do numero, entao da pra fazer
            // comparacao direta pela traducao direta do ascii do numero q e tipo 47 -> 0 ate 56 -> 9, sobe normal
    }
    /* Funcao Logica isValidPuzzleInConstruction verifica se spc é uma String valida para ser um puzzle modificavel e jogavel
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
        if(temUmDigito == false){
            return false;
        }
        boolean temPonto = hasChar(spc, '.');
        boolean temP = hasChar(spc, 'P');
        return temP && temPonto;
    }

    public static void main(String[] args) {
        String spc = "....PPPP44.4422";
        System.out.println(isValidPuzzleInConstruction(spc));
    }
}

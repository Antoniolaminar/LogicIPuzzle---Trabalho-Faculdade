/*Antonio___
 * Esse Arquivo não é o do trabalho em si, é um uma "area de trabalho" pra podermos fazermos as funcoes, testar etc e depois copiar
 * e aplicar no trabalho principal com o nome apropriado do enunciado "LogicIPuzzle" que vai ser o nome do arquivo de entrega em si
 * se sinta livre pra alterar qualquer coisa no meu código adicionar comentários etc, eu vou tentar utilizar o nome das varáveis e metódos
 * ja postos no enunciado porque desta forma ja fica tudo arrumado e nos usamos as mesmas variaveis etc
 * 
 * caracteres de loop ja utilizados: i
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
    /* Funcao sumDigits calcula a soma de todos os números dentro d euma string e ignora os seus caracteres, que nao representam numeros por causa de metodos
     * da classe character
     * @param 's' String com caracteres e numeros
     * @return 'sumString' a soma dos numeros dentro dessa string
     * @requires s != null; a String nao pode ser null
     */
    public static int sumDigits(String s){
        int sumString = 0;
            for(int i = 0; i <= s.length();i++){
                char c = s.charAt(i);
                // aqui foi meio estranho tentar fazer com o parseint mas depois de olhar a doc da classe character eu encontrei
                // esses dois metodos que podem ser bem uteis mais pra frente 'IsDigit' e 'getNumericValue'
                if (Character.isDigit(c)){
                    sumString += Character.getNumericValue(c);
                }
            }
            return sumString; 
    }
    /*
     * 
     * 
     * 
     * 
     * 
     * 
     */
    public static int countDigitOccurrence(String s, int d){
        char d
        
        return 0;
    }


}
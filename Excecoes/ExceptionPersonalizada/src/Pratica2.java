import javax.swing.*;
import java.io.FileNotFoundException;

public class Pratica2 {
    public static void main(String[] args) {
        int[] numerador = {4, 5, 8, 10};
        int[] denominador = {2, 4, 0, 2, 8};

        for (int i = 0; i < denominador.length; i++){

            try{
                if(i >= numerador.length || i >= denominador.length)
                    throw new DivisaoSemUmTermo("Numerador esta vazio!");
                else if(numerador[i] %2 != 0) {
                    throw new DivisaoNaoExataException("Divisão não exata!", numerador[i], denominador[i]);
                }
                else if(denominador[i] == 0) {
                    throw new DivisaoPorZero("Você esta tentando dividir por 0, Não é possivel!", numerador[i], denominador[i]);
                }
                int resultado = numerador[i] / denominador[i];
                System.out.println(resultado);
            } catch (DivisaoNaoExataException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            } catch (DivisaoPorZero e){
                JOptionPane.showMessageDialog(null, e.getMessage());
            } catch (DivisaoSemUmTermo e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
                break;
            }
        }

        //JEITO QUE PENSEI PARA RESOVLER
        for (int i = 0; i < denominador.length; i++){
            try{
                if(i >= numerador.length || i >= denominador.length)
                    throw new DivisaoExcecoes("Numerador esta vazio!");
                else if(numerador[i] %2 != 0) {
                    throw new DivisaoExcecoes("Divisão não exata!", numerador[i], denominador[i]);
                }
                else if(denominador[i] == 0) {
                    throw new DivisaoExcecoes("Você esta tentando dividir por 0, Não é possivel!", numerador[i], denominador[i]);
                }
                int resultado = numerador[i] / denominador[i];
                System.out.println(resultado);
            } catch (DivisaoExcecoes e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
        System.out.println("o programa continua...");
    }
}

class DivisaoNaoExataException extends Exception {
    private int numerado;
    private int denominador;

    public DivisaoNaoExataException(String message, int numerado, int denominador) {
        super(message);
        this.numerado = numerado;
        this.denominador = denominador;
    }
}


//RESOLVENDO DESAFIO DO CURSO
class DivisaoPorZero extends Exception {
    private int numerado;
    private int denominador;

    public DivisaoPorZero(String message, int numerado, int denominador) {
        super(message);
        this.numerado = numerado;
        this.denominador = denominador;
    }
}

//Desafio

class DivisaoSemUmTermo extends Exception {

    public DivisaoSemUmTermo(String message) {
        super(message);
    }
}

//JEITO QUE PENSEI PARA RESOLVER
class DivisaoExcecoes extends Exception {
    private int numerador;
    private int denominador;

    public DivisaoExcecoes(String message, int numerador, int denominador) {
        super(message);
        this.numerador = numerador;
        this.denominador = denominador;
    }

    public DivisaoExcecoes(String message) {
        super(message);
    }
}

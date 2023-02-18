import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        boolean continueLooping = true;
        do {

            String a = JOptionPane.showInputDialog("Numerador: ");
            String b = JOptionPane.showInputDialog("Denominador: ");

            try{
                double resultado = dividir(Double.parseDouble(a), Double.parseDouble(b));
                System.out.println("Resultado: " + resultado);
                continueLooping = false;
            } catch (NumberFormatException e) {
                JOptionPane.showInputDialog(null, "Entrada Invalida, Informe um numero inteiro!");
            }catch (ArithmeticException e){
                JOptionPane.showInputDialog(null, "Não é possivel dividir um numero por 0!");
            }finally {
                System.out.println("Chegou no finally!");
            }

            System.out.println("O código continua...");
        }while (continueLooping);

    }

    public static  double dividir(double a, double b){
        return a / b;
    }
}
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var isRunning = True;

        while(isRunning){
            System.out.println("- - - - - - - - - - - M E N U - - - - - - - - - - -");
            System.out.println("1 - consultar saldo");
            System.out.println("2 - consultar cheque especial");
            System.out.println("3 - depositar dinheiro");
            System.out.println("4 - sacar dinheiro");
            System.out.println("5 - pagar boleto");
            System.out.println("6 - verificar status do cheque especial");
            System.out.println("7 - sair");
            System.out.print("digite numero da operacao que deseja realizar:  ");
            var option = scanner.nextInt();
            switch (option){
                case 1 ->
                case 2 ->
                case 3 ->
                case 4 ->
                case 5 ->
                case 6 ->
                case 7 -> isRunning = False;
            }
        }
    }
}
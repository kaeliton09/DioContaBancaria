import java.util.Scanner;
import Exception.ValoresExceptions;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        boolean isRunning = true;
        System.out.print("quanto deseja depositar na sua conta? ");
        var depositoInicial = scanner.nextFloat();//tratar execao de valor
        var contaBancaria = new ContaBancaria(depositoInicial);
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
                case 1 -> {
                    var saldo = contaBancaria.getSaldo();
                    System.out.printf("seu saldo e de: %.2fR$\n", saldo);
                }
                case 2 -> {
                    var chequeEspecial = contaBancaria.getChequeEspecial();
                    System.out.printf("seu cheque especial e de: %.2fR$\n", chequeEspecial);
                }
                case 3 -> {
                    System.out.print("digite o valor que deseja depositar: ");
                    var valor = scanner.nextFloat();
                    try{
                        contaBancaria.depositar(valor);
                        System.out.println("deposito realizado com sucesso");
                    } catch (ValoresExceptions ex){
                        System.out.println(ex.getMessage());
                    }
                }
                case 4 -> {
                    System.out.print("digite o valor que sacar: ");
                    var valor = scanner.nextFloat();
                    try{
                        contaBancaria.sacar(valor);
                        System.out.println("saque realizado com sucesso");
                    } catch (ValoresExceptions ex){
                        System.out.println(ex.getMessage());
                    }
                }
                case 5 -> {
                    System.out.print("digite o valor do boleto que deseja pagar: ");
                    var valor = scanner.nextFloat();
                    try{
                        contaBancaria.pagarBoleto(valor);
                        System.out.println("boleto pago com sucesso");
                    } catch (ValoresExceptions ex){
                        System.out.println(ex.getMessage());
                    }
                }
                case 6 -> {
                    var statusCheque = "";
                    if(contaBancaria.isStatusChequeEspecial()){
                        statusCheque = "esta usando";
                    } else statusCheque = "nao esta usando";
                    System.out.printf("voce %s seu cheque especial", statusCheque);
                }
                case 7 -> isRunning = false;
            }
            System.out.println("- - - - - - - - - - - - - - - - - - - - - - -");
        }
    }
}
import java.util.Scanner;
import Exception.ValoresExceptions;
import model.ContaBancaria;

import static validador.ValidadorValores.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean isRunning = true;
        System.out.print("digite o valor que deseja depositar: ");
        var depositoInicial = scanner.nextFloat();
        try{
            validadorDeposito(depositoInicial);
        } catch(ValoresExceptions ex){
            float valor;
            do {
                System.out.println(ex.getMessage());
                System.out.print("digite o valor que deseja depositar: ");
                valor = scanner.nextFloat();
            } while(valor <= 0 );
            depositoInicial = valor;
        }
        var contaBancaria = new ContaBancaria(depositoInicial);
        System.out.println("deposito realizado com sucesso");
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
                        validadorDeposito(valor);
                    } catch(ValoresExceptions ex){
                        do {
                            System.out.println(ex.getMessage());
                            System.out.print("digite o valor que deseja depositar: ");
                            valor = scanner.nextFloat();
                        } while(valor <= 0 );
                    }
                    contaBancaria.depositar(valor);
                    System.out.println("deposito realizado com sucesso");
                }
                case 4 -> {
                    System.out.print("digite o valor que sacar: ");
                    var valor = scanner.nextFloat();
                    try{
                        validadorSaque(valor, contaBancaria);
                    } catch (ValoresExceptions ex){
                        do {
                            System.out.println(ex.getMessage());
                            System.out.print("digite o valor que sacar: ");
                            valor = scanner.nextFloat();
                        } while(valor <= 0 || valor > contaBancaria.getSaldo());
                    }
                    contaBancaria.sacar(valor);
                    System.out.println("saque realizado com sucesso");
                }
                case 5 -> {
                    System.out.print("digite o valor do boleto que deseja pagar: ");
                    var valor = scanner.nextFloat();
                    try{
                        validadorBoleto(valor, contaBancaria);
                    } catch (ValoresExceptions ex){
                        do {
                            System.out.println(ex.getMessage());
                            System.out.print("digite o valor que sacar: ");
                            valor = scanner.nextFloat();
                        } while(valor <= 0 || valor > contaBancaria.getSaldo());
                    }
                    contaBancaria.pagarBoleto(valor);
                    System.out.println("boleto pago com sucesso");
                }
                case 6 -> {
                    var statusCheque = "";
                    if(contaBancaria.isStatusChequeEspecial()){
                        statusCheque = "esta usando";
                    } else statusCheque = "nao esta usando";
                    System.out.printf("voce %s seu cheque especial\n", statusCheque);
                }
                case 7 -> isRunning = false;
            }
            System.out.println("- - - - - - - - - - - - - - - - - - - - - - -");
        }
    }
}
package validador;

import Exception.ValoresExceptions;
import model.ContaBancaria;


public class ValidadorValores {

    private ValidadorValores(){

    }

    public static void validadorDeposito(float valor) throws ValoresExceptions{
        if(valor == 0) throw new ValoresExceptions("o valor para deposito nao pode ser Zero");
        if(valor < 0) throw new ValoresExceptions("o valor para deposito nao pode ser negativo");
    }

    public static void validadorSaque(float valor, ContaBancaria conta) throws ValoresExceptions{
        if(valor > conta.getSaldo()) throw new ValoresExceptions("o valor de saque nao pode ser maior que o saldo da conta");
        if(valor <= 0) throw new ValoresExceptions("o valor de saque nao pode ser negativo");
    }

    public static void validadorBoleto(float valor, ContaBancaria conta) throws ValoresExceptions{
        if(valor > conta.getSaldo()) throw new ValoresExceptions("o valor do boleto nao pode ser maior que o saldo da conta");
        if(valor <= 0) throw new ValoresExceptions("o valor do boleto nao pode ser negativo");
    }
}

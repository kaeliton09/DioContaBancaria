package model;

public class ContaBancaria {
    //atributos
    private float saldo;
    private float chequeEspecial;
    private boolean statusChequeEspecial; //usado na verificacao do uso do cheque especial

    public ContaBancaria(float saldo) {
        this.saldo = saldo;
        if(this.saldo <= 500) this.chequeEspecial = 50;
        else this.chequeEspecial = (float) (this.saldo * 0.5);// cheque especial sera 50% do saldo
    }

    public void sacar(Float valor) {
        this.saldo -= valor;
    }

    public void depositar(Float valor){
        this.saldo += valor;
    }

    public float consultarChequeEspecial(){
        return getChequeEspecial();
    }

    public float consultarSaldo(){
        return getSaldo();
    }

    public boolean verificarChequeEspecial(){
        return isStatusChequeEspecial();
    }

    public void pagarBoleto(float valor){
        this.saldo -= valor;
    }

    public float getSaldo() {
        return saldo;
    }
    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }
    public float getChequeEspecial() {
        return chequeEspecial;
    }
    public void setChequeEspecial(float chequeEspecial) {
        this.chequeEspecial = chequeEspecial;
    }
    public boolean isStatusChequeEspecial() {
        return statusChequeEspecial;
    }
    public void setStatusChequeEspecial(boolean statusChequeEspecial) {
        this.statusChequeEspecial = statusChequeEspecial;
    }
}

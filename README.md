# 💰 Sistema de Conta Bancária em Java

Este projeto é uma simulação de uma **conta bancária** com funcionalidades básicas de operação financeira, criado como exercício prático para reforçar os conceitos de **tratamento de exceções** e **orientação a objetos em Java**.

---

## 📋 Funcionalidades

A aplicação possui um menu interativo no console que permite:

- Consultar saldo
- Consultar limite do cheque especial
- Depositar dinheiro
- Sacar dinheiro
- Pagar boletos
- Verificar se está utilizando o cheque especial

---

## ✅ Regras do sistema

Ao criar a conta, o valor do **cheque especial** é calculado com base no **valor depositado inicialmente**:

- Se o valor for **R$500,00 ou menos**, o limite do cheque especial será de **R$50,00**
- Se o valor for **superior a R$500,00**, o limite será de **50% do valor depositado**

O saldo disponível considera o valor do cheque especial.

---

## 💻 Execução

A aplicação é baseada em **interface de texto** no terminal, onde o usuário interage com o menu e insere valores manualmente. O sistema valida todas as entradas com tratamento de exceções:

- Não permite valores negativos
- Verifica se há saldo suficiente (incluindo cheque especial)
- Fornece mensagens claras em caso de erro

---

## 🧠 Conceitos aplicados

- **POO (Programação Orientada a Objetos)**
  - Encapsulamento
  - Métodos de instância
  - Construtores
- **Tratamento de exceções**
  - `try/catch`
  - Exceções personalizadas
- **Validação de entrada do usuário**
- **Organização em pacotes (packages)**



package com.poo.aula_exceptions;

import java.util.Scanner;

public class Exercicios {
    public static void ex1(){
        Scanner sc = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            
            System.out.println("Digite o primeiro número (dividendo): ");
            double dividendo = sc.nextDouble();
            
            System.out.println("Digite o segundo número (divisor): ");
            double divisor = sc.nextDouble();
            
            try {
                double resultado = dividir(dividendo, divisor);
                System.out.println("O resultado da divisão é: " + resultado);
            } catch (ArithmeticException e) {
                System.out.println("Erro: Divisão por zero não é permitida.");
            }

            sc.nextLine(); // Limpar o buffer do scanner

            System.out.println("Deseja realizar outra operação? (s/n): ");
            String resposta = sc.nextLine().toLowerCase();

            if (!resposta.equals("s")) {
                continuar = false;
            }
        }

        sc.close();
    }

    public static double dividir(double dividendo, double divisor) {
        if (divisor == 0) {
            throw new ArithmeticException("Divisão por zero");
        }
        return dividendo / divisor;
    }
}

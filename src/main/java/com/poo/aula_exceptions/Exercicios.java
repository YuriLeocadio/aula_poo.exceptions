package com.poo.aula_exceptions;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercicios {
    public static void ex1() {
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

    public static void ex2() {
        Scanner sc = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            exibirMenu();
            int opcao = lerOpcao(sc);

            switch (opcao) {
                case 1:
                    System.out.println("Vasco da Gama\n");
                    break;
                case 2:
                    System.out.println("Flamengo\n");
                    break;
                case 3:
                    continuar = false;
                    System.out.println("Encerrando o programa.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.\n");
                    break;
            }
        }

        sc.close();
    }

    public static void exibirMenu() {
        System.out.println("Menu:");
        System.out.println("1 - Piada");
        System.out.println("2 - Melhor time do Brasil");
        System.out.println("3 - Sair");
        System.out.print("Escolha uma opção: ");
    }

    public static int lerOpcao(Scanner sc) {
        int opcao = 0;
        boolean entradaInvalida = true;

        while (entradaInvalida) {
            try {
                opcao = sc.nextInt();
                entradaInvalida = false;
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, insira um número inteiro.\n");
                sc.next(); // Limpar a entrada invalida
                exibirMenu();
            }
        }

        return opcao;
    }

    public static double dividir(double dividendo, double divisor) {
        if (divisor == 0) {
            throw new ArithmeticException("Divisão por zero");
        }
        return dividendo / divisor;
    }
}

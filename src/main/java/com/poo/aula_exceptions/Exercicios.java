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

    public static void ex3() {
        Scanner sc = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            exibirMenuEx3();
            int opcao = lerOpcao(sc);

            switch (opcao) {
                case 1:
                    listarNomes();
                    escolherNome(sc);
                    break;
                case 2:
                    System.out.println("Pior time do Brasil\n");
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

    public static void exibirMenuEx3() {
        System.out.println("Menu Exercício 3:");
        System.out.println("1 - Listar nomes");
        System.out.println("2 - Pior time do Brasil");
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
                sc.next(); // Limpar a entrada inválida
                exibirMenu();
            }
        }

        return opcao;
    }

    public static void listarNomes() {
        System.out.println("Lista de nomes:");
        System.out.println("1 - Lucas");
        System.out.println("2 - Enzo");
        System.out.println("3 - Eloisa");
    }

    public static void escolherNome(Scanner sc) {
        boolean entradaInvalida = true;
        while (entradaInvalida) {
            try {
                System.out.print("Escolha o índice do nome desejado: ");
                int indice = sc.nextInt();

                switch (indice) {
                    case 1:
                        System.out.println("Você escolheu o nome Lucas.\n");
                        entradaInvalida = false;
                        break;
                    case 2:
                        System.out.println("Você escolheu o nome Enzo.\n");
                        entradaInvalida = false;
                        break;
                    case 3:
                        System.out.println("Você escolheu o nome Eloisa.\n");
                        entradaInvalida = false;
                        break;
                    default:
                        System.out.println("Índice inválido. Escolha um índice entre 1 e 3.\n");
                        listarNomes();
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, insira um número inteiro.\n");
                sc.next(); // Limpar a entrada inválida
                listarNomes();
            }
        }
    }

    public static double dividir(double dividendo, double divisor) {
        if (divisor == 0) {
            throw new ArithmeticException("Divisão por zero");
        }
        return dividendo / divisor;
    }
}
package com.poo.aula_exceptions;

import com.poo.aula_exceptions.exceptions.DivisaoPorZeroException;
import com.poo.aula_exceptions.exceptions.IndiceInvalidoException;
import com.poo.aula_exceptions.exceptions.OpcaoInvalidaException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercicios {
    public static void ex1() {
        Scanner sc = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            try {
                System.out.println("Digite o primeiro número (dividendo): ");
                double dividendo = lerDouble(sc);

                System.out.println("Digite o segundo número (divisor): ");
                double divisor = lerDouble(sc);

                double resultado = dividir(dividendo, divisor);
                System.out.println("O resultado da divisão é: " + resultado);
            } catch (DivisaoPorZeroException | OpcaoInvalidaException e) {
                System.out.println(e.getMessage());
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

    public static double dividir(double dividendo, double divisor) throws DivisaoPorZeroException {
        if (divisor == 0) {
            throw new DivisaoPorZeroException();
        }
        return dividendo / divisor;
    }

    public static double lerDouble(Scanner sc) throws OpcaoInvalidaException {
        try {
            return sc.nextDouble();
        } catch (InputMismatchException e) {
            sc.next(); // Limpar a entrada inválida
            throw new OpcaoInvalidaException();
        }
    }

    public static void ex2() {
        Scanner sc = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            exibirMenu();
            try {
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
            } catch (OpcaoInvalidaException e) {
                System.out.println(e.getMessage());
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

    public static int lerOpcao(Scanner sc) throws OpcaoInvalidaException {
        try {
            return sc.nextInt();
        } catch (InputMismatchException e) {
            sc.next(); // Limpar a entrada inválida
            throw new OpcaoInvalidaException();
        }
    }

    public static void ex3() {
        Scanner sc = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            exibirMenuEx3();
            try {
                int opcao = lerOpcao(sc);
                switch (opcao) {
                    case 1:
                        listarNomes(sc);
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
            } catch (OpcaoInvalidaException e) {
                System.out.println(e.getMessage());
            }
        }

        sc.close();
    }

    public static void exibirMenuEx3() {
        System.out.println("Menu Exercício 3:");
        System.out.println("1 - Listar nomes");
        System.out.println("2 - Pior time do Brasil");
        System.out.println("3 - Sair");
        System.out.print("Escolha uma opção: ");
    }

    public static void listarNomes(Scanner sc) {
        String[] nomes = {"Lucas", "Enzo", "Eloisa"};
        System.out.println("Lista de nomes:");
        for (int i = 0; i < nomes.length; i++) {
            System.out.println((i + 1) + " - " + nomes[i]);
        }

        System.out.print("Escolha o índice do nome desejado: ");
        try {
            int indice = lerIndice(sc, nomes.length);
            System.out.println("Você escolheu: " + nomes[indice - 1]);
        } catch (OpcaoInvalidaException | IndiceInvalidoException e) {
            System.out.println(e.getMessage());
        }
    }

    public static int lerIndice(Scanner sc, int tamanhoLista) throws OpcaoInvalidaException, IndiceInvalidoException {
        try {
            int indice = sc.nextInt();
            if (indice < 1 || indice > tamanhoLista) {
                throw new IndiceInvalidoException();
            }
            return indice;
        } catch (InputMismatchException e) {
            sc.next(); // Limpar a entrada inválida
            throw new OpcaoInvalidaException();
        }
    }
}

package com.poo.aula_exceptions;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.InputMismatchException;
import java.util.Scanner;

@SpringBootApplication
public class AulaExceptionsApplication {

    public static void main(String[] args) {
        SpringApplication.run(AulaExceptionsApplication.class, args);
        limpa();

        Scanner sc = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            exibirMenuPrincipal();
            int opcao = lerOpcao(sc);

            switch (opcao) {
                case 1:
                    Exercicios.ex1();
                    break;
                case 2:
                    Exercicios.ex2();
                    break;
                case 3:
                    Exercicios.ex3();
                    break;
                case 4:
                    continuar = false;
                    System.out.println("Encerrando o programa.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }

        sc.close();
    }

    static void exibirMenuPrincipal() {
        System.out.println("Menu Principal:");
        System.out.println("1 - Executar Exercício 1");
        System.out.println("2 - Executar Exercício 2");
        System.out.println("3 - Executar Exercício 3");
        System.out.println("4 - Sair");
        System.out.print("Escolha uma opção: ");
    }

    static int lerOpcao(Scanner sc) {
        int opcao = 0;
        boolean entradaInvalida = true;

        while (entradaInvalida) {
            try {
                opcao = sc.nextInt();
                entradaInvalida = false;
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, insira um número inteiro.");
                sc.next(); // Limpar a entrada inválida
                exibirMenuPrincipal();
            }
        }

        return opcao;
    }

    static void limpa() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else if (System.getProperty("os.name").contains("Linux")
                    || System.getProperty("os.name").contains("Mac")) {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            } else {
                System.out.println("Este comando não funciona no seu sistema operacional.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

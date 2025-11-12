package org.example;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        String option;
        Scanner sc = new Scanner(System.in);
        Controller controller = new Controller();
        controller.iniciarJogo();

        do {
            System.out.println("Digite uma letra: ");
            String letra = sc.nextLine();
            controller.chutarLetra(letra);

            System.out.println(String.join(" ", controller.letrasAcertadas));
            System.out.println("Tentativas restantes: " + controller.tentativas);

            if (controller.verificarFimDoJogo()) {
                System.out.println("Fim do jogo!");
                if (controller.tentativas <= 0){
                    System.out.println("Game Over! Você perdeu.");
                }else{
                    System.out.println("Parabéns! Você acertou a palavra: "+controller.palavra);
                }
            }
        } while (!controller.verificarFimDoJogo());
    }
}
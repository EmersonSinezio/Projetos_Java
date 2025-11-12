
# 🎯 Jogo da Forca (Console)

[![Java 22](https://img.shields.io/badge/Java-22-informational?style=for-the-badge\&logo=openjdk)](https://openjdk.org/) [![Interface](https://img.shields.io/badge/Interface-Console-lightgrey?style=for-the-badge)]() [![Build](https://img.shields.io/badge/build-manual-blue?style=for-the-badge)]() [![License: MIT](https://img.shields.io/badge/License-MIT-green?style=for-the-badge)]()

Um pequeno projeto em **Java** que implementa o clássico **Jogo da Forca** jogável diretamente no **console**.
O programa escolhe uma palavra aleatória e o jogador deve adivinhar letra por letra antes que as tentativas acabem, esse projeto foi criado com o intuito de treinar a lógica de programação.

## 🧩 Demonstração rápida

* O jogo escolhe **automaticamente uma palavra aleatória**.
* O jogador tem **6 tentativas** para acertar a palavra completa.
* Cada letra correta é revelada nas posições correspondentes.
* Exibe o **progresso atual** e o número de **tentativas restantes**.
* Informa quando o jogador **vence** ou **perde** o jogo.

---

## ✨ Recursos / Destaques

* Lógica simples e totalmente em **Java puro**.
* Utiliza **array de Strings** para representar as letras acertadas.
* Gera a **palavra secreta aleatoriamente** a partir de uma lista.
* **Valida entradas** — só aceita letras únicas por tentativa.
* Exemplo didático para estudos de **controle de fluxo**, **arrays** e **métodos** em Java.

---

## 🧠 Tecnologias e Conceitos Aplicados

| Conceito               | Descrição                                                     |
| ---------------------- | ------------------------------------------------------------- |
| **Scanner**            | Leitura de entrada do usuário via console.                    |
| **Math.random()**      | Escolha aleatória da palavra secreta.                         |
| **Arrays**             | Armazenam letras acertadas e palavras disponíveis.            |
| **Controle de fluxo**  | Estruturas de repetição e condicionais para controle do jogo. |
| **Tratamento de erro** | Verifica se o usuário digitou apenas uma letra.               |

---

## 🧱 Estrutura do projeto

```
JogoForca/
├─ src/
│  └─ org/example/
│     ├─ Main.java
│     └─ Controller.java
└─ README.md
```

---

## 📂 Principais arquivos

### **Main.java**

```java
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
                } else {
                    System.out.println("Parabéns! Você acertou a palavra: " + controller.palavra);
                }
            }
        } while (!controller.verificarFimDoJogo());
    }
}
```

---

### **Controller.java**

```java
package org.example;

public class Controller {
    String palavra;
    int tentativas = 6;
    String[] letrasAcertadas;
    String[] palavras = {"java", "programacao", "desenvolvimento", "computador", "internet"};

    public void iniciarJogo() {
        palavra = palavras[(int) (Math.random() * palavras.length)];
        letrasAcertadas = new String[palavra.length()];
        for (int i = 0; i < letrasAcertadas.length; i++) {
            letrasAcertadas[i] = "_";
        }
    }

    public void chutarLetra(String letra) {
        if (letra.length() != 1) {
            throw new IllegalArgumentException("A letra deve conter apenas um caractere.");
        }

        if (palavra.contains(letra)) {
            for (int i = 0; i < palavra.length(); i++) {
                if (palavra.charAt(i) == letra.charAt(0)) {
                    letrasAcertadas[i] = letra;
                }
            }
        } else {
            tentativas--;
        }
    }

    public boolean verificarFimDoJogo() {
        if (tentativas <= 0) {
            return true;
        } else {
            return palavra.equals(String.join("", letrasAcertadas));
        }
    }
}
```

---

## 🕹️ Como jogar

1. Compile o projeto:

   ```bash
   javac -d out src/org/example/*.java
   ```

2. Execute o jogo:

   ```bash
   java -cp out org.example.Main
   ```

3. Siga as instruções no console:

   * Digite uma letra por vez.
   * Veja o progresso e as tentativas restantes.
   * Tente adivinhar toda a palavra antes de acabar as chances!

---

## 💡 Exemplo de execução

```
Digite uma letra:
a
_ a _ a
Tentativas restantes: 6

Digite uma letra:
o
_ a _ a
Tentativas restantes: 5

Digite uma letra:
v
v a v a
Parabéns! Você acertou a palavra: java
Fim do jogo!
```

---

## 🧱 Aprendizados

Este projeto é ideal para quem deseja praticar:

* Estruturas de repetição (`do-while`, `for`)
* Condições (`if-else`)
* Manipulação de `String` e `array`
* Geração aleatória de dados
* Entrada e saída de dados no console

---
package org.example;

public class Controller {
        String palavra;
        int tentativas = 6;
        String[] letrasAcertadas;
        String [] palavras = {"java", "programacao", "desenvolvimento", "computador", "internet"};

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
            if (tentativas <= 0){
                return true;
            }else{
                return tentativas <= 0 || palavra.equals(String.join("", letrasAcertadas));
            }
        }

}

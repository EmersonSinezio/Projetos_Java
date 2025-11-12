package com.example.geradorsenhas;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Slider;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.text.Text;

import java.security.SecureRandom;

public class Controller {
    @FXML
    private Text resultadoText;
    @FXML
    private Slider slider;
    @FXML
    private Text sliderRes;
    @FXML
    private CheckBox minusculas;
    @FXML
    private CheckBox maiusculas;
    @FXML
    private CheckBox numeros;
    @FXML
    private CheckBox especiais;

    private final SecureRandom random = new SecureRandom();
    @FXML
    protected void gerarSenha() {
        // 🔹 Monta o conjunto de caracteres com base nas opções selecionadas
        StringBuilder conjunto = new StringBuilder();

        if (minusculas.isSelected()) conjunto.append("abcdefghijklmnopqrstuvwxyz");
        if (maiusculas.isSelected()) conjunto.append("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
        if (numeros.isSelected()) conjunto.append("0123456789");
        if (especiais.isSelected()) conjunto.append("!@#$%^&*()_+");

        // Se nada estiver selecionado, evita erro
        if (conjunto.isEmpty()) {
            resultadoText.setText("Selecione ao menos uma opção!");
            return;
        }

        // 🔹 Obtém o tamanho da senha a partir do slider
        int tamanho = (int) slider.getValue();
        sliderRes.setText(String.valueOf(tamanho));

        // 🔹 Gera nova senha aleatória a cada clique
        StringBuilder senhaGerada = new StringBuilder();

        for (int i = 0; i < tamanho; i++) {
            int index = random.nextInt(conjunto.length());
            senhaGerada.append(conjunto.charAt(index));
        }

        // Exibe o resultado final
        resultadoText.setText(senhaGerada.toString());
    }

    @FXML
    protected void copiarSenha() {
        String texto = resultadoText.getText();

        if (texto == null || texto.isEmpty()) {
            System.out.println("Nada para copiar!");
            return;
        }

        // Cria o conteúdo do clipboard
        ClipboardContent content = new ClipboardContent();
        content.putString(texto);

        // Coloca no clipboard do sistema
        Clipboard.getSystemClipboard().setContent(content);

        System.out.println("Copiado: " + texto);
    }

    @FXML
    protected void initialize() {
        slider.valueProperty().addListener((obs, oldVal, newVal) -> sliderRes.setText(String.valueOf(newVal.intValue())));
    }
}

package com.example.calculadoraimc;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML private Label situacao;
    @FXML private Label resultadoIMC;
    @FXML private TextField altura;
    @FXML private TextField peso;

    @FXML
    public void calcularImc(){
        String textoAltura = altura.getText();
        String textoPeso = peso.getText();

        // Substituindo , por .
        textoAltura = textoAltura.replace(",", ".");
        textoPeso = textoPeso.replace(",", ".");

        try{

        // Calculo do imc
        double pes = Double.parseDouble(textoPeso);
        double alt = Double.parseDouble(textoAltura);

        double res = pes / (alt * alt);
        String result = String.format("%.2f",res);
        this.resultadoIMC.setText(result);

        // Validação de peso
        if (res < 18.5){
            situacao.setText("Abaixo do peso!");
        } else if (res > 18.5 && res < 25) {
            situacao.setText("Peso normal");
        }else if (res > 25 && res < 30) {
            situacao.setText("Acima do peso");
        }else{
            situacao.setText("Obesidade!");
        }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

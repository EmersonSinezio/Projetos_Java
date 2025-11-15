package org.example.clima;

import io.github.cdimascio.dotenv.Dotenv;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.example.clima.Api.ApiClient;
import org.json.JSONObject;


class Env {
    private static final Dotenv dotenv = Dotenv.load();
    public static String get(String key) {
        return dotenv.get(key);
    }
}

public class HelloController {
    private final String API_KEY = Env.get("API_KEY");

    @FXML
    private Label resCidade;

    @FXML
    private Label resTemp;

    @FXML
    private Label resCond;

    @FXML
    private TextField searchName;

    @FXML
    private ImageView img;

    @FXML
    protected void searchButton(){
        String cidade = searchName.getText().trim();
        if (cidade.isEmpty()){
            resCidade.setText("Digite uma cidade");
            return;
        }
        new Thread(()->{
            try{
                String url = "https://api.weatherapi.com/v1/current.json?key="
                        + API_KEY + "&q=" + cidade + "&lang=pt";
                String jsonStr = ApiClient.get(url);
                JSONObject json = new JSONObject(jsonStr);

                System.out.println(json);

                //Dados retornados do json
                String nomeCidade = json.getJSONObject("location").getString("name");
                String temp = json.getJSONObject("current").get("temp_c").toString();
                String condicao = json.getJSONObject("current")
                        .getJSONObject("condition")
                        .getString("text");
                String regiao = json.getJSONObject("location").getString("region");
                String icon = json.getJSONObject("current").getJSONObject("condition").getString("icon");

                Platform.runLater(() -> {
                    resCidade.setText("Cidade: "+nomeCidade + " - " + regiao);
                    resCond.setText("Condição: "+condicao);
                    resTemp.setText("Temperatura: "+temp);

                    String iconUrl = "Https:"+icon;
                    img.setImage(new Image(iconUrl));
                });
            } catch (Exception e) {
                Platform.runLater(() -> resCidade.setText("Erro ao buscar dados."));
                e.printStackTrace();
            }
        }).start();
    }
}

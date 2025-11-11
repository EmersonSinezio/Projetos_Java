package com.example.relogiodigital;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.util.Duration;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Controller {
    @FXML
    private Label dateLabel;
    @FXML
    private Label hourLabel;
    @FXML
    private Label minuteLabel;
    @FXML
    private Label secondLabel;

    @FXML
    public void initialize(){
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String formattedDateTime = now.format(formatter);
        dateLabel.setText(formattedDateTime);

        // Criar uma animação que roda a cada segundo
        Timeline clock = new Timeline(
                new KeyFrame(Duration.seconds(0), e -> {
                    // a cada atualização ele executa os blocos abaixo
                    LocalDateTime currentTime = LocalDateTime.now();
                    hourLabel.setText(String.format("%02d", currentTime.getHour()));
                    minuteLabel.setText(String.format("%02d", currentTime.getMinute()));
                    secondLabel.setText(String.format("%02d", currentTime.getSecond()));
                }),
                new KeyFrame(Duration.seconds(1))
        );

        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();

    }
}

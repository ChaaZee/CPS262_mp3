package application;

import java.text.DecimalFormat;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GUIConverter extends Application{
	
	DecimalFormat df = new DecimalFormat("0.00");

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		GridPane pane = new GridPane();
		Scene scene = new Scene(pane, 450, 200);
		TextField textFieldL = new TextField();
		TextField textFieldR = new TextField();
		RadioButton radioButton1 = new RadioButton("Miles to Kilometers");
		RadioButton radioButton2 = new RadioButton("Celsius to Fahrenheit");
		RadioButton radioButton3 = new RadioButton("Pounds to Kilograms");
		
		ToggleGroup toggleGroup = new ToggleGroup();
		radioButton1.setToggleGroup(toggleGroup);
		radioButton2.setToggleGroup(toggleGroup);
		radioButton3.setToggleGroup(toggleGroup);
		
		radioButton1.setOnAction(e -> {
			textFieldR.setText("Kilometers");
			textFieldL.setText("Miles");
			radioButton1.requestFocus();
			scene.onKeyPressedProperty().bind(radioButton1.onKeyPressedProperty());
		});
		
		radioButton1.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent e) {
				if(e.getCode() == KeyCode.ENTER) {	
					if(textFieldL.isFocused()) {
						double miles = Double.parseDouble(textFieldL.getText());
						double kilometers = (double)(miles * 1.609344);
						textFieldR.setText(String.valueOf(df.format(kilometers)));						
					}
					if(textFieldR.isFocused()) {
						System.out.println("ENTER");
						double kilometers = Double.parseDouble(textFieldR.getText());
						double miles = (double)(kilometers / 1.609344);
						textFieldL.setText(String.valueOf(df.format(miles)));						
					}
				}
			}
		});

		radioButton2.setOnAction(e -> {
			textFieldR.setText("Fahrenheit");
			textFieldL.setText("Celsius");
			radioButton2.requestFocus();
			scene.onKeyPressedProperty().bind(radioButton2.onKeyPressedProperty());
		});
		
		radioButton2.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent e) {
				if(e.getCode() == KeyCode.ENTER) {
					if(textFieldL.isFocused()) {
						double celsius = Double.parseDouble(textFieldL.getText());
						double fahrenheit = (double)((celsius * 9/5) + 32);
						textFieldR.setText(String.valueOf(df.format(fahrenheit)));						
					}
					if(textFieldR.isFocused()) {
						double fahrenheit = Double.parseDouble(textFieldR.getText());
						double celsius = (double)((fahrenheit - 32) * 5/9);
						textFieldL.setText(String.valueOf(df.format(celsius)));						
					}
				}
			}
		});
		
		radioButton3.setOnAction(e -> {
			textFieldR.setText("Kilograms");
			textFieldL.setText("Pounds");
			radioButton3.requestFocus();
			scene.onKeyPressedProperty().bind(radioButton3.onKeyPressedProperty());
		});
		
		radioButton3.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent e) {
				if(e.getCode() == KeyCode.ENTER) {
					if(textFieldL.isFocused()) {
						double pounds = Double.parseDouble(textFieldL.getText());
						double kilograms = (double)(pounds * 0.45359237);
						textFieldR.setText(String.valueOf(df.format(kilograms)));						
					}
					if(textFieldR.isFocused()) {
						double kilograms = Double.parseDouble(textFieldR.getText());
						double pounds = (double)(kilograms / 0.45359237);
						textFieldL.setText(String.valueOf(df.format(pounds)));						
					}
				}
			}
		});
		
		pane.setHgap(10);
		pane.setVgap(10);
		pane.add(textFieldL, 0, 1);
		pane.add(radioButton1, 1, 0);
		pane.add(radioButton2, 1, 1);
		pane.add(radioButton3, 1, 2);
		pane.add(textFieldR, 2, 1);
		
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}



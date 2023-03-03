package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class RandomCards extends Application{
	
	Image[] cards = {
			new Image("1.png"), new Image("2.png"), new Image("3.png"), new Image("4.png"), new Image("5.png"), new Image("6.png"), new Image("7.png"), new Image("8.png"), new Image("9.png"), new Image("10.png"), 
			new Image("11.png"), new Image("12.png"), new Image("13.png"), new Image("14.png"), new Image("15.png"), new Image("16.png"), new Image("17.png"), new Image("18.png"), new Image("19.png"), new Image("20.png"), 
			new Image("21.png"), new Image("22.png"), new Image("23.png"), new Image("24.png"), new Image("25.png"), new Image("26.png"), new Image("27.png"), new Image("28.png"), new Image("29.png"), new Image("30.png"), 
			new Image("31.png"), new Image("32.png"), new Image("33.png"), new Image("34.png"), new Image("35.png"), new Image("36.png"), new Image("37.png"), new Image("38.png"), new Image("39.png"), new Image("40.png"), 
			new Image("41.png"), new Image("42.png"), new Image("43.png"), new Image("44.png"), new Image("45.png"), new Image("46.png"), new Image("47.png"), new Image("48.png"), new Image("49.png"), new Image("50.png"), 
			new Image("51.png"), new Image("52.png"), 
	};
	
	Image back = new Image("back.png");
	ImageView backView1 = new ImageView(back);
	ImageView backView2 = new ImageView(back);
	ImageView backView3 = new ImageView(back);
	ImageView backView4 = new ImageView(back);
	
	Image card1;
	Image card2;
	Image card3;
	Image card4;
	
	ImageView viewCard;
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		GridPane pane = new GridPane();
		Button refresh = new Button("Refresh");
		
		backView1.setFitHeight(200);
		backView1.setPreserveRatio(true);
		backView2.setFitHeight(200);
		backView2.setPreserveRatio(true);
		backView3.setFitHeight(200);
		backView3.setPreserveRatio(true);
		backView4.setFitHeight(200);
		backView4.setPreserveRatio(true);
		
		pane.setVgap(50);
		pane.setHgap(10);
		pane.add(refresh, 0, 1);
		
		card1 = cards[(int)(Math.random()*cards.length)];
		card2 = cards[(int)(Math.random()*cards.length)];
		card3 = cards[(int)(Math.random()*cards.length)];
		card4 = cards[(int)(Math.random()*cards.length)];
		
		refresh.setOnAction(e -> {
			card1 = cards[(int)(Math.random()*cards.length)];
			card2 = cards[(int)(Math.random()*cards.length)];
			card3 = cards[(int)(Math.random()*cards.length)];
			card4 = cards[(int)(Math.random()*cards.length)];
			
			pane.getChildren().remove(viewCard);
			
			pane.getChildren().remove(backView1);
			pane.add(backView1, 0, 0);
			pane.getChildren().remove(backView2);
			pane.add(backView2, 1, 0);
			pane.getChildren().remove(backView3);
			pane.add(backView3, 2, 0);
			pane.getChildren().remove(backView4);
			pane.add(backView4, 3, 0);
		});
		
		pane.setOnMouseClicked(e -> {
			double mouseY = e.getSceneY();
			double mouseX = e.getSceneX();
			//System.out.println("(" + mouseX + ", " + mouseY + ")");
			
			if(mouseY <= 200) {
				if(mouseX <= 141) {
					//pane.getChildren().remove(viewCard);
					viewCard = new ImageView(card1);
					viewCard.setFitHeight(200);
					viewCard.setPreserveRatio(true);
					pane.getChildren().remove(backView1);
					pane.add(viewCard, 0, 0);	
				}
				if(mouseX >= 161 && mouseX <= 302) {
					//pane.getChildren().remove(viewCard);
					viewCard = new ImageView(card2);
					viewCard.setFitHeight(200);
					viewCard.setPreserveRatio(true);
					pane.getChildren().remove(backView2);
					pane.add(viewCard, 1, 0);
				}
				if(mouseX >= 306 && mouseX <= 447) {
					//pane.getChildren().remove(viewCard);
					viewCard = new ImageView(card3);
					viewCard.setFitHeight(200);
					viewCard.setPreserveRatio(true);
					pane.getChildren().remove(backView3);
					pane.add(viewCard, 2, 0);
				}
				if(mouseX >= 459) {
					//pane.getChildren().remove(viewCard);
					viewCard = new ImageView(card4);
					viewCard.setFitHeight(200);
					viewCard.setPreserveRatio(true);
					pane.getChildren().remove(backView4);
					pane.add(viewCard, 3, 0);
				}
			}
		});
		
		Scene scene = new Scene(pane, 630, 300);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}

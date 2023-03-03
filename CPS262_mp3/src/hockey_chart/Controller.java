package hockey_chart;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;

public class Controller implements Initializable{
	
	@SuppressWarnings("rawtypes")
	public BarChart chart;
	
	FileReader file = null;
	int c;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		XYChart.Series series = new XYChart.Series();
		try {
			file = new FileReader("hockeyStats.txt");	
			
			for(int i = 0; i < 7; i++) {
				String l = "";
				
				while((char)c != ',') {
					c = file.read();
					if((char)c != ',') { 
						String s = String.valueOf((char)c);
						l += s;
					}
				}			
				
				String n = "";
				
				while((char)c != '*') {
					c = file.read();
					if((char)c != '*') {
						String s = String.valueOf((char)c);
						n += s;
					}
				}
				System.out.println(l + ": " + Integer.parseInt(n));
				series.getData().add(new XYChart.Data(l, Integer.parseInt(n)));
			}
			
			chart.getData().add(series);
			
		} catch (IOException e) {
			System.out.println("File not found");
		}
		
	}
	
	

}

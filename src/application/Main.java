package application;
	
import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;


public class Main extends Application {
	public void start(Stage stage)
	{
		build(stage);
		stage.setTitle(getClass().getName());
		stage.show();
	}

	public void build(Stage stage)
	{
		Screen screen = Screen.getPrimary();
		Rectangle2D bounds = screen.getVisualBounds();
		
		WebView myWebView = new WebView();
		WebEngine engine = myWebView.getEngine();
		engine.load(getClass().getResource("pdfjs-1.4.20-dist/web/viewer.html").toExternalForm() + "#zoom=page-fit&page=2");
		//engine.load("http://www.google.com");
		
		
		VBox root = new VBox();
		root.setVgrow(myWebView, Priority.ALWAYS);
		root.getChildren().addAll(myWebView);
		
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setX(bounds.getMinX());
		stage.setY(bounds.getMinY());
		stage.setWidth(bounds.getWidth());
		stage.setHeight(bounds.getHeight());
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

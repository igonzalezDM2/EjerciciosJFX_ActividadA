package application;
	
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class Main extends Application {
	
    private ObservableList<String> listaDeportes;
    private ObservableList<String> listaEdades;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("/fxml/ActividadA.fxml"));
			Scene scene = new Scene(root,800,800);
			inicializarListas(scene);
			
			
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private void inicializarListas(Scene scene) {
		listaDeportes = FXCollections.observableArrayList();
		listaDeportes.add("Tenis");
		listaDeportes.add("Fúbol");
		listaDeportes.add("Baloncesto");
		listaDeportes.add("Natación");
		listaDeportes.add("Ciclismo");
		listaDeportes.add("Otro");

		listaEdades = FXCollections.observableArrayList();
		listaEdades.add("Menores de 18");
		listaEdades.add("Entre 18 y 30");
		listaEdades.add("Entre 31 y 50");
		listaEdades.add("Entre 51 y 70");
		listaEdades.add("Mayores de 70");
		
		
		ListView<String> lvDeporte = (ListView<String>) scene.lookup("#lvDeporte");
		lvDeporte.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		lvDeporte.setItems(listaDeportes);
		
		ComboBox<String> cdEdad = (ComboBox<String>) scene.lookup("#cbEdad");
		cdEdad.setItems(listaEdades);
		cdEdad.getSelectionModel().selectFirst();
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

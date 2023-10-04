package controller;

import java.util.Locale;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

public class ActividadAController {

    @FXML
    private Button btnAceptar;

    @FXML
    private Button btnCancelar;

    @FXML
    private CheckBox cbDeporte;

    @FXML
    private ComboBox<?> cbEdad;

    @FXML
    private ListView<?> lvDeporte;

    @FXML
    private RadioButton rbHombre;

    @FXML
    private RadioButton rbMujer;

    @FXML
    private RadioButton rbOtro;

    @FXML
    private Slider sCompras;

    @FXML
    private Slider sIrAlCine;

    @FXML
    private Slider sVerTelevision;

    @FXML
    private TextField tfHermanos;

    @FXML
    private TextField tfProfesion;

    @FXML
    private ToggleGroup tgSexo;

    @FXML
    void aceptar(ActionEvent event) {
    	String profesion = tfProfesion.getText().toString();
    	String numHermanosStr = tfHermanos.getText().toString();
    	
    	//TODO: comprobar el checkbox
    	ObservableList<String> selItems = (ObservableList<String>) lvDeporte.getSelectionModel().getSelectedItems();

    	StringBuilder sb = new StringBuilder();
    	if (profesion == null || profesion.isEmpty()) {
    		
    		sb.append("Hay que rellenar el campo profesión\n");
    	}
    	if (numHermanosStr== null || numHermanosStr.isEmpty()) {
    		sb.append("Hay que rellenar el campo Nº de hermanos\n");
    	}else if (!numHermanosStr.matches("[\\d\\.]+")) {
    		sb.append("El campo Nº de hermanos debe ser numérico\n");
    	}
    	if (cbDeporte.isSelected() && (selItems == null || selItems.isEmpty())) {
    		sb.append("Tienes que indicar los deportes que practicas\n");
    	}
    	
    	if (!sb.isEmpty()) {
    		Alert alert = new Alert(AlertType.ERROR, sb.toString(), ButtonType.YES);
    		alert.showAndWait();
    	} else {
    		
    		String edad = (String) cbEdad.getSelectionModel().getSelectedItem();
    		RadioButton sexRb = (RadioButton) tgSexo.getSelectedToggle();
    		
    		String gradoCompras =  String.format(Locale.ITALIAN, "%.1f", sCompras.getValue());
    		String gradoTv =  String.format(Locale.ITALIAN, "%.1f", sVerTelevision.getValue());
    		String gradoCine=  String.format(Locale.ITALIAN, "%.1f", sIrAlCine.getValue());
    		
    		StringBuilder sbinfo = new StringBuilder();
    		sbinfo.append(String.format("Profesión: %s\n", profesion));
    		sbinfo.append(String.format("Nº de hermanos: %s\n", numHermanosStr));
    		sbinfo.append(String.format("Edad: %s\n", edad != null ? edad : ""));
    		sbinfo.append(String.format("Sexo: %s\n", sexRb != null ? sexRb.getText() : ""));
    		sbinfo.append("Deportes que practicas:\n");
    		selItems.forEach(dep -> sbinfo.append(String.format("\t%s\n", dep)));
    		sbinfo.append(String.format("Grado de afición a las compras: %s\n", gradoCompras));
    		sbinfo.append(String.format("Grado de afición a ver la televisión: %s\n", gradoTv));
    		sbinfo.append(String.format("Grado de afición a ir al cine: %s\n", gradoCine));
    		
    		Alert alert = new Alert(AlertType.INFORMATION, sbinfo.toString(), ButtonType.YES);
    		alert.showAndWait();
    		
    	}
    	
    	
    	
//    	LinkedList<Text> txtList = new LinkedList<>();
//    	txtList.add(new Text(String.format("Profesión: %s", tfProfesion.getText().toString())));
    }

    @FXML
    void cancelar(ActionEvent event) {
    	Node source = (Node) event.getSource();
    	Stage stage = (Stage) source.getScene().getWindow();
    	stage.close();
    }

}
package main.java.view;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TitledPane;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import main.java.entity.MedidorJson;
import main.java.util.HttpConnectionMethods;


public class MainScreenController {
	@FXML
    public TitledPane paneLinha;
	
	@FXML
	public ComboBox<String> comboBoxLinha;

	@FXML
	public TitledPane paneModelo;
	
	@FXML
	public TreeView<String> treeViewModelo;
	
	
	HttpConnectionMethods httpConn = new HttpConnectionMethods();
	public List<String> linhaData = new ArrayList<String>();
	
	public int nLinha = 0;
	public int nCategoria = 0;
	
	private List<MedidorJson> medidorData = null;
	
	@FXML
    void lineOptionSelect() {
		if(comboBoxLinha.getSelectionModel().getSelectedItem() != null)
			loadTreeView();
    }
	
	@FXML
    public void refreshDataBase() throws IOException {
		paneLinha.setExpanded(false);
		comboBoxLinha.getSelectionModel().select(null);
		loadScreen();
    }
	
	@FXML
	public void initialize() throws IOException {		
		startScreen();		
	}
	 	
	public void startScreen() throws IOException {
		loadScreen();
	}
	
	public void loadScreen() throws IOException {
		paneModelo.setExpanded(false);
		paneModelo.setDisable(true);
		
		linhaData.clear();
		
		medidorData = httpConn.restGET();
		
		for(MedidorJson medidorA : medidorData) {
			if(!linhaData.contains(medidorA.getLinha())) {			
				linhaData.add(medidorA.getLinha());
				nLinha++;
			}
		}		
		
		comboBoxLinha.setItems(FXCollections.observableArrayList(linhaData));
	}
	
	public void loadTreeView() {
		paneModelo.setDisable(false);
		
		nCategoria = 0;
		TreeItem<String> treeViewRoot = new TreeItem<String>(comboBoxLinha.getSelectionModel().getSelectedItem().toString());
		treeViewModelo.setRoot(treeViewRoot);
		
		List<String> categoriaData = new ArrayList<String>();		
				
		for(MedidorJson medidorA : medidorData) {
			if(medidorA.getLinha().equals(comboBoxLinha.getSelectionModel().getSelectedItem().toString())) {
				
				if(!categoriaData.contains(medidorA.getCategoria())) {
					categoriaData.add(medidorA.getCategoria());
					treeViewRoot.getChildren().add(new TreeItem<String>(medidorA.getCategoria()));
					treeViewRoot.getChildren().get(nCategoria).getChildren().add(new TreeItem<String>(medidorA.getLinha() + " " + medidorA.getModelo()));
					nCategoria++;
				} else {
					for(int i = 0; i < nCategoria; i++) {
						if(medidorA.getCategoria().equals(categoriaData.get(i))) {
							treeViewRoot.getChildren().get(i).getChildren().add(new 
									TreeItem<String>(medidorA.getLinha() + " " + medidorA.getModelo()));
						}
					}
				}
			}
		}
		
	}
}
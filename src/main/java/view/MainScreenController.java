package main.java.view;

import java.util.ArrayList;
import java.util.List;


import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TitledPane;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import main.java.App;
import main.java.entity.Medidor;
import main.java.service.MedidorService;

public class MainScreenController {
	@FXML
    private TitledPane paneLinha;
	
	@FXML
	private ComboBox<String> comboBoxLinha;

	@FXML
	private TitledPane paneMedidor;
	
	@FXML
	private TreeView<String> treeViewModelo;
	
	public List<String> linhaData = new ArrayList<String>();
	
	public int nLinha = 0;
	public int nCategoria = 0;
	
	private List<Medidor> medidorData;
	
	private App mainApp;
	
	private MedidorService medidorService = new MedidorService();
	 
	public void setMain(App mainApp) {
		this.mainApp = mainApp;
	}
	
	@FXML
    void lineOptionSelect(ActionEvent event) {
		String optSel = comboBoxLinha.getSelectionModel().getSelectedItem().toString();
		loadTreeView(optSel);
    }
	
	@FXML
    void refreshDataBase(ActionEvent event) {
		paneMedidor.setExpanded(false);
		comboBoxLinha.getSelectionModel().clearSelection();
		paneMedidor.setDisable(true);
		loadScreen();
    }
	
	@FXML
	public void initialize() {
		startScreen();
	}
		
	 
	public void loadScreen() {
			
		linhaData.clear();
		
		medidorData = medidorService.findAll();
		
		for(Medidor medidorA : medidorData) {
			if(!linhaData.contains(medidorA.getLinha())) {			
				linhaData.add(medidorA.getLinha());
				nLinha++;
			}
		}		 
		comboBoxLinha.setItems(FXCollections.observableArrayList(linhaData));	
	}
	 
	public void startScreen() {
		loadScreen();
		paneMedidor.setDisable(true);
	}
	
	public void loadTreeView(String optModelo) {
		paneMedidor.setDisable(false);
		
		nCategoria = 0;
		
		TreeItem<String> treeViewRoot = new TreeItem<String>(optModelo);
		treeViewModelo.setRoot(treeViewRoot);
		
		List<String> categoriaData = new ArrayList<String>();		
				
		for(Medidor medidorA : medidorData) {
			if(medidorA.getLinha().equals(optModelo)) {
				
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

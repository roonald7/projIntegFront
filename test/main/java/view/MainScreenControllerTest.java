package main.java.view;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;
import org.mockito.internal.matchers.NotNull;
import org.powermock.api.mockito.PowerMockito;
import org.testfx.framework.junit.ApplicationTest;

import javafx.scene.control.ComboBox;
import javafx.scene.control.TitledPane;
import javafx.scene.control.TreeView;
import main.java.util.HttpConnectionMethods;

import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.io.IOException;

public class MainScreenControllerTest extends ApplicationTest{
	
	public MainScreenController msc = spy(MainScreenController.class);
	public HttpConnectionMethods hcm = spy(HttpConnectionMethods.class);
	
	@Test
	public void testInitialize() throws IOException {		
		PowerMockito.doNothing().when(msc).startScreen();
		msc.initialize();
		verify(msc, times(1)).startScreen();
	}
	
	/*@Test
	public void testLoadScreen1() throws IOException {
		msc.comboBoxLinha = new ComboBox<String>();
		msc.paneModelo = new TitledPane();
		msc.paneLinha = new TitledPane();
		
		msc.loadScreen();
		
		assertTrue(msc.linhaData.size()>0);
	}*/
	
	@Test
	public void testLoadScreen3() throws IOException {
		msc.comboBoxLinha = new ComboBox<String>();
		msc.paneModelo = new TitledPane();
		
		msc.loadScreen();
		
		if(msc.comboBoxLinha.getSelectionModel().getSelectedItem() == null) {
			assertEquals("Checking if PaneModel is disable when ComboBox is Clear", true, msc.paneModelo.isDisable());
		}
	}
	
	@Test
	public void testLoadTreeView1() throws IOException {
		msc.comboBoxLinha = new ComboBox<String>();
		msc.paneModelo = new TitledPane();
		msc.treeViewModelo = new TreeView<String>();
		
		msc.loadScreen();
		msc.comboBoxLinha.getSelectionModel().select("ZEUS");
		
		msc.loadTreeView();
		
		assertEquals("Checking if Root is the same as ComboBox selection","ZEUS", msc.treeViewModelo.getRoot().getValue().toString());
	}
	
	@Test
	public void testLoadTreeView2() throws IOException {
		msc.comboBoxLinha = new ComboBox<String>();
		msc.paneModelo = new TitledPane();
		msc.treeViewModelo = new TreeView<String>();
		
		msc.loadScreen();
		msc.comboBoxLinha.getSelectionModel().select("ZEUS");
		
		msc.loadTreeView();
		
		assertNotNull("Checking if there is any Children inside TreeView", msc.treeViewModelo.getRoot().getChildren().get(0).getValue());
	}
	
	@Test
	public void testRefreshDataBase() throws IOException {		
		
		msc.comboBoxLinha = new ComboBox<String>();
		msc.paneModelo = new TitledPane();
		msc.paneLinha = new TitledPane();
		
		PowerMockito.doNothing().when(msc).loadScreen();
		
		msc.refreshDataBase();
		
		verify(msc, times(1)).loadScreen();
	}
	
	@Test
	public void testLineOptionSelect() throws IOException {
		msc.comboBoxLinha = new ComboBox<String>();
		msc.paneModelo = new TitledPane();
		
		PowerMockito.doNothing().when(msc).loadTreeView();
				
		msc.comboBoxLinha.getSelectionModel().select("ZEUS");
		
		msc.loadScreen();
		msc.lineOptionSelect();
	
		verify(msc, times(1)).loadTreeView();
	}
	

}

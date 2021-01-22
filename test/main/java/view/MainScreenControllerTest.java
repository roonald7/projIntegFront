package main.java.view;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;
import org.testfx.framework.junit.ApplicationTest;

import javafx.scene.control.ComboBox;
import javafx.scene.control.TitledPane;
import javafx.scene.control.TreeView;

import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.io.IOException;

public class MainScreenControllerTest extends ApplicationTest{
	
	private MainScreenController msc;
	
	@Before
	public void initTest() {
		msc = spy(MainScreenController.class);
		
		msc.comboBoxLinha = new ComboBox<String>();
		msc.paneModelo = new TitledPane();
		msc.paneLinha = new TitledPane();
		msc.treeViewModelo = new TreeView<String>();
		
	}
	
	@After
	public void finishTest() {
		msc = null;
		
	}
	
	@Test
	public void testInitialize() throws IOException {		
		PowerMockito.doNothing().when(msc).startScreen();
		msc.initialize();
		verify(msc, times(1)).startScreen();
	}
	
	@Test
	@Ignore
	public void testLoadScreen1() throws IOException {
		msc.loadScreen();
		if(msc.comboBoxLinha.getSelectionModel().getSelectedItem() == null) {
			assertEquals("Checking if PaneModel is disable when ComboBox is Clear", true, msc.paneModelo.isDisable());
		}
	}
	
	@Test
	@Ignore
	public void testLoadTreeView1() throws IOException {
		
		msc.loadScreen();
		msc.comboBoxLinha.getSelectionModel().select("ZEUS");
		
		msc.loadTreeView();
		
		assertEquals("Checking if Root is the same as ComboBox selection","ZEUS", msc.treeViewModelo.getRoot().getValue().toString());
	}
	
	@Test
	@Ignore
	public void testLoadTreeView2() throws IOException {
		msc.loadScreen();
		msc.comboBoxLinha.getSelectionModel().select("ZEUS");
		
		msc.loadTreeView();
		
		assertNotNull("Checking if there is any Children inside TreeView", msc.treeViewModelo.getRoot().getChildren().get(0).getValue());
	}
	
	@Test
	public void testRefreshDataBase() throws IOException {		
		PowerMockito.doNothing().when(msc).loadScreen();
		
		msc.refreshDataBase();
		
		verify(msc, times(1)).loadScreen();
	}
	
	@Test
	@Ignore
	public void testLineOptionSelect() throws IOException {
		PowerMockito.doNothing().when(msc).loadTreeView();
				
		msc.comboBoxLinha.getSelectionModel().select("ZEUS");
		
		msc.loadScreen();
		msc.lineOptionSelect();
	
		verify(msc, times(1)).loadTreeView();
	}
	
	@Test
	public void testStartScreen() throws IOException {
		PowerMockito.doNothing().when(msc).loadScreen();
		
		msc.startScreen();
	
		verify(msc, times(1)).startScreen();
	}
	

}

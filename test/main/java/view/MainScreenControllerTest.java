package main.java.view;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;
import org.testfx.framework.junit.ApplicationTest;

import javafx.scene.control.ComboBox;
import javafx.scene.control.TitledPane;
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
	
	@Ignore
	@Test
	public void testLoadScreen1() throws IOException {
		msc.comboBoxLinha = new ComboBox<String>();
		msc.paneModelo = new TitledPane();
		msc.paneLinha = new TitledPane();
		
		msc.loadScreen();
		
		assertTrue(msc.linhaData.size()>0);
		
	}
	
	@Ignore
	@Test
	public void testLoadScreen2() throws IOException {
		msc.comboBoxLinha = new ComboBox<String>();
		msc.paneModelo = new TitledPane();
		
		msc.loadScreen();
		
		assertEquals(3, msc.linhaData.size());
	}
	
	@Ignore
	@Test
	public void testRefreshDataBase() throws IOException {		
		
		msc.comboBoxLinha = new ComboBox<String>();
		msc.paneModelo = new TitledPane();
		msc.paneLinha = new TitledPane();
		
		PowerMockito.doNothing().when(msc).loadScreen();
		
		msc.refreshDataBase();
		
		verify(msc, times(1)).loadScreen();
	}
	

}

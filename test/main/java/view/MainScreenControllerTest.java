package main.java.view;

import static org.junit.Assert.*;

import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;
import org.testfx.framework.junit.ApplicationTest;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TitledPane;

import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class MainScreenControllerTest extends ApplicationTest{
	
	public MainScreenController msc = spy(MainScreenController.class);
	
	@Test
	public void testInitialize() {
		msc.comboBoxLinha = new ComboBox<String>();
		
		msc.paneMedidor = new TitledPane();
		
		msc.initialize();
		verify(msc, times(1)).startScreen();
	}
		
	@Test
	public void testLoadScreen1() {
		msc.comboBoxLinha = new ComboBox<String>();
		
		msc.loadScreen();
		
		assertTrue(msc.linhaData.size()>0);
		
	}
	
	@Test
	public void testLoadScreen2() {
		msc.comboBoxLinha = new ComboBox<String>();
		
		
		
		msc.loadScreen();
		
		assertEquals(3, msc.linhaData.size());
	}
	
	@Test
	public void testRefreshDataBase() {		
		
		msc.comboBoxLinha = new ComboBox<String>();
		msc.paneMedidor = new TitledPane();
		
		PowerMockito.doNothing().when(msc).loadScreen();

		msc.refreshDataBase();
		
		verify(msc, times(1)).loadScreen();
	}

}

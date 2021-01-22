package main.java;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class AppTest extends ApplicationTest {
	
	private App app = spy(App.class);
	
	@Test
	@Ignore
	public void testLoadMainScreen() {
		app.primaryStage = new Stage();
		app.rootLayout = new AnchorPane();
		
		app.loadMainScreen();
		
		assertEquals(true, app.primaryStage.isShowing());
	}

}

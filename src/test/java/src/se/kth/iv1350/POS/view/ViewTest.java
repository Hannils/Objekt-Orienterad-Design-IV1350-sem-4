package src.se.kth.iv1350.POS.view;

import org.junit.jupiter.api.*;
import src.se.kth.iv1350.POS.controller.Controller;
import src.se.kth.iv1350.POS.integration.DCHandler;
import src.se.kth.iv1350.POS.integration.EASHandler;
import src.se.kth.iv1350.POS.integration.EISHandler;
import src.se.kth.iv1350.POS.integration.Printer;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;

class ViewTest {
  private View instanceToTest;
  private EASHandler eas;
  private EISHandler eis;
  private Printer printer;
  private DCHandler dc;
  private ByteArrayOutputStream printoutBuffer;
  private PrintStream originalSysOut;

  @BeforeEach
  public void setUp() {
	printoutBuffer = new ByteArrayOutputStream();
	PrintStream inMemSysOut = new PrintStream(printoutBuffer);
	originalSysOut = System.out;
	System.setOut(inMemSysOut);
	eis = new EISHandler();
	eas = new EASHandler();
	printer = new Printer();
	dc = new DCHandler();
	Controller contr = new Controller(eis, eas, printer, dc);
	instanceToTest = new View(contr);
  }
  @AfterEach
  public void tearDown() {
	instanceToTest = null;
	printoutBuffer = null;
	System.setOut(originalSysOut);
      eis = null;
      eas = null;
      printer = null;
      Controller contr = null;
      instanceToTest = null;
  }
  @Test
  public void testRunFakeExecution() {
	instanceToTest.runFakeExecution();
	String printout = printoutBuffer.toString();
	assertTrue(printout.contains("started"), "UI did not start correctly.");
  }
}
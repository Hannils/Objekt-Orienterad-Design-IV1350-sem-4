package src.se.kth.iv1350.POS.startup;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;

class MainTest {
  private Main instanceToTest;
  private ByteArrayOutputStream printoutBuffer;
  private PrintStream originalSysOut;

  @BeforeEach
  public void setUp() {
	printoutBuffer = new ByteArrayOutputStream();
	PrintStream inMemSysOut = new PrintStream(printoutBuffer);
	originalSysOut = System.out;
	System.setOut(inMemSysOut);
	instanceToTest = new Main();
  }

  @AfterEach
  public void tearDown() {
	printoutBuffer = null;
	System.setOut(originalSysOut);
	  instanceToTest = null;
  }
  @Test
  public void testUIHasStarted() {
	String[] args = null;
	Main.main(args);
	String printout = printoutBuffer.toString();
	assertTrue(printout.contains("started"), "UI did not start correctly.");
  }

}
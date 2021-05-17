package src.se.kth.iv1350.POS.controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import src.se.kth.iv1350.POS.DTO.PaymentDTO;
import src.se.kth.iv1350.POS.DTO.SaleInfoDTO;
import src.se.kth.iv1350.POS.integration.*;
import src.se.kth.iv1350.POS.model.Sale;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {
  private Controller instanceToTest;
  private EASHandler eas;
  private EISHandler eis;
  private Printer printer;
  private DCHandler dc;
  private String currency;
  private int amount;
  private ByteArrayOutputStream printoutBuffer;
  private PrintStream originalSysOut;

  @BeforeEach
  public void setUp() {
	printoutBuffer = new ByteArrayOutputStream();
	PrintStream inMemSysOut = new PrintStream(printoutBuffer);
	originalSysOut = System.out;
	System.setOut(inMemSysOut);
	eas = new EASHandler();
	eis = new EISHandler();
	printer = new Printer();
	dc = new DCHandler();
	instanceToTest = new Controller(eis, eas, printer, dc);
	instanceToTest.startSale();
  }
  @AfterEach
  public void tearDown() {
	printoutBuffer = null;
	System.setOut(originalSysOut);
	eas = null;
	eis = null;
	printer = null;
	instanceToTest = null;
  }
  @Test
  public void testControllerHasStarted() {
    String printOut = this.printoutBuffer.toString();
	assertTrue(printOut.contains("successfully"), "Controller did not start correctly.");
  }
  @Test
  public void testStartSaleHasStarted() {
	String printOut = this.printoutBuffer.toString();
	assertTrue(printOut.contains("started"), "Sale did not start correctly.");
  }
  @Test
  public void testEnterItemHasEnteredItem(){
      try {
          instanceToTest.enterItem("first");
          String printOut = eis.findItem("first").getName();
          assertTrue(printOut.contains("Uncle Ben's 1 minute rice"), "Item did not enter correctly.");
      } catch (Exception exec) {
          fail("An exception was thrown: " + exec.getMessage());
      }

  }
  @Test
  public void testIfPaymentHasGoneThrough() {
      PaymentDTO paymentDTO = instanceToTest.pay(amount, currency);
      String printOut = paymentDTO.toString();
      assertTrue(printOut.contains(amount + " " + currency), "Payment did not go through.");
  }
  @Test
  public void testIfChangeIsCalculatedCorrectly() {
      try {
          SaleInfoDTO saleInformation = instanceToTest.enterItem("first");
          assertEquals(81.25, 100 - saleInformation.getRunningTotal(), "Change was not calculated correctly.");
      } catch(Exception exec) {
          fail("An exception was thrown: " + exec.getMessage());
      }

  }
}
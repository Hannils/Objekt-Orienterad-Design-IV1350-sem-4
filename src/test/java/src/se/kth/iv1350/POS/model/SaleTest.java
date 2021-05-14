package src.se.kth.iv1350.POS.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import src.se.kth.iv1350.POS.DTO.ItemDTO;
import src.se.kth.iv1350.POS.DTO.SaleInfoDTO;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;

class SaleTest {
  private Sale instanceToTest;
  private ItemDTO firstItemDTO;
  private ItemDTO secondItemDTO;
  private ItemDTO[] itemDTOArrayForTesting;
  private ByteArrayOutputStream printoutBuffer;
  private PrintStream originalSysOut;

  @BeforeEach
  public void setUp() {
	printoutBuffer = new ByteArrayOutputStream();
	PrintStream inMemSysOut = new PrintStream(printoutBuffer);
	originalSysOut = System.out;
	System.setOut(inMemSysOut);
	instanceToTest = new Sale();
	firstItemDTO = new ItemDTO("Ris", 0.25, 15, "Basmati", "first");
	secondItemDTO = new ItemDTO("Dryck", 0.15, 9.90, "Dryck", "second");
	itemDTOArrayForTesting = new ItemDTO[2];
	itemDTOArrayForTesting[0] = firstItemDTO;
	itemDTOArrayForTesting[1] = secondItemDTO;
  }
  @AfterEach
  public void tearDown() {
	printoutBuffer = null;
	System.setOut(originalSysOut);
      instanceToTest = null;
      firstItemDTO = null;
      secondItemDTO = null;
      itemDTOArrayForTesting = null;
      instanceToTest = null;
  }
  @Test
  public void testIfItemAddedToSale() {
	SaleInfoDTO saleInformation = instanceToTest.addItem(firstItemDTO);
	String printout = saleInformation.getCurrentItemName();
	assertTrue(printout.contains("Basmati"), "Sale did not add item correctly.");
  }
  @Test
  public void testIfCalculationOfTotalPriceWorksCorrectly() {
      instanceToTest.addItem(firstItemDTO);
      instanceToTest.addItem(secondItemDTO);
      assertEquals(instanceToTest.getTotalPrice(), 24.9,
              "Calculation of Total Price did not work correctly.");
  }
  @Test
    public void testIfCalculationOfTotalVATWorksCorrectly() {
      instanceToTest.addItem(firstItemDTO);
      instanceToTest.addItem(secondItemDTO);
      assertEquals(instanceToTest.getTotalVAT(), 5.235,
              "Calculation of Total VAT did not work correctly.");
  }
  @Test
    public void testIfCalculationOfRunningTotalWorksCorrectly() {
      instanceToTest.addItem(firstItemDTO);
      instanceToTest.addItem(secondItemDTO);
      assertEquals(instanceToTest.getRunningTotal(), 30.135, 0.0001,
              "Calculation of Running Total did not work correctly.");
  }
  @Test
    public void testIfConversionFromItemDTOToItemWorksCorrectly() {
      instanceToTest.addItem(firstItemDTO);
      instanceToTest.addItem(secondItemDTO);
      for (int i = 0; i < instanceToTest.getItems().size(); i++) {
          assertEquals(itemDTOArrayForTesting[i].getName(), instanceToTest.getItems().get(i).getName()
          , "Name got lost in conversion.");
          assertEquals(itemDTOArrayForTesting[i].getDescription(), instanceToTest.getItems().get(i).getDescription()
                  , "Description got lost in conversion.");
          assertEquals(itemDTOArrayForTesting[i].getPrice(), instanceToTest.getItems().get(i).getPrice()
                  , "Price got lost in conversion.");
          assertEquals(itemDTOArrayForTesting[i].getVAT(), instanceToTest.getItems().get(i).getVAT()
                  , "VAT got lost in conversion.");
      }
  }
}
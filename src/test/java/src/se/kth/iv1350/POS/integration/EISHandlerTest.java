package src.se.kth.iv1350.POS.integration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import src.se.kth.iv1350.POS.DTO.ItemDTO;
import src.se.kth.iv1350.POS.controller.Controller;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;

class EISHandlerTest {
    private EISHandler instanceToTest;
    private ItemDTO firstTestItemDTO;
    private ItemDTO secondTestItemDTO;
    private ItemDTO thirdTestItemDTO;
    private String messageForFindItemTest;
    private String firstIdentifier;
    private String secondIdentifier;
    private String thirdIdentifier;
    private ByteArrayOutputStream printoutBuffer;
    private PrintStream originalSysOut;

    @BeforeEach
    public void setUp() {
        printoutBuffer = new ByteArrayOutputStream();
        PrintStream inMemSysOut = new PrintStream(printoutBuffer);
        originalSysOut = System.out;
        System.setOut(inMemSysOut);
        instanceToTest = new EISHandler();
        firstIdentifier = "first";
        secondIdentifier = "second";
        thirdIdentifier = "third";
        messageForFindItemTest = "findItem did not work correctly";
    }
    @AfterEach
    public void tearDown() {
        firstIdentifier = null;
        secondIdentifier = null;
        thirdIdentifier = null;
        instanceToTest = null;
        printoutBuffer = null;
        System.setOut(originalSysOut);
    }
    @Test
    public void testIfFindItemWorksCorrectly() {
        firstTestItemDTO = instanceToTest.findItem(firstIdentifier);
        secondTestItemDTO = instanceToTest.findItem(secondIdentifier);
        thirdTestItemDTO = instanceToTest.findItem(thirdIdentifier);
        assertEquals("Uncle Ben's 1 minute rice", firstTestItemDTO.getName(), messageForFindItemTest);
        assertEquals("Coca Cola", secondTestItemDTO.getName(), messageForFindItemTest);
        assertEquals("Knox Stark", thirdTestItemDTO.getName(), messageForFindItemTest);
    }
}
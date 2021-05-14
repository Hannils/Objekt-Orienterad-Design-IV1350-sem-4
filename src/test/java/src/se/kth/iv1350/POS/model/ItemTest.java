package src.se.kth.iv1350.POS.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import src.se.kth.iv1350.POS.DTO.ItemDTO;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;

class ItemTest {
    private Item item;
    private ItemDTO itemDTO;
    private ByteArrayOutputStream printoutBuffer;
    private PrintStream originalSysOut;

    @BeforeEach
    void setUp() {
        printoutBuffer = new ByteArrayOutputStream();
        PrintStream inMemSysOut = new PrintStream(printoutBuffer);
        originalSysOut = System.out;
        System.setOut(inMemSysOut);
        itemDTO = new ItemDTO("Ris", 0.25, 15, "Basmati", "first");
        item = new Item(itemDTO, 1);
    }
    @AfterEach
    void tearDown() {
        printoutBuffer = null;
        System.setOut(originalSysOut);
        itemDTO = null;
        item = null;
    }

    @Test
    public void testIfItemToStringWorksAsExpected() {
        String printout = item.toString();
        String expectedOutput = "("+item.getQuantity()+"x, "+item.getName() +", "+ item.getDescription()+
                ", PRIS:"+item.getPrice()+"kr, MOMS:"+ item.getVAT()*item.getPrice() +"kr)\n";
        assertTrue(printout.contains(expectedOutput), "item-toString did not print correctly.");
    }

}
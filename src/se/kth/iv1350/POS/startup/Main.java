package src.se.kth.iv1350.POS.startup;

import src.se.kth.iv1350.POS.controller.Controller;
import src.se.kth.iv1350.POS.integration.DCHandler;
import src.se.kth.iv1350.POS.integration.EASHandler;
import src.se.kth.iv1350.POS.integration.EISHandler;
import src.se.kth.iv1350.POS.integration.Printer;
import src.se.kth.iv1350.POS.view.View;

/**
 * This is the main class.
 */
public class Main {

  /**
   * This is the main function.
   * @param args Does not take in any args.
   */
  public static void main(String[] args) {
    //All classes from the integration package being created.
	EISHandler eis = new EISHandler();
	EASHandler eas = new EASHandler();
	Printer printer = new Printer();
	DCHandler dc = new DCHandler();

	//The controller class and view class being created.
	Controller contr = new Controller(eis, eas, printer, dc);
	View view = new View(contr);

	view.runFakeExecution();


  }

}

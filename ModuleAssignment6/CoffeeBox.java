// package bagelHouse;

import javafx.scene.control.RadioButton;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TitledPane;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;

/**
 * This will be a VBox that contains a TitledPane which contains
 * another VBox that holds radio buttons for bagels
 * 
 * @author Jack
 *
 */
public class CoffeeBox extends VBox {
	// The following constants are used to indicate
	// the cost of each type of bagel.
	public final double CREAM_CHEESE = 0.5;
	public final double BUTTER = 0.25;
	public final double PEACH_JELLY = 0.75;
	public final double BLUEBERRY_JAM = 0.75;

	// The following variables will reference radio
	// buttons for white and whole wheat bagels.
	private RadioButton cbNone;
	private RadioButton cbRegular;
	private RadioButton cbDecaf;
	private RadioButton cbCappuccino;
	

	// The following variable will reference a
	// ToggleGroup object to group the radio buttons.
	private ToggleGroup tg;

	/**
	 *  Constructor
	 */
	public ToppingBox()  {

		// Create group for the radio buttons.
		tg = new ToggleGroup();

		// Create the radio buttons.

        cbNone = new RadioButton("None");
        cbRegular = new RadioButton("Regular Coffee");
        cbDecaf = new RadioButton("Decaf Coffee");
        cbCappuccino = new RadioButton("Cappuccino");

	

        //create toggle group
        cbNone.setToggleGroup(tg);
		cbRegular.setToggleGroup(tg);
        cbDecaf.setToggleGroup(tg);
        cbCappuccino.setToggleGroup(tg);
		cbNone.setSelected(true);

		// Make another VBox to hold the radio buttons.
		VBox vbox = new VBox(10);  // with 10 pixel spacing
		vbox.setStyle("-fx-background-color: BlanchedAlmond;");
		this.setStyle("-fx-background-color: BlanchedAlmond;");  // so outer VBox same color
		vbox.getChildren().add(cbNone);
		vbox.getChildren().add(cbRegular);
		vbox.getChildren().add(cbDecaf);
		vbox.getChildren().add(cbCappuccino);



		// Make a TitledPane to hold the VBox of radio buttons
		TitledPane tp = new TitledPane("Toppings", vbox);
		tp.setCollapsible(false);
		this.getChildren().add(tp); // add the titled pane to this VBox
	}

	/**
	 *  The getBagelCost method returns the cost of
	 *  the selected bagel.
	 */
	public double getToppingCost()
	{
		// // The following variable will hold the cost
		// // of the selected bagel.
		// double bagelCost = 0.0;

		// // Determine which bagel is selected.
		// if (rdoWhite.isSelected())
		// 	bagelCost = WHITE_BAGEL;
		// else
		// 	bagelCost = WHEAT_BAGEL;

		// // Return the cost of the selected bagel.
		// return bagelCost;
	}
}

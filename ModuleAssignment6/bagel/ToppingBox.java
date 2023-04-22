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
public class ToppingBox extends VBox {
	// The following constants are used to indicate
	// the cost of each type of bagel.
	public final double CREAM_CHEESE = 0.5;
	public final double BUTTER = 0.25;
	public final double PEACH_JELLY = 0.75;
	public final double BLUEBERRY_JAM = 0.75;

	// The following variables will reference radio
	// buttons for white and whole wheat bagels.
	private CheckBox cbCreamCheese;
	private CheckBox cbButter;
	private CheckBox cbPeachJelly;
	private CheckBox cbBlueberryjam;
	

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
		cbCreamCheese = new CheckBox("Cream Cheese");
		cbButter = new CheckBox("Butter");
                cbPeachJelly = new CheckBox("Peach Jelly");
                cbBlueberryjam = new CheckBox("Blueberry Jam");
               
              
		// Make another VBox to hold the radio buttons.
		VBox vbox = new VBox(10);  // with 10 pixel spacing
		vbox.setStyle("-fx-background-color: Moccasin;");
		this.setStyle("-fx-background-color: Moccasin;");  // so outer VBox same color
		vbox.getChildren().add(cbCreamCheese);
		vbox.getChildren().add(cbButter);
		vbox.getChildren().add(cbPeachJelly);
		vbox.getChildren().add(cbBlueberryjam);



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
		 double bagelCost = 0.0;

		// // Determine which bagel is selected.
		if (cbCreamCheese.isSelected()){bagelCost+=CREAM_CHEESE;}
		if (cbButter.isSelected()){bagelCost+=BUTTER;}
		if (cbPeachJelly.isSelected()){bagelCost+=PEACH_JELLY;}
		if (cbBlueberryjam.isSelected()){bagelCost+=BLUEBERRY_JAM;}
		
		 return bagelCost;
	}
}

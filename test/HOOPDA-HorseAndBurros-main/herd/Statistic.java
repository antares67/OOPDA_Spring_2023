package herd;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * A superclass to allow for future expansion in which additional forms
 * of statistics may be introduced.
 * 
 * @author myersjac
 * @author Christian Cipolletta
 */
public class Statistic implements Serializable {

    /**
	 * Serializes the instance of the Statistic to a file
	 * @param fileName The name of the file to be saved to
	 * @author Christian Cipolletta
	 */
	public void serialize(String fileName) {

		try (FileOutputStream fileOut = new FileOutputStream(fileName)) {
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(this);
			out.close();
			fileOut.close();
			System.out.printf("Serialized data for the statistic is saved in %s\n", 
                              fileName);
		} catch (IOException e) {
				System.out.println(e.getMessage());
		}
	}

	/**
	 * Deserializes the instance of the Statistic stored in a file
     * @param fileName The name of the file to be read
	 * @return The deserialized StateStatistic.
	 * @throws StatisticDataNotFoundException
     * @author Christian Cipolletta
	 */
	public static Statistic deserialize(String fileName) throws StatisticDataNotFoundException {

		Statistic statistic = null;
		FileInputStream fileIn = null;
		ObjectInputStream in = null;

		try {
			fileIn = new FileInputStream(fileName);
			in = new ObjectInputStream(fileIn);
			statistic = (Statistic) in.readObject();
			in.close();
			fileIn.close();
			System.out.println("Deserializing Statistic in " + fileName);
		} catch (FileNotFoundException f) {
			throw new StatisticDataNotFoundException(fileName);
		} catch (ClassNotFoundException c) {
			System.out.println("The target StateStatistic has a different version ID.");
			c.printStackTrace();
		} catch (Exception e) {
			System.out.println(e.getClass().getSimpleName() + 
					": " + e.getMessage() + "\n");
		} 
		return statistic;
	}
}
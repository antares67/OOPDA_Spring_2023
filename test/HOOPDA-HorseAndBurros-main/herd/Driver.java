package herd;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

/**
 * Class to run the Horses and Burros Lab
 * 
 * @author Christian Cipolletta
 */
public class Driver {
    public static void main(String[] args) 
    {
        /** Instance of the dataSet class **/
        DataSet dataSet = new DataSet();
        /** Instance of Random to choose a random statistic to serialize **/
        Random rand = new Random();
        /** The file with the data to be added to the dataSet **/
        String DATA_FILE = "herdManagement.csv";
        /** The file to hold the serialized data of the random statistic **/
        String SERIALIZATION_FILE = "StateStatistic.ser";

        loadStatistics(dataSet, DATA_FILE, 2);
        displayStatistics(dataSet);
        Statistic randStat = dataSet.getStats().get(rand.nextInt(dataSet.getStats().size()));
        randStat.serialize(SERIALIZATION_FILE);
        try {
            dataSet.addStatistic(Statistic.deserialize(SERIALIZATION_FILE));
        } catch (StatisticDataNotFoundException e) {
            e.printStackTrace();
        }
        Statistic deserializedStatistic = dataSet.getStats().get(dataSet.getStats().size() - 1);
        System.out.println(deserializedStatistic);

        // Tests for robustness
        String testName = "Poopy.lol";
        DataSet testSet = new DataSet();
        loadStatistics(testSet, testName, 100);
        try {
            Statistic.deserialize("Poopy.fake");
        } catch (StatisticDataNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("The code did not fail.");
    }

    /**
     * Method to load statistics from a specified file into a specified data set.
     * @param dataSet The data set the statistics will be loaded into
     * @param fileName The name of the file that holds the statistics
     * @param numHeaderRows The number of header rows (rows with that don't have statistics)
     */
    public static void loadStatistics(DataSet dataSet, String fileName, int numHeaderRows)
    {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line = reader.readLine();
            int linesRead = 0;
            String delims = "[,]";
            while(line != null) {
                linesRead++;
                line = reader.readLine();
                if(linesRead > numHeaderRows && line != null)
                {
                    String[] data = line.split(delims);
                    StateStatistic stateStatistic = new StateStatistic(State.valueOf(data[0].toUpperCase()),
                                                                    Long.parseLong(data[1]),
                                                                    Long.parseLong(data[2]),
                                                                    Long.parseLong(data[3]),
                                                                    Long.parseLong(data[3]),
                                                                    Long.parseLong(data[5]),
                                                                    Long.parseLong(data[6]));
                    dataSet.addStatistic(stateStatistic);
                }
            }
            reader.close();
        } catch(FileNotFoundException e) {
            System.out.println("\nThat file could not be found.");
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Displays each statistic in a data set in their own row
     * @param dataSet The data set to be displayed
     */
    public static void displayStatistics(DataSet dataSet)
    {
        dataSet.getStats().forEach(stat -> System.out.println(stat));
        
    }
}

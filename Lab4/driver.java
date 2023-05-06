import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.nio.Buffer;
import java.util.Random;
import java.io.FileReader;
import java.io.Reader;
import java.io.IOException;

public class driver {

    static State STATE;
    static Long HERD_AREA_BLM;
    static Long HERD_AREA_OTHER;
    static Long HERD_MANAGEMENT_BLM;
    static Long HERD_MANAGEMENT_OTHER;
    static Long numHorses;
    static Long numBurros;

    /**Main function with custom exception */
    public static void main(String args[]) throws StatisticDataNotFoundException{
        
        /**
         * Create file variables
         */
        String csvFile = "herdManagement.csv";
        String serFile = "savedData.ser";
        /**
         * Create dataset and random object
         */
        DataSet dataset = new DataSet();
        Random random = new Random();

        /**Call load and display statistics */
        loadStatistics(dataset, csvFile, 3);
        displayStatistics(dataset);

        /**Create and get random statistic */
        Statistic randStat = dataset.getStats().get(random.nextInt(dataset.getStats().size()));
        /**Serialize random statistic */
        randStat.serializeObject(serFile);
        /**Deserialize statistic from .ser file and save it to dataset*/
        dataset.addStatistic(Statistic.deserializeObject(serFile));
        /**Get deserialized data and store it */
        Statistic deserializedStatistic = dataset.getStats().get(dataset.getStats().size() - 1);
        System.out.println("Serialized / Deserialized Statistic: ");
        System.out.println(deserializedStatistic);
        //System.out.println("Test failure file: ");

    }

    
    /**Pull statistics data from csv file and stres it to dataset, accounts for header rows */
 public static void loadStatistics(DataSet dataset, String filename, int headerRows){
        try (BufferedReader br = new BufferedReader(new FileReader("herdManagement.csv"))) {
            String[] fields = {};
            String thisLine;
            int thisRow = 0;
            while ((thisLine = br.readLine()) != null) {
                // System.out.println(thisLine);  // echo lines to console
                thisRow++;
                if(thisRow > headerRows){
                    fields = thisLine.split(",");  // split into fields
                    STATE = State.valueOf(fields[0]);
                    HERD_AREA_BLM = Long.parseLong(fields[1]);
                    HERD_AREA_OTHER = Long.parseLong(fields[2]);
                    HERD_MANAGEMENT_BLM = Long.parseLong(fields[3]);
                    HERD_MANAGEMENT_OTHER = Long.parseLong(fields[4]);
                    numHorses = Long.parseLong(fields[5]);
                    numBurros = Long.parseLong(fields[6]);
                    StateStatistic statParse = new StateStatistic(STATE, HERD_AREA_BLM, HERD_AREA_OTHER, HERD_AREA_OTHER, HERD_MANAGEMENT_BLM, numHorses, numBurros);
                    dataset.addStatistic(statParse);
                    // System.out.println(fields);
                }
            }

            
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        
        }catch(IOException e){
            e.printStackTrace();
        }
        
    
    }
    /**Displays statistics by passing each statistic into foreach and printing to console */
    public static void displayStatistics(DataSet dataset){
        dataset.getStats().forEach(stat -> System.out.println(stat));
    }
}

import java.io.FileNotFoundException;
import java.time.LocalDate;

public class StatisticDataNotFoundException extends FileNotFoundException{

    private String attemptedName;
    private LocalDate timestamp;

    /**
     * Exception for when a data file is not located
     * @param attemptedName
     */
    public StatisticDataNotFoundException(String attemptedName){

        super("The file " + attemptedName + " does not exist. Timestamp: " + LocalDate.now());
		this.attemptedName = attemptedName;
        this.timestamp = LocalDate.now();
    }

    public String getAttemptedName() {
        return attemptedName;
    }

    public void setAttemptedName(String attemptedName) {
        this.attemptedName = attemptedName;
    }

    public LocalDate getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDate timestamp) {
        this.timestamp = timestamp;
    }
}

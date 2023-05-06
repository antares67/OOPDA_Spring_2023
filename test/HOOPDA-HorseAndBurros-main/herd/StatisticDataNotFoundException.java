package herd;

import java.time.LocalDate;
import java.io.FileNotFoundException;

/**
 * Custom exception to be used when a serialized statistic file cannot be found.
 * Holds the name of the file that was tried and the time it failed to open.
 * 
 * @author Christian Cipolletta
 */
public class StatisticDataNotFoundException extends FileNotFoundException {
    
    /** The name of the file that was attempted to open **/
	private String fileNameTried;
    /**  The time that the file was attempted to open **/
    private LocalDate timeStamp;

    /**
     * Creates an instance of the exception with a specific file name.
     * Saves the time it was created.
     * 
     * @param fileNameTried The name of the file tried to open
     */
    public StatisticDataNotFoundException(String fileNameTried)
    {
        super("The file " + fileNameTried + " does not exist. Failed at " + LocalDate.now());
        if(fileNameTried != null) {
		    this.fileNameTried = fileNameTried;
        }
        else {
            System.out.println("The input file name tried is null.");
        }
        this.timeStamp = LocalDate.now();
    }

    /**
     * Standard accessor for fileNameTried
     * @return The file name tried
     */
	public String getFileNameTried() {
		return fileNameTried;
	}

    /**
     * Standard mutator for FileNameTried
     * @param fileNameTried The name of the file that was attempted to open
     */
	public void setFileNameTried(String fileNameTried) {
        if(fileNameTried != null) {
		    this.fileNameTried = fileNameTried;
        }
        else {
            System.out.println("The input file name tried is null.");
        }
	}

    /**
     * Standard accessor for time stamp
     * @return The time stamp of the exception
     */
    public LocalDate getTimeStamp() {
        return timeStamp;
    }

    /**
     * Standard mutator for the time stamp
     * @param timeStamp The time stamp fo the exception
     */
    public void setTimeStamp(LocalDate timeStamp) {
        if(timeStamp != null) {
            this.timeStamp = timeStamp;
        }
        else {
            System.out.println("The input time stamp is null.");
        }
    }
}

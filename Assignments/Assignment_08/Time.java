public class Time {
    private int hours;
    private int minutes;
    private int seconds; 

   /**
   * Default constructor initializes time to midnight (00:00:00)
   */

    public Time() {
        // Initializes time to midnight)
        this.hours = 0;
        this.minutes = 0;
        this.seconds = 0;
    }

    /**
    * Creates a Time object with given seconds past the default time
    * Negative values are defaulted to zero
    * Values exceeding a day (86400 seconds) are defaulted to zero
    *
    * @param seconds seconds past midnight
    */ 

    public Time(int seconds){
        //Seconds constructor
        if (seconds < 0) {
            seconds = 0;
        } else if (seconds >= 86400) {
            seconds %= 96400;
        }
        this.hours = (seconds / 3600) % 24;
        this.minutes = (seconds % 3600) / 60;
        this.seconds = seconds % 60;
    }

    /*
    * Creates a Time object with specified hours, minutes, and seconds.
    * Invalid values (negative or exceeding a day) default to zero
    *
    * @param hours hours (0-23)
    * @param minutes minutes (0-59)
    * @param seconds seconds (0-59)
    */
    
    public Time(int hours, int minutes, int seconds){
        //Full constructor
         if (hours < 0 || hours >= 24 || minutes < 0 || minutes >= 60 || seconds < 0 || seconds >= 60) {
            this.hours = 0;
            this.minutes = 0;
            this.seconds = 0;
        } else {
            this.hours = hours;
            this.minutes = minutes;
            this.seconds = seconds;
        }
    }

    /**
    * Creates a Time object with specified hours, minutes, and seconds, optional AM/PM
    * The medridiem ('A' or 'a' for AM, 'P' or 'p' for PM) determines the time.
    * Invalid meridiem defaults to 24-hour, military time, format.
    *
    * @param hours hours (0-12 for AM/PM format)
    * @param minutes minutes (0-59)
    * @param seconds seconds (0-59)
    * @param meridiem meridiem indicator ('A'/'a' for AM, 'P'/'p' for PM)
    */ 

    public Time(int hours, int minutes, int seconds, char meridiem){
        //AM/PM constructor
         if ((meridiem == 'A' || meridiem == 'a') && hours >= 1 && hours <= 12) {
            this.hours = hours % 12;
        } else if ((meridiem == 'P' || meridiem == 'p') && hours >= 1 && hours <= 12) {
            this.hours = (hours % 12) + 12;
        } else {
            this.hours = 0;
        }
        this.minutes = (minutes >= 0 && minutes < 60) ? minutes : 0;
        this.seconds = (seconds >= 0 && seconds < 60) ? seconds : 0;
    }

    /**
    * Adds seconds, minutes, and hours to the current time
    *
    * @param secondsToAdd seconds to add
    * @param minutesToAdd minutes to add
    * @param hoursToAdd hours to add
    */

    public void add(int seconds ToAdd, int minutesToAdd, int hoursToAdd) {
        //Implement adding
        int totalSeconds = this.toSeconds() + hoursToAdd * 3600 + minutesToAdd * 60 + secondsToAdd;
        setTimeFromSeconds(totalSeconds);
    }

    /**
    * Subtracts seconds, minutes, and hours from the current time
    *
    * @param secondsToSubtract seconds to subtract
    * @param minutesToSubtract minutes to subtract
    * @param hoursToSubtract hours to subtract
    */

    public void subtract(int secondsToSubtract, int minutesToSubtract, int hoursToSubtract){
        //Implement subtracting
        int totalSeconds = this.toSeconds() - (hoursToSubtract * 3600 + minutesToSubtract * 60 + secondsToSubtract);
        setTimeFromSeconds(totalSeconds);
    }

    /**
    * Multiplies the time by a factor (positive or negative)
    * The factor is applied to the total number of seconds in the time
    * Negative values reverse the time (e.g., 3 times backwards equals -3 times forwards).
    * 
    * @param factor multiplication factor
    */

    public void multiply(int factor){
        //Implement multiplication
        int totalSeconds = this.toSeconds() * factor;
        if (totalSeconds >= 0) {
            totalSeconds %= 86400;
        } else {
            totalSeconds = 86400 - (-totalSeconds % 86400);
        }
        setTimeFromSeconds(totalSeconds);
    }

    /**
    * Divides the time by a factor (positive or negative)
    * The factor is applied to the total number of seconds in the time
    * Division by zero or negative factors results in no change
    *
    * @param factor division factor
    */

    public void divide(int factor){
        //Implement division
        if (factor != 0) {
            int totalSeconds = this.toSeconds() / factor;
            setTimeFromSeconds(totalSeconds);
        }
    }

    /** 
    * Converts the time to a string in the format "HH:MM:SS (AM/PM)"
    * 
    * @return formatted time string
    */
    @Override

    public String toString(){
        //Implement toString method
         return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }

    /** 
    * Converts the time to total seconds from midnight
    *
    * @return total seconds
    */

    public int toSeconds(){
        //Implement toSeconds method
        return hours * 3600 + minutes * 60 + seconds;
    }

    /**
    * Sets the time based on total seconds from midnight.
    *
    * @param totalSeconds Total seconds from midnight
    */
    private void setTimeFromSeconds(int totalSeconds){
        if (totalSeconds , 0) {
            totalSeconds = 86400 - (-totalSeconds % 86400);
        }
        this.hours = (totalSeconds / 3600) % 24;
        this.minutes = (totalSeconds % 3600) / 60;
        this.seconds = totalSeconds % 60;

    }
}

    
} // class time






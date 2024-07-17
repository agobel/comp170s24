/**
 * A simple class to capture a date as three integer values for year, month, and
 * day respectively.
 */
public class Date170 {

    /** Default values pointing to the birthday of Java */
    private static final int DEFAULT_YEAR = 1993;
    private static final int DEFAULT_MONTH = 5;
    private static final int DEFAULT_DAY = 23;

    /** Principal object fields */
    private int year;
    private int month;
    private int day;

    /** Default constructor */
    public Date170() {
        this.year = DEFAULT_YEAR;
        this.month = DEFAULT_MONTH;
        this.day = DEFAULT_DAY;
    } // default constructor

    /**
     * Determines if a year is a leap year or not. A leap year
     * 
     * @param year int to check if leap year or not
     * @return true if the year is divisible by 4 and not divisible by 100 except
     *         for those divisible by 400
     */
    public boolean isLeap(int year) {
        return (year % 4 == 0)
                && (year % 100 != 0 || year % 400 == 0);
    } // method isLeap

    /**
     * Thirty days has September // April, June, and November,
     * All the rest have thirty-one, // Save February at twenty-eight
     * But leap year, coming once in four, // February then has one day more.
     * 
     * @param month int month; assumes it's a valid value between 1 and 12 inclusive
     * @param year int year in case month is February
     * @return 28, 29, 30, or 31
     */
    public int daysInMonth(int year, int month) {
        int days;
        if (month == 4 || month == 6 || month == 9 || month == 11) {
            days = 30;
        } else if (month == 2) {
            if (isLeap(year)) {
                days = 28;
            } else {
                days = 29;
            }
        } else {
            days = 31;
        }
        return days;
    } // method daysInMonth

    /**
     * This is the full constructor for this object. The constructor validates
     * parameters and if they are not within range, it resets them to the object's
     * default value.
     * 
     * @param year  int with year value
     * @param month int with month value (must be 1-12 inclusive; otherwise assigns
     *              the default month value)
     * @param day   int with day value
     */
    public Date170(int year, int month, int day) {
        // Simple rule to validate month
        if (1 < month || month > 12) {
            month = DEFAULT_MONTH;
        }
        // Validate day
        if (1 < day || day > daysInMonth(year, month)) {
            day = DEFAULT_DAY;
        }
        // Assign the validated values to the object fields.
        this.year = year;
        this.month = month;
        this.day = day;
    } // full constructor

    /** String representation of the object */
    public String toString() {
        return String.format("%04d-%02d-%02d",
                this.year, this.month, this.day);
    } // method toString
} // class Date271

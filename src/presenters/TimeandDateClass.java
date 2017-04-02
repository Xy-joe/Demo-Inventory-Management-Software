package presenters;

import javax.swing.*;
import java.util.Date;

public class TimeandDateClass {

    JTextPane pane;
    public String output;
    public String date;
    public TimeandDateClass() {
        // Obtain the total milliseconds since the midnight, Jan 1, 1970
        long totalMilliseconds = System.currentTimeMillis();


// Obtain the total seconds since the midnight, Jan 1, 1970

        long totalSeconds = totalMilliseconds / 1000;

// Compute the current second in the minute in the hour

        int currentSecond = (int) (totalSeconds % 60);

// Obtain the total minutes

        long totalMinutes = totalSeconds / 60;

// Compute the current minute in the hour

        int currentMinute = (int) (totalMinutes % 60);

// Obtain the total hours

        long totalHours = totalMinutes / 60;

// Compute the current hour

        int currentHour = (int) (totalHours % 24);

// Display results

         output =  currentHour + ":"

                + currentMinute + ":" + currentSecond;
        // Display Current Date
        Date data= new Date();
        date = data.toString();
    }
}
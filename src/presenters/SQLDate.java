package presenters;

import org.jdatepicker.AbstractDateModel;
import org.jdatepicker.DateModel;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Properties;

/**
 * Created by joebuntu on 4/6/17.
 */
public class SQLDate extends JPanel implements ActionListener {
UtilDateModel model;
    JDatePanelImpl datePanel;
  public  JDatePickerImpl datePicker;
    String dd;
    Properties properties;
    public SQLDate() {

        model = new UtilDateModel();
        properties = new Properties();
        properties.put("text.today", "Today");
        properties.put("text.month", "Month");
        properties.put("text.year", "Year");
        model.setDate(2017,6,5);
        datePanel = new JDatePanelImpl(model,properties);
        datePicker = new JDatePickerImpl(datePanel, new DateFormatter());
        datePicker.getJFormattedTextField().setBackground(Color.WHITE);
        datePicker.getJFormattedTextField().setFont(new Font("Liberation Serif", Font.PLAIN,  13));
        setBackground(Color.decode("#BBDEFB"));
        add(datePicker);

}

    @Override
    public void actionPerformed(ActionEvent e) {

//Window clax = SwingUtilities.getWindowAncestor()

    }
    public String getDAte(){
        return datePicker.getJFormattedTextField().getText();
    }
}

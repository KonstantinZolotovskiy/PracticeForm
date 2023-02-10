package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    private SimpleDateFormat formatter;

    public String getFormattedDate(Date date) {
        formatter = new SimpleDateFormat("dd MMM yyyy");
        return formatter.format(date);
    }

    public String getFormattedDateForCheck(Date date) {
        formatter = new SimpleDateFormat("dd MMMM,yyyy");
        return formatter.format(date);
    }
}

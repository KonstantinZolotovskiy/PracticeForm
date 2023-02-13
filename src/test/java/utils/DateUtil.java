package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    public String getFormattedDate(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd MMMM yyyy");
        return formatter.format(date);
    }
}

package date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateFormatTest {
    public static void main(String[] args) {
        String string1 = "2011-11-11 11:11:11:111";
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        String string = simpleDateFormat.format(date);
        System.out.println(string);
        Date date1 = null;
        try {
            date1 = simpleDateFormat.parse(string1);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(date1);
    }
}

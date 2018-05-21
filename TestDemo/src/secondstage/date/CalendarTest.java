package date;

import java.util.Calendar;

public class CalendarTest {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(calendar.get(Calendar.YEAR)).append("-");
        stringBuffer.append(calendar.get(Calendar.MONTH)).append("-");
        stringBuffer.append(calendar.get(Calendar.DAY_OF_MONTH)).append(" ");
        stringBuffer.append(calendar.get(Calendar.HOUR_OF_DAY)).append(":");
        stringBuffer.append(calendar.get(Calendar.MINUTE)).append(":");
        stringBuffer.append(calendar.get(Calendar.SECOND));


        System.out.println(stringBuffer);
    }
}

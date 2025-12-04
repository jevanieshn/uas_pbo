import java.util.ArrayList;

public class InitBooking {

    // static so callers can use InitBooking.bookingList and InitBooking.load()
    public static ArrayList<Booking> bookingList = new ArrayList<>();

    public static void load() {
        bookingList.clear();
    }
}
import java.util.ArrayList;

public class InitKamar {

    public static ArrayList<Kamar> kamarList = new ArrayList<>();

    public static void load() {
        kamarList.clear();
        kamarList.add(new Kamar("K001", "Standar", 200000, "kosong"));
        kamarList.add(new Kamar("K002", "Premium", 300000, "kosong"));
    }
}
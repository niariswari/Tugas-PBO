import java.util.ArrayList;

public class RentalKendaraan {
    private ArrayList<Kendaraan> kendaraanList = new ArrayList<>();
    private ArrayList<Penyewa> penyewaList = new ArrayList<>();

    public void tambahKendaraan(Kendaraan k) {
        kendaraanList.add(k);
    }

    public void tambahPenyewa(Penyewa p) {
        penyewaList.add(p);
    }

    public void tampilkanKendaraan() {
        if (kendaraanList.isEmpty()) {
            System.out.println("Tidak ada kendaraan yang tersedia.");
        } else {
            for (int i = 0; i < kendaraanList.size(); i++) {
                Kendaraan k = kendaraanList.get(i);
                System.out.println((i + 1) + ". " + k.getJenis() + " - " + k.getInfo());
            }
        }
    }

    public void tampilkanPenyewa() {
        if (penyewaList.isEmpty()) {
            System.out.println("Tidak ada penyewa.");
        } else {
            for (Penyewa penyewa : penyewaList) {
                System.out.println(penyewa.getInfo());
            }
        }
    }

    public Kendaraan getKendaraan(int index) {
        if (index > 0 && index <= kendaraanList.size()) {
            return kendaraanList.get(index - 1);
        } else {
            return null;
        }
    }
}

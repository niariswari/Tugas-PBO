abstract class Kendaraan {
    protected int biayaPerJam;

    public abstract void setBiayaPerJam();

    public int getBiayaPerJam() {
        return biayaPerJam;
    }

    public int hitungBiaya(int lamaParkir) {
        if (lamaParkir == 0) {
            return 0; 
        }
        
        int totalBiaya = biayaPerJam; 
        
        if (lamaParkir > 1) {
            totalBiaya += (lamaParkir - 1) * getBiayaPerJam();
        }
        
        return totalBiaya;
    }
}
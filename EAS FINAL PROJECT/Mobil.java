class Mobil extends Kendaraan {
    @Override
    public void setBiayaPerJam() {
        biayaPerJam = 1500; 
    }

    @Override
    public int hitungBiaya(int lamaParkir) {
        int totalBiaya = 0;

        if (lamaParkir > 0) {
            totalBiaya = 5000;
            
            if (lamaParkir > 1) {
                totalBiaya += (lamaParkir - 1) * 1500;
            }
        }
        
        return totalBiaya;
    }
}
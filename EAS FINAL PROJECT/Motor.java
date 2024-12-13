class Motor extends Kendaraan {
    @Override
    public void setBiayaPerJam() {
        biayaPerJam = 1000; 
    }

    @Override
    public int hitungBiaya(int lamaParkir) {
        int totalBiaya = 0;

        if (lamaParkir > 0) {
            totalBiaya = 3000; 
            
            if (lamaParkir > 1) {
                totalBiaya += (lamaParkir - 1) * 1000;
            }
        }
        
        return totalBiaya;
    }
}
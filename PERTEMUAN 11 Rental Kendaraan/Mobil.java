public class Mobil extends Kendaraan {
    private int jumlahRoda;

    public Mobil(String merk, String model, int tahun) {
        super(merk, model, tahun);
        this.jumlahRoda = 4;  
    }
    
    @Override
    public String getJenis() {
        return "Mobil"; 
    }
    
    @Override
    public String getInfo() {
        return super.getInfo() + ", Jumlah Roda: " + jumlahRoda;
    }
}

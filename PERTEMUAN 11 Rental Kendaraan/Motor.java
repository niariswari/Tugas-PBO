public class Motor extends Kendaraan {
    private int jumlahRoda;

    public Motor(String merk, String model, int tahun) {
        super(merk, model, tahun);
        this.jumlahRoda = 2;  
    }
    
    @Override
    public String getJenis() {
        return "Motor"; 
    }
    
    public String getInfo() {
        return super.getInfo() + ", Jumlah Roda: " + jumlahRoda;
    }
}

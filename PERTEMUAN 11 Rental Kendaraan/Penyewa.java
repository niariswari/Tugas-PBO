public class Penyewa {
    private String nama;
    private Kendaraan kendaraan;
    
    public Penyewa(String nama, Kendaraan kendaraan) {
        this.nama = nama;
        this.kendaraan = kendaraan;
    }
    
    public String getInfo() {
        return "Nama Penyewa: " + nama + ", Info Kendaraan: [" + kendaraan.getInfo() + "]";
    }
}

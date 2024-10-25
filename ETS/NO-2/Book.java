class Book {
    private String judul;
    private String penulis;
    private int tahunTerbit;
    private String namaPenerbit;
    private String kategori;

    public Book(String judul, String penulis, int tahunTerbit, String namaPenerbit, String kategori) {
        this.judul = judul;
        this.penulis = penulis;
        this.tahunTerbit = tahunTerbit;
        this.namaPenerbit = namaPenerbit;
        this.kategori = kategori;
    }

    public void printDetails() {
        System.out.println("Judul: " + judul);
        System.out.println("Penulis: " + penulis);
        System.out.println("Tahun Terbit: " + tahunTerbit);
        System.out.println("Nama Penerbit: " + namaPenerbit);
        System.out.println("Kategori: " + kategori);
    }
}
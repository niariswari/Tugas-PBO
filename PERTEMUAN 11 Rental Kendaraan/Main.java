import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        RentalKendaraan rental = new RentalKendaraan();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Tambah Kendaraan");
            System.out.println("2. Tambah Penyewa");
            System.out.println("3. Tampilkan Daftar Kendaraan");
            System.out.println("4. Tampilkan Daftar Penyewa");
            System.out.println("5. Keluar");
            System.out.print("Pilih opsi: ");
            int pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1:
                    System.out.print("Jenis Kendaraan (Mobil/Motor/Sepeda): ");
                    String jenis = scanner.nextLine();

                    if (!(jenis.equalsIgnoreCase("Mobil") || jenis.equalsIgnoreCase("Motor") || jenis.equalsIgnoreCase("Sepeda"))) {
                        System.out.println("Jenis kendaraan tidak valid!");
                        return;
                    }

                    System.out.print("Merk: ");
                    String merk = scanner.nextLine();
                    System.out.print("Model: ");
                    String model = scanner.nextLine();
                    System.out.print("Tahun Produksi: ");
                    int tahun = scanner.nextInt();
                    scanner.nextLine();

                    if (jenis.equalsIgnoreCase("Mobil")) {
                        rental.tambahKendaraan(new Mobil(merk, model, tahun));
                    } else if (jenis.equalsIgnoreCase("Motor")) {
                        rental.tambahKendaraan(new Motor(merk, model, tahun));
                    } else if (jenis.equalsIgnoreCase("Sepeda")) {
                        System.out.print("Jenis Sepeda (BMX/Balap): ");
                        String jenisSepeda = scanner.nextLine();
                        rental.tambahKendaraan(new Sepeda(merk, model, tahun, jenisSepeda));
                    }
                    break;

                case 2:
                    System.out.print("Nama Penyewa: ");
                    String nama = scanner.nextLine();
                    System.out.println("Kendaraan yang disewa (masukkan nomor index dari daftar kendaraan): ");
                    rental.tampilkanKendaraan();
                    System.out.print("Pilihan index: ");
                    int index = scanner.nextInt();
                    scanner.nextLine();
                    Kendaraan kendaraan = rental.getKendaraan(index);
                    if (kendaraan != null) {
                        rental.tambahPenyewa(new Penyewa(nama, kendaraan));
                    } else {
                        System.out.println("Index kendaraan tidak valid!");
                    }
                    break;

                case 3:
                    rental.tampilkanKendaraan();
                    break;

                case 4:
                    rental.tampilkanPenyewa();
                    break;

                case 5:
                    System.out.println("Keluar dari program.");
                    return;

                default:
                    System.out.println("Pilihan tidak valid!");
            }
        }
    }
}

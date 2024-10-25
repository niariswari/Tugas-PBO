import java.util.ArrayList;
import java.util.Scanner;

public class BookManager {
    private ArrayList<Book> books;
    private Scanner scanner;

    public BookManager() {
        books = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void showMenu() {
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Tambah Buku");
            System.out.println("2. Tampilkan Detail Buku");
            System.out.println("3. Keluar");
            System.out.print("Pilih opsi: ");
            int pilihan = scanner.nextInt();
            scanner.nextLine();  

            switch (pilihan) {
                case 1:
                    tambahBuku();
                    break;
                case 2:
                    tampilkanDetailBuku();
                    break;
                case 3:
                    System.out.println("Terima kasih! Program selesai.");
                    return;
                default:
                    System.out.println("Opsi tidak valid. Silakan coba lagi.");
            }
        }
    }

    private void tambahBuku() {
        System.out.print("Masukkan judul buku: ");
        String judul = scanner.nextLine();
        System.out.print("Masukkan penulis: ");
        String penulis = scanner.nextLine();
        System.out.print("Masukkan tahun terbit: ");
        int tahunTerbit = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Masukkan nama penerbit: ");
        String namaPenerbit = scanner.nextLine();
        System.out.print("Masukkan kategori buku: ");
        String kategori = scanner.nextLine();

        Book bukuBaru = new Book(judul, penulis, tahunTerbit, namaPenerbit, kategori);
        books.add(bukuBaru);
        System.out.println("Buku berhasil ditambahkan.");
    }

    private void tampilkanDetailBuku() {
        if (books.isEmpty()) {
            System.out.println("Belum ada buku yang ditambahkan.");
            return;
        }

        for (int i = 0; i < books.size(); i++) {
            System.out.println("\nBuku " + (i + 1) + ":");
            books.get(i).printDetails();
        }
    }

    public static void main(String[] args) {
        BookManager bookManager = new BookManager();
        bookManager.showMenu();
    }
}

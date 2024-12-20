public class Main {
    public static void main(String[] args) {
        MakhlukHidup manusia = new Manusia();
        MakhlukHidup hewan = new Hewan();
        MakhlukHidup tumbuhan = new Tumbuhan();

        System.out.println("\nManusia:");
        manusia.hidup();
        manusia.bernapas();
        manusia.berkembangbiak();

        System.out.println("\nHewan:");
        manusia.hidup();
        hewan.bernapas();
        hewan.berkembangbiak();

        System.out.println("\nTumbuhan:");
        manusia.hidup();
        tumbuhan.bernapas();
        tumbuhan.berkembangbiak();
    }
}

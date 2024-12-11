package RestoranApp.views;

import RestoranApp.entities.Pesanan;
import RestoranApp.service.PesananServiceInterface;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class PesananView implements PesananViewInterface {
    private final PesananServiceInterface pesananService;

    public PesananView(PesananServiceInterface pesananService) {
        this.pesananService = pesananService;
    }

    @Override
    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        int pilihan;
        do {
            System.out.println("\n=== Menu Pesanan ===");
            System.out.println("1. Buat Pesanan");
            System.out.println("2. Lihat Semua Pesanan");
            System.out.println("3. Update Pesanan");
            System.out.println("4. Hapus Pesanan");
            System.out.println("5. Keluar");
            System.out.print("Masukkan pilihan: ");
            pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1:
                    buatPesanan(scanner);
                    break;
                case 2:
                    ();
                    break;
                case 3:
                    (scanner);
                    break;
                case 4:
                    (scanner);
                    break;
                case 5:
                    System.out.println("Terima kasih!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (pilihan != 5);
    }

    private void buatPesanan(Scanner scanner) {
        System.out.print("Masukkan nama pembeli: ");
        String namaPembeli = scanner.nextLine();
        System.out.print("Masukkan item pesanan: ");
        String item = scanner.nextLine();
        System.out.print("Masukkan jumlah: ");
        int kuantitas = scanner.nextInt();
        scanner.nextLine();

        pesananService.buatPesanan(namaPembeli, item, kuantitas);
    }
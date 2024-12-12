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
                    lihatPesanan();
                    break;
                case 3:
                    updatePesanan(scanner);
                    break;
                case 4:
                    hapusPesanan(scanner);
                    break;
                case 5:
                    System.out.println("Terima kasih!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (pilihan != 5);
    }

    public static void DaftarMenu(){    //dibuat oleh Poda tanggal 12/12/2024 jam 07.44
        System.out.println("Daftar Menu Restoran Mandalika");
        System.out.println("====== Daftar Makanan ======");
        System.out.println("1.Nasi                  Rp.5000");
        System.out.println("2.Ayam Panggang         Rp.10.000");
        System.out.println("3.Ayam Goreng           Rp.8.000");
        System.out.println("4.Gulai Tunjang         Rp.15.000");
        System.out.println("5.Telor Balado          Rp.10.000");
        System.out.println("====== Daftar Minuman =======");
        System.out.println("1.Air Putih             Rp.3000");
        System.out.println("2.Teh Manis Dingin      Rp.5000");
        System.out.println("3.Es Jeruk              Rp.6000");
        System.out.println("4.Aneka Jus             Rp.12.000");
        System.out.println("5.Es krim               Rp.5000");
    }

    private void buatPesanan(Scanner scanner) {
        DaftarMenu();
        System.out.print("Masukkan nama pembeli: ");
        String namaPembeli = scanner.nextLine();
        System.out.print("Masukkan item pesanan: ");
        String item = scanner.nextLine();
        System.out.print("Masukkan jumlah: ");
        int kuantitas = scanner.nextInt();
        scanner.nextLine();

        pesananService.buatPesanan(namaPembeli, item, kuantitas);
    }
    private void lihatPesanan() {
        List<Pesanan> pesananList = pesananService.lihatSemuaPesanan();
        if (pesananList.isEmpty()) {
            System.out.println("Tidak ada pesanan.");
        } else {
            for (int i = 0; i < pesananList.size(); i++) {
                System.out.println("[" + i + "] " + pesananList.get(i));
            }
        }
    }

    private void updatePesanan(Scanner scanner) {
        lihatPesanan();
        System.out.print("Masukkan indeks pesanan yang ingin diperbarui: ");
        int index = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Masukkan nama pemesan baru: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan item baru: ");
        String item = scanner.nextLine();
        System.out.print("Masukkan kuantitas baru: ");
        int kuantitas = scanner.nextInt();
        scanner.nextLine();

        pesananService.updatePesanan(index, nama ,item, kuantitas,"Sedang di proses");
    }

    private void hapusPesanan(Scanner scanner) {
        lihatPesanan();
        System.out.print("Masukkan indeks pesanan yang ingin dihapus: ");
        int index = scanner.nextInt();
        scanner.nextLine();
        pesananService.hapusPesanan(index);
    }
}
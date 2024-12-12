package RestoranApp.views;

import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class TerminalView implements TerminalMenus{
    private PesananView pesananView;
    private PesananOnlineView pesananOnlineView;

    public TerminalView(PesananView pesananView, PesananOnlineView pesananOnlineView) {
        this.pesananView = pesananView;
        this.pesananOnlineView = pesananOnlineView;
    }

    @Override
    public void run() {
        int pilihan;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("\n=== Restoran Mandalika ===");
            System.out.println("1. Pembeli");
            System.out.println("2. Penjual");
            System.out.println("3. Keluar");
            System.out.print("Pilih peran: ");
            pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1:
                    System.out.println("Anda masuk sebagai Pembeli.");
                    pesananView.displayMenu();
                    break;
                case 2:
                    if (inputPenjual(scanner)) { //07.20 12 december oleh poda
                        pesananOnlineView.displayMenu();
                    } else {
                        System.out.println("Akses ditolak. Username atau password salah.");
                    }
                    break;
                case 3:
                    System.out.println("Terima kasih!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }while (pilihan != 3);
    }

    private static boolean cekUserNamePenjual(String username,int password){ //07.20 12 december oleh poda
        if (password == 1234){
            return username.equals("Poda") || username.equals("Arvind") || username.equals("Yesaya");
        }
        return false;
    }

    private static boolean inputPenjual(Scanner input) {
        System.out.print("Masukkan Username Anda: ");
        String inputUsername = input.nextLine();
        System.out.print("Masukkan Password Anda: ");
        int inputPassword = input.nextInt();
        input.nextLine();
        System.out.println("Anda masuk sebagai Penjual.");
        return cekUserNamePenjual(inputUsername, inputPassword);

    }

}

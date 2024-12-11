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

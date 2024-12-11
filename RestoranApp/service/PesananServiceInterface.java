package RestoranApp.service;

import RestoranApp.entities.Pesanan;
import java.util.List;

public interface PesananServiceInterface {
    void buatPesanan(String nama, String item, int kuantitas);
    List<Pesanan> lihatSemuaPesanan();
    void hapusPesanan(int index);
    void updatePesanan(int index, String nama ,String pesanan, int kuantitas, String status);
}

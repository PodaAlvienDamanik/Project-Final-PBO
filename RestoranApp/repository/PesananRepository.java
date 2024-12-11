package RestoranApp.repository;

import RestoranApp.entities.Pesanan;
import java.util.List;

public interface PesananRepository {
    void tambahPesanan(Pesanan pesanan);
    List<Pesanan> lihatSemuaPesanan();
    void hapusPesanan(int index);
    void updatePesanan(int index, Pesanan pesanan);
}

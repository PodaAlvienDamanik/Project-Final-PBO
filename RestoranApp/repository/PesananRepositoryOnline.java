package RestoranApp.repository;

import RestoranApp.entities.PesananOnline;
import java.util.List;

public interface PesananRepositoryOnline {
    void tambahPesananOnline(PesananOnline pesanan);
    List<PesananOnline> lihatSemuaPesananOnline();
    void hapusPesananOnline(int index);
    void updatePesananOnline(int index, PesananOnline pesanan);
}

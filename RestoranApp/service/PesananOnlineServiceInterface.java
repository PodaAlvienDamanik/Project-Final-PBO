package RestoranApp.service;

import RestoranApp.entities.PesananOnline;
import java.util.List;

public interface PesananOnlineServiceInterface {//14.26 hari rabu oleh poda
    void tambahPesananOnline(String nama, String item, int kuantitas);
    List<PesananOnline> lihatSemuaPesananOnline();
    void hapusPesananOnline(int index);
    void updatePesananOnline(int index, PesananOnline pesanan);
}

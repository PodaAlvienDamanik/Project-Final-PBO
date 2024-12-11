package RestoranApp.service;

import RestoranApp.entities.PesananOnline;
import RestoranApp.repository.PesananRepositoryOnline;
import org.springframework.stereotype.Component;

import java.util.List;

@Component //14.26 hari rabu oleh Poda
public class PesananOnlineService implements PesananOnlineServiceInterface {
    private final PesananRepositoryOnline repository;

    public PesananOnlineService(PesananRepositoryOnline repository) {
        this.repository = repository;
    }

    @Override
    public void tambahPesananOnline(String nama, String item, int kuantitas) {
        PesananOnline pesanan = new PesananOnline(nama, item, kuantitas, "Sedang Diproses");
        repository.tambahPesananOnline(pesanan);
    }

    @Override
    public List<PesananOnline> lihatSemuaPesananOnline() {
        return repository.lihatSemuaPesananOnline();
    }

    @Override
    public void hapusPesananOnline(int index) {
        repository.hapusPesananOnline(index);
    }

    @Override
    public void updatePesananOnline(int index, PesananOnline pesanan) {
        repository.updatePesananOnline(index, pesanan);
    }
}
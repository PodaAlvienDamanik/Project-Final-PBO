package RestoranApp.service;

import RestoranApp.entities.Pesanan;
import RestoranApp.repository.PesananRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PesananService implements PesananServiceInterface {
    private final PesananRepository repository;

    public PesananService(PesananRepository repository) {
        this.repository = repository;
    }

    @Override
    public void buatPesanan(String nama, String item, int kuantitas) {
        Pesanan pesanan = new Pesanan(nama, item, kuantitas, "Sedang Diproses");
        repository.tambahPesanan(  pesanan);
    }

    @Override
    public List<Pesanan> lihatSemuaPesanan() {
        return repository.lihatSemuaPesanan();
    }

    @Override
    public void hapusPesanan(int index) {
        repository.hapusPesanan(index);
    }

    @Override
    public void updatePesanan(int index, String nama ,String item, int kuantitas, String status) {
        Pesanan pesanan = new Pesanan(nama, item, kuantitas, status);
        repository.updatePesanan(index, pesanan);
    }
}
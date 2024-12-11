package RestoranApp.repository;

import RestoranApp.config.Database;
import RestoranApp.entities.Pesanan;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Component
public class PesananRepositoryDbImpl implements PesananRepository {
    private final Database database;

    public PesananRepositoryDbImpl(Database database) {
        this.database = database;
    }



    @Override
    public void tambahPesanan(Pesanan pesanan) {
        Connection connection = database.getConnection();
        String sqlStatement = "INSERT INTO pesanan(nama, item, kuantitas, status) VALUES(?,?,?,?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlStatement);
            preparedStatement.setString(1, pesanan.getNamaPembeli());
            preparedStatement.setString(2, pesanan.getItem());
            preparedStatement.setInt(3, pesanan.getKuantitas());
            preparedStatement.setString(4, pesanan.getStatus());


            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("pesanan Recorded successfully!");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Pesanan> lihatSemuaPesanan() {
        Connection connection = database.getConnection();
        String sqlStatement = "SELECT * FROM pesanan";
        List<Pesanan> listPesanan = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Pesanan dataPesanan = new Pesanan(resultSet.getString("nama"),resultSet.getString("item"),
                        resultSet.getInt("kuantitas"),resultSet.getString("status"));

                listPesanan.add(dataPesanan);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listPesanan;
    }

    @Override
    public void hapusPesanan(int index) {
        Connection connection = database.getConnection();
        String sqlStatement = "DELETE FROM pesanan WHERE id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlStatement);
            preparedStatement.setInt(1, getIdAtIndex(index));
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("pesanan deleted successfully!");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private int getIdAtIndex(int index){
        Pesanan pesanan = lihatSemuaPesanan().get(index);
        int id = -1;

        Connection connection = database.getConnection();
        String sqlStatement = "SELECT id FROM pesanan WHERE nama = ? AND item = ? AND kuantitas = ? AND status = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlStatement);
            preparedStatement.setString(1, pesanan.getNamaPembeli());
            preparedStatement.setString(2, pesanan.getItem());
            preparedStatement.setInt(3, pesanan.getKuantitas());
            preparedStatement.setString(4, pesanan.getStatus());

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                id = resultSet.getInt(1);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return id;
    }

    @Override
    public void updatePesanan(int index, Pesanan pesanan) {
        Connection connection = database.getConnection();
        String sqlStatement = "UPDATE pesanan SET nama = ?, item = ?, kuantitas = ?, status = ? WHERE id = ?";

        System.out.println(getIdAtIndex(index));
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlStatement);
            preparedStatement.setString(1, pesanan.getNamaPembeli());
            preparedStatement.setString(2, pesanan.getItem());
            preparedStatement.setInt(3, pesanan.getKuantitas());
            preparedStatement.setString(4, pesanan.getStatus());
            preparedStatement.setInt(5, getIdAtIndex(index));


            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("pesanan updated successfully!");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
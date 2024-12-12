package RestoranApp.repository;

import RestoranApp.config.Database;
import RestoranApp.entities.PesananOnline;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Component
public class PesananRepositoryOnlineImpl implements PesananRepositoryOnline {
    private final Database database;

    public PesananRepositoryOnlineImpl(Database database) {
        this.database = database;
    }

    @Override
    public void tambahPesananOnline(PesananOnline pesanan) {
        Connection connection = database.getConnection();
        String sqlStatement = "INSERT INTO pesanan_online(nama, item, kuantitas, status) VALUES(?,?,?,?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlStatement);
            preparedStatement.setString(1, pesanan.getNama());
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
    public List<PesananOnline> lihatSemuaPesananOnline() {
        Connection connection = database.getConnection();
        String sqlStatement = "SELECT * FROM pesanan_online";
        List<PesananOnline> listPesanan = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                PesananOnline dataPesanan = new PesananOnline(resultSet.getString("nama"),resultSet.getString("item"), resultSet.getInt("kuantitas"),resultSet.getString("status"));

                listPesanan.add(dataPesanan);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listPesanan;
    }

    @Override
    public void hapusPesananOnline(int index) {
        Connection connection = database.getConnection();
        String sqlStatement = "DELETE FROM pesanan_online WHERE id = ?";
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

    @Override
    public void updatePesananOnline(int index, PesananOnline pesanan) {
        Connection connection = database.getConnection();
        String sqlStatement = "UPDATE pesanan_online SET nama = ?, item = ?, kuantitas = ?, status = ? WHERE id = ?";//19.02 oleh poda


        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlStatement);
            preparedStatement.setString(1, pesanan.getNama());
            preparedStatement.setString(2, pesanan.getItem());
            preparedStatement.setInt(3, pesanan.getKuantitas());
            preparedStatement.setString(4, pesanan.getStatus());
            preparedStatement.setInt(5, getIdAtIndex(index));


            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Pesanan updated successfully!");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    private int getIdAtIndex(int index){
        PesananOnline pesananOnline = lihatSemuaPesananOnline().get(index);
        int id = -1;

        Connection connection = database.getConnection();
        String sqlStatement = "SELECT id FROM pesanan_online WHERE nama = ? AND item = ? AND kuantitas = ? AND status = ?";//19.02 oleh poda


        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlStatement);
            preparedStatement.setString(1, pesananOnline.getNama());
            preparedStatement.setString(2, pesananOnline.getItem());
            preparedStatement.setInt(3, pesananOnline.getKuantitas());
            preparedStatement.setString(4, pesananOnline.getStatus());

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                id = resultSet.getInt(1);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return id;
    }


}
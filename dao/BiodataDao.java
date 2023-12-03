package dao;

import db.MySqlConnection;
import biodata.Biodata;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BiodataDao {
    public int insert(Biodata biodata) {
        int result = -1;
        try(Connection connection = MySqlConnection.getInstance().getConnection();) {
            PreparedStatement statement = connection.prepareStatement("Insert into biodata (id, nama, alamat, no_telp, jenis_kelamin) values (?, ?, ?, ?, ?)");
            statement.setString(1, biodata.getId());
            statement.setString(2, biodata.getNama());
            statement.setString(3, biodata.getAlamat());
            statement.setString(4, biodata.getNo_telp());
            statement.setString(5, biodata.getJenis_kelamin());
            result = statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public int update(Biodata biodata) {
        int result = -1;
        try(Connection connection = MySqlConnection.getInstance().getConnection();) {
            PreparedStatement statement = connection.prepareStatement("update biodata set nama = ?, jenis_kelamin = ?, no_telp = ?, alamat = ? where id = ?");
            statement.setString(1, biodata.getNama());
            statement.setString(2, biodata.getJenis_kelamin());
            statement.setString(3, biodata.getNo_telp());
            statement.setString(4, biodata.getAlamat());
            statement.setString(5, biodata.getId());
            result = statement.executeUpdate();
            System.out.println("Update should be successfully");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public int delete(Biodata biodata) {
        int result = -1;
        try(Connection connection = MySqlConnection.getInstance().getConnection();) {
            PreparedStatement statement = connection.prepareStatement("delete from biodata where id = ?");
            statement.setString(1, biodata.getId());
            result = statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public Biodata findByName(String nama) {
        Biodata biodata = null;
        try {
            ResultSet resultSet = getResultSetNama(nama);
            while (resultSet.next()) {
                biodata = new Biodata();
                biodata.setId(resultSet.getString("id"));
                biodata.setNama(resultSet.getString("nama"));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return biodata;
    }

    private static ResultSet getResultSetNama(String nama) throws SQLException {
        Connection connection = MySqlConnection.getInstance().getConnection();
        String query = "select * from biodata where nama = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, nama);
        ResultSet resultSet = preparedStatement.executeQuery();
        return resultSet;
    }

    public static List<Biodata> findAll() {
        List<Biodata> list = new ArrayList<>();
        try(Connection connection = MySqlConnection.getInstance().getConnection(); Statement statement = connection.createStatement();) {
            try(ResultSet resultSet = statement.executeQuery("select * from biodata ");){
                while (resultSet.next()) {
                    Biodata biodata = new Biodata();
                    biodata.setId(resultSet.getString("id"));
                    biodata.setNama(resultSet.getString("nama"));
                    biodata.setAlamat(resultSet.getString("alamat"));
                    biodata.setJenis_kelamin(resultSet.getString("jenis_kelamin"));
                    biodata.setNo_telp(resultSet.getString("no_telp"));

                    list.add(biodata);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }


}

package org.example.demo13.service.sachService;

import org.example.demo13.model.Sach;

import java.io.Reader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import static org.example.demo13.config.ConnectionJDBC.getConnection;

public class SachService implements ISach{
    @Override
    public List<Sach> findAll() {
        List<Sach> sachList = new ArrayList<>();
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from sach");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int maSach = resultSet.getInt("maSach");
                String tenSach = resultSet.getString("tenSach");
                String tacGia = resultSet.getString("tacGia");
                String moTA = resultSet.getString("moTA");
                int soLuong = resultSet.getInt("soLuong");
                Sach sach = new Sach(maSach,tenSach,tacGia,moTA,soLuong);
                sachList.add(sach);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return sachList;
    }

    @Override
    public Sach findByID(int id) {
        Connection connection = getConnection();
        Sach sach = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from sach where id = ?");
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int maSach = resultSet.getInt("maSach");
                String tenSach = resultSet.getString("tenSach");
                String tacGia = resultSet.getString("tacGia");
                String moTA = resultSet.getString("moTA");
                int soLuong = resultSet.getInt("soLuong");
                sach = new Sach(maSach,tenSach,tacGia,moTA,soLuong);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return sach;
    }

    @Override
    public void create(Sach o) {

    }

    @Override
    public void updateByID(int id) {

    }

    @Override
    public void deleteByID(int id) {

    }
}

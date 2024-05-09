package org.example.demo13.service.hocSinhService;

import org.example.demo13.model.HocSinh;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import static org.example.demo13.config.ConnectionJDBC.getConnection;
public class HocSinhService implements IHocSinh{

    @Override
    public List<HocSinh> findAll() {
        List<HocSinh> hocSinhList = new ArrayList<>();
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from hocsinh");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int maHocSinh = resultSet.getInt("maHocSinh");
                String hoTen = resultSet.getString("hoTen");
                String lop = resultSet.getString("lop");
                HocSinh hocSinh = new HocSinh(maHocSinh,hoTen,lop);
                hocSinhList.add(hocSinh);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return hocSinhList;
    }

    @Override
    public HocSinh findByID(int id) {
        Connection connection = getConnection();
        HocSinh hocSinh = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from hocsinh where id =?");
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int maHocSinh = resultSet.getInt("maHocSinh");
                String hoTen = resultSet.getString("hoTen");
                String lop = resultSet.getString("lop");
                 hocSinh = new HocSinh(maHocSinh,hoTen,lop);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return hocSinh;
    }

    @Override
    public void create(HocSinh o) {

    }

    @Override
    public void updateByID(int id) {

    }

    @Override
    public void deleteByID(int id) {

    }
}

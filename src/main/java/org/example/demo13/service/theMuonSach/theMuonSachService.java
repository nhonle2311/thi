package org.example.demo13.service.theMuonSach;

import org.example.demo13.model.Sach;
import org.example.demo13.model.TheMuonSach;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.example.demo13.config.ConnectionJDBC.getConnection;

public class theMuonSachService implements ITheMuonSach{
    @Override
    public List<TheMuonSach> findAll() {
        List<TheMuonSach> theMuonSachList = new ArrayList<>();
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from themuonsach");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int maMuonSach = resultSet.getInt("maMuonSach");
                int maSach = Integer.parseInt(resultSet.getString("maSach"));
                int maHocSinh = Integer.parseInt(resultSet.getString("maHocSinh"));
                Boolean trangThai = resultSet.getString("moTA").isEmpty();
                LocalDate ngayMuon = LocalDate.ofEpochDay(resultSet.getInt("soLuong"));
                LocalDate ngayTra = LocalDate.ofEpochDay(resultSet.getInt("soLuong"));
                TheMuonSach theMuonSach = new TheMuonSach(maMuonSach,maSach,maHocSinh,trangThai,ngayMuon,ngayTra);
                theMuonSachList.add(theMuonSach);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return theMuonSachList;
    }

    @Override
    public TheMuonSach findByID(int id) {
        return null;
    }

    @Override
    public void create(TheMuonSach o) {

    }

    @Override
    public void updateByID(int id) {

    }

    @Override
    public void deleteByID(int id) {

    }
}

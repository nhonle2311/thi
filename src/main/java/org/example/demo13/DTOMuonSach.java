package org.example.demo13;

import java.time.LocalDate;

public class DTOMuonSach {
    private int maSach;
    private String tenSach;
    private String hoTen;
    private LocalDate ngayMuonSach;
    private LocalDate ngayTraSach;

    public DTOMuonSach() {
    }

    public DTOMuonSach(int maSach, String tenSach, String hoTen, LocalDate ngayMuonSach, LocalDate ngayTraSach) {
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.hoTen = hoTen;
        this.ngayMuonSach = ngayMuonSach;
        this.ngayTraSach = ngayTraSach;
    }

    public int getMaSach() {
        return maSach;
    }

    public void setMaSach(int maSach) {
        this.maSach = maSach;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public LocalDate getNgayMuonSach() {
        return ngayMuonSach;
    }

    public void setNgayMuonSach(LocalDate ngayMuonSach) {
        this.ngayMuonSach = ngayMuonSach;
    }

    public LocalDate getNgayTraSach() {
        return ngayTraSach;
    }

    public void setNgayTraSach(LocalDate ngayTraSach) {
        this.ngayTraSach = ngayTraSach;
    }
}

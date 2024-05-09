package org.example.demo13.controller;

import org.example.demo13.DTOMuonSach;
import org.example.demo13.model.HocSinh;
import org.example.demo13.model.Sach;
import org.example.demo13.service.hocSinhService.HocSinhService;
import org.example.demo13.service.hocSinhService.IHocSinh;
import org.example.demo13.service.sachService.ISach;
import org.example.demo13.service.sachService.SachService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@WebServlet(name = "SachServlet", urlPatterns = "/sach")
public class SachServlet extends HttpServlet {
    private ISach iSach = new SachService();
    private IHocSinh iHocSinh = new HocSinhService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null){
            action = "";
        }switch (action){
            case "list":
                listSach(req,resp);
                break;
            case "show":
                showFormMuonSach(req,resp);
                break;
        }
    }

    private void showFormMuonSach(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int maSach = Integer.parseInt(req.getParameter("maSach"));
        Sach sach = iSach.findByID(maSach);
        List<HocSinh> hocSinhList = iHocSinh.findAll();
        req.setAttribute("sach", sach);
        req.setAttribute("hocSinhList", hocSinhList);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/form_muon_sach.jsp");
        dispatcher.forward(req, resp);
    }


    private void listSach(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Sach> sachList = iSach.findAll();
        req.setAttribute("sachList",sachList);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("list.jsp");
        requestDispatcher.forward(req,resp);
    }
}

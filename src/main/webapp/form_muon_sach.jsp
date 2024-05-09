<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Muon Sach</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <h1 class="mt-5">Mượn sách</h1>
    <form action="process_muon_sach.jsp" method="post">
        <div class="form-group">
            <label for="maMuonSach">Mã mượn sách:</label>
            <input type="text" class="form-control" id="maMuonSach" name="maMuonSach" required>
        </div>
        <div class="form-group">
            <label for="tenSach">Tên sách:</label>
            <input type="text" class="form-control" id="tenSach" name="tenSach" value="${sach.tenSach}" readonly>
        </div>
        <div class="form-group">
            <label for="tenHocSinh">Tên học sinh:</label>
            <select class="form-control" id="tenHocSinh" name="maHocSinh" required>
                <option value="">Chọn tên học sinh</option>
                <c:forEach items="${hocSinhList}" var="hocSinh">
                    <option value="${hocSinh.maHocSinh}">${hocSinh.hoTen}</option>
                </c:forEach>
            </select>
        </div>
        <div class="form-group">
            <label for="ngayMuon">Ngày mượn sách:</label>
            <input type="date" class="form-control" id="ngayMuon" name="ngayMuon" value="<%= new java.text.SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date()) %>" readonly>
        </div>
        <div class="form-group">
            <label for="ngayTra">Ngày trả sách:</label>
            <input type="date" class="form-control" id="ngayTra" name="ngayTra" required>
        </div>
        <button type="submit" class="btn btn-primary">Mượn sách</button>
    </form>
</div>
</body>
</html>

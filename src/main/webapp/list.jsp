<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User List</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <h1 class="mt-5">Sach List</h1>
    <table class="table mt-3">
        <thead class="thead-dark">
        <tr>
            <th>maSach</th>
            <th>tenSach</th>
            <th>tacGia</th>
            <th>moTA</th>
            <th>soLuong</th>
            <th>Mượn</th>

        </tr>
        </thead>
        <tbody>
        <c:forEach items="${sachList}" var="sach">
            <tr>
                <td>${sach.maSach}</td>
                <td>${sach.tenSach}</td>
                <td>${sach.tacGia}</td>
                <td>${sach.mota}</td>
                <td>${sach.soLuong}</td>
                <td>
                    <a class="btn btn-info" href="form_muon_sach.jsp?id=${sach.maSach}">Mượn</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <a class="btn btn-success" href="sach?action=add">Add New User</a>
</div>
</body>
</html>

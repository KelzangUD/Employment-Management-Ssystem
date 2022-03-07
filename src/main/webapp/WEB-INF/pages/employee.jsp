<%--
  Created by IntelliJ IDEA.
  User: Kelzang Ugyen Dorji
  Date: 2/25/2022
  Time: 7:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Employee Page</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="#" onclick="loadPage('home')">Home</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item"><a class="nav-link active" href="#" onclick="loadPage('employee')">Employee</a></li>
                <li class="nav-item"><a class="nav-link active" href="#" onclick="loadPage('department')">Department</a></li>
                <li class="nav-item"><a class="nav-link active" href="#" onclick="loadPage('document')">Document</a></li>
                <li class="nav-item"><a class="nav-link active" href="#" onclick="loadPage('regulation')">Regulation</a></li>
            </ul>
        </div>
    </div>
</nav>
<div class="container my-5">
    <div class="card-body text-center">
        <h4 class="card-title">Employee Details</h4>
    </div>
    <div class="card">
        <button onclick="loadPage('addNewEmployee')" id="add__new__list" type="button" class="btn btn-success position-absolute" data-toggle="modal" data-target=".bd-example-modal-lg"><i class="fas fa-plus"></i> Add a new List</button><br>
        <%if(request.getAttribute("EmployeeList").equals("emptyList")){%>
                <h1>No Data in the database</h1>
        <%}else{%>
        <table class="table table-hover">
            <thead>
            <tr>
                <th scope="col">ID</th>
                <th scope="col">Name</th>
                <th scope="col">Date Of Birth</th>
                <th scope="col">Email</th>
                <th scope="col">Department</th>
                <th scope="col">Edit</th>
                <th scope="col">Delete</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="list" items="${EmployeeList}">
                <tr>
                    <td>${list.id}</td>
                    <td>${list.firstName} ${list.lastName}</td>
                    <td>${list.dob}</td>
                    <td>${list.email}</td>
                    <td>${list.department}</td>
                    <td><a class="btn btn-sm btn-primary" href="#" onclick="editEmployee(${list.id})"><i class="far fa-edit"></i> edit</a></td>
                    <td><a class="btn btn-sm btn-danger" href="#" onclick="deleteEmployee(${list.id})"><i class="fas fa-trash-alt"></i> delete</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <%}%>

    </div>
</div>
<style>
    body{
        background-image:url(https://static.pexels.com/photos/371633/pexels-photo-371633.jpeg);
        background-repeat:no-repeat;
        background-size: 100%;
    }

    footer{

        margin-top: 20px;
        padding-top: 20px;
    }
    .bg__card__navbar{
        background-color: #000000;
    }
    .bg__card__footer{
        background-color: #000000 !important;
    }
    #add__new__list{
        top: -38px;
        right: 0px;
    }
</style>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<script>
    function loadPage(page){
        var url = '${pageContext.request.contextPath}loadPage?page='+page;
        window.location = url;
    }
    function editEmployee(id){
        var url = '${pageContext.request.contextPath}/employee/editEmployee?id='+id;
        window.location = url;
    }
    function deleteEmployee(id){
        var url = '${pageContext.request.contextPath}/employee/deleteEmployee?id='+id;
        window.location = url;
    }
</script>
</body>
</html>

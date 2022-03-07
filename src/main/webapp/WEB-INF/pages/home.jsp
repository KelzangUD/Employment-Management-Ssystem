<%--
  Created by IntelliJ IDEA.
  User: Kelzang Ugyen Dorji
  Date: 2/23/2022
  Time: 6:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Home Page</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <!-- Custom fonts for this template-->
    <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">
    <%--<link rel="<c:import url="../css/home.css"/>" type="text/css">--%>
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
<!-- Main Content -->
<div id="content">
    <!-- Begin Page Content -->
    <div class="container-fluid">
        <!-- Page Heading -->
        <div class="row">
            <div class="col">
                <div class="d-sm-flex align-items-center justify-content-between mb-4">
                    <h1 class="h3 mb-0 text-gray-800">Dashboard</h1>
                </div>
            </div>
            <div class="col">
                <!-- Weather Card-->
                <div class="d-flex flex-column text-center">
                    <h6 class="display-4 mb-0 font-weight-bold" style="color: #1C2331;"> ${weather.temp}°C </h6>
                    <span class="display-8" style="color: #868B94">${weather.description}</span>
                </div>
            </div>
            <div class="col">
                <!-- Weather Card-->
                <div class="d-flex align-items-center">
                    <div class="flex-grow-1" style="font-size: 1rem;">
                        <h5 class="display-6 mb-0 font-weight-bold">
                            <i class="fas fa-wind fa-fw" style="color: #868B94;"></i> <span class="ms-1"> ${weather.windSpeed} km/h </span>
                            <i class="fas fa-tint fa-fw" style="color: #868B94;"></i> <span class="ms-1"> ${weather.humidity} % </span>
                            <i class="fas fa-sun fa-fw" style="color: #868B94;"></i> <span class="ms-1"> ${weather.pressure}  h </span>
                        </h5>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="container-fluid" style="background-color: #868B94">
    <!-- Begin Page Content -->
    <div style="padding-top: 2rem">
        <div>
            <div class="row">
                <!-- Earnings (Monthly) Card Example -->
                <div class="col-xl-3 col-md-6 mb-4">
                    <div class="card border-left-success shadow h-100 py-2">
                        <div class="card-body">
                            <div class="row no-gutters align-items-center">
                                <div class="col mr-2">
                                    <div class="text-xs font-weight-bold text-success text-uppercase mb-1">
                                        Employee (Total)</div>
                                    <div class="h5 mb-0 font-weight-bold text-gray-800">${employeeCount}</div>
                                </div>
                                <div class="col-auto">
                                    <i class="fas fa-dollar-sign fa-2x text-gray-300"></i>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- Earnings (Monthly) Card Example -->
                <div class="col-xl-3 col-md-6 mb-4">
                    <div class="card border-left-info shadow h-100 py-2">
                        <div class="card-body">
                            <div class="row no-gutters align-items-center">
                                <div class="col mr-2">
                                    <div class="text-xs font-weight-bold text-info text-uppercase mb-1">Tasks
                                    </div>
                                    <div class="row no-gutters align-items-center">
                                        <div class="col-auto">
                                            <div class="h5 mb-0 mr-3 font-weight-bold text-gray-800">50%</div>
                                        </div>
                                        <div class="col">
                                            <div class="progress progress-sm mr-2">
                                                <div class="progress-bar bg-info" role="progressbar"
                                                     style="width: 50%" aria-valuenow="50" aria-valuemin="0"
                                                     aria-valuemax="100"></div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-auto">
                                    <i class="fas fa-clipboard-list fa-2x text-gray-300"></i>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<script>
    $(document).ready(function() {
        console.log("ready");
    });
    function loadPage(page){
        debugger;
        var url ='${pageContext.request.contextPath}/loadPage?page='+page;
        window.location = url;
    }
</script>
</body>
</html>

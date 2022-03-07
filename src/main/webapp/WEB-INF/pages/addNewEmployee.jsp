<%@ page import="java.util.List" %>
<%@ page import="com.employementmanagementsystem.mvc.dto.DepartmentDto" %>
<%--
  Created by IntelliJ IDEA.
  User: Kelzang Ugyen Dorji
  Date: 3/1/2022
  Time: 5:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Add New Employee Page</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
</head>
<body>
<div class="container" id="employee">
    <div class="row">
        <div class="col-md-12">
            <div class="well well-sm">
                <form class="form-horizontal"  id="employeeDetailForm" action="/employee/newEmployee" method="post">
                        <legend class="text-center header">Add New Employee Detail</legend>
                        <div class="form-group">
                            <div class="col-md-8">
                                <label>First Name</label>
                                <input id="fname" name="firstName" type="text" class="form-control">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-8">
                                <label>Last Name</label>
                                <input id="lname" name="lastName" type="text" class="form-control">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-8">
                                <label>Date Of Birth</label>
                                <input id="dob" name="dob" type="text" class="form-control">
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-md-8">
                                <label>Email Address</label>
                                <input id="email" name="email" type="text" class="form-control">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-8">
                                <label>Department</label>
                                <select class="form-control" name="departmentId">
                                    <option value="">SELECT</option>
                                    <c:forEach var="departmentList" items="${departmentList}">
                                        <option value="${departmentList.id}">${departmentList.department}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div><br>
                        <div class="form-group">
                            <div class="col-md-12 text-center">
                                <button type="submit" class="btn btn-primary btn-lg">Submit</button>
                            </div>
                        </div>
                </form>
            </div>
        </div>
    </div>
</div>

<style>
    .header {
        color: #36A0FF;
        font-size: 27px;
        padding: 10px;
    }

    .bigicon {
        font-size: 35px;
        color: #36A0FF;
    }
</style>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<script>
    $(document).ready(function() {
        $(function() {
            $("#dob").datepicker({ dateFormat: 'dd/mm/yy' });
        });
    });
</script>
</body>
</html>

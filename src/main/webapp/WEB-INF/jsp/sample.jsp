<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/css/bootstrap.css">
    <link rel="stylesheet" href="https://cdn.datatables.net/1.10.20/css/dataTables.bootstrap4.min.css">
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.20/css/dataTables.bootstrap4.min.css">
    <script type="text/javascript" language="javascript" src="https://code.jquery.com/jquery-3.3.1.js"></script>
    <script type="text/javascript" language="javascript"
            src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js"></script>
    <script type="text/javascript" language="javascript"
            src="https://cdn.datatables.net/1.10.20/js/dataTables.bootstrap4.min.js"></script>

    <title>Insert title here</title>

    <script type="application/javascript">
        $(document).ready(function() {
            $('#example').DataTable();
        } );
    </script>
</head>
<body>
<table id="example" class="table table-striped table-bordered" style="width:100%">
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>LastName</th>
        <th>Age</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${samples}" var="sample" varStatus="status">
        <tr>
            <td>${sample.id}</td>
            <td>${sample.name}</td>
            <td>${sample.surname}</td>
            <td>${sample.age}</td>
        </tr>
    </c:forEach>
    </tbody>
    <tfoot>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>LastName</th>
        <th>Age</th>
    </tr>
    </tfoot>
</table>

</body>
</html>
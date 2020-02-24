<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>雨量监测信息</title>
    <style>
        * {
            margin: 0 auto
        }

        #list {
            width: 600px;
            height: auto
        }
        table,tr,.add{width: 600px}
    </style>
</head>
<body>

<div id="list">
    <h3 align="center">雨量监测信息</h3>
    <table border="1" align="center">
        <thead align="center">
        <tr>
            <td>序号</td>
            <td>区域名称</td>
            <td>监测时间</td>
            <td>雨量值(mm)</td>
            <td>监测站</td>
            <td>站点地址</td>
            <td>操作</td>
        </tr>
        </thead>
        <tbody align="center">
        <c:forEach items="${allinfo}" var="info">
            <tr>
                <td>${info.id}</td>
                <td>${info.districtName}</td>
                <td>${info.monitorTime}</td>
                <td>${info.rain}</td>
                <td>${info.monitoringStation}</td>
                <td>${info.monitoringAddress}</td>
                <td><a href="void(0)" onclick="">删除</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div class="add"><a href="add.jsp">新增雨量监测信息</a></div>
</div>
</body>
</html>
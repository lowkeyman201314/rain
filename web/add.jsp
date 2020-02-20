<%--
  Created by IntelliJ IDEA.
  User: laoyu
  Date: 2020/2/20
  Time: 9:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>新增雨量监测信息</title>
    <style>
        * {
            margin: 0 auto
        }

        #list {
            width: 450px;
            height: auto
        }
        table,tr,.add{width: 450px}
        td:first-child{text-align: left;}
        tr:last-child>td:first-child{text-align: center;}
    </style>
</head>
<body>

<div id="list">
    <h3 align="center">新增雨量监测信息</h3>
    <table align="center">
        <tbody align="center">
        <tr>
            <td>区域名称：</td>
            <td><input type="text" name=""></td>
            <td></td>
        </tr>
        <tr>
            <td>监测时间：</td>
            <td><input type="text" name=""></td>
            <td>yyyy.MM.dd格式</td>
        </tr>
        <tr>
            <td>雨量值(mm)：</td>
            <td><input type="text" name=""></td>
            <td></td>
        </tr>
        <tr>
            <td>监测站：</td>
            <td><input type="text" name=""></td>
            <td></td>
        </tr>
        <tr>
            <td>站点地址：</td>
            <td><input type="text" name=""></td>
            <td></td>
        </tr>
        <tr>
            <td colspan="3">
                <input type="button" onclick="" value="保存">
                <input type="button" onclick="" value="重置">
                <input type="button" onclick="" value="返回">
            </td>
        </tr>
        </tbody>
    </table>
</div>
</body>
</html>

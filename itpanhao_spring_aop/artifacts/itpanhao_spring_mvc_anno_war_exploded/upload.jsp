<%--
  Created by IntelliJ IDEA.
  User: phfile
  Date: 2021/5/25
  Time: 10:17 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/user/quick23" method="post" enctype="multipart/form-data">
        名称<input type="text" name="username"><br/>
        文件<input type="file" name="upload"><br/>
        文件<input type="file" name="upload"><br/>
        文件<input type="file" name="upload"><br/>
        <input type="submit" value="提交">
    </form>
</body>
</html>

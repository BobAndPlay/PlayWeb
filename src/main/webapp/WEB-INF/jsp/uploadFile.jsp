<%--
  Created by IntelliJ IDEA.
  User: Bob
  Date: 2017/5/9
  Time: 17:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<body>
<form action="${pageContext.request.contextPath }/upload" method="post" enctype="multipart/form-data">
    <h2>文件上传</h2>
    文件:<input type="file" name="uploadFile"/><br/><br/>
    <input type="submit" value="上传"/>
</form>
</body>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${msg}</title>
</head>
<body>
<h1>${msg}</h1>
<span>${name}</span>
<form action="/import" method="post" enctype="multipart/form-data">
    文件<input type="file" name="file">
    <input type="submit" value="上传">
</form>
</body>
</html>
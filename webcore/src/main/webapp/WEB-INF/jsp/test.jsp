<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${msg}</title>
</head>
<body>
<h1>${msg}</h1>
<span>${name}</span>
<form action="/import" method="post" enctype="multipart/form-data">
    文件<input type="file" name="file"><!--name跟controller的MultipartFile对应的RequestParam必须一样-->
    <input type="submit" value="上传">
</form>
</body>
</html>
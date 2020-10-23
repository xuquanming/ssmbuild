<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/10/21 0021
  Time: 15:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%--bootStrap美化界面--%>
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>新增书籍</small>
                </h1>
            </div>
        </div>

    </div>

    <form action="${pageContext.request.contextPath}/book/addBooks" method="post">
        <div class="form-group">
            <label for="bkname">书籍名称</label>
            <input type="text" name="bookName" class="form-control" id="bkname">
        </div>
        <div class="form-group">
            <label for="bkcounts">书籍数量</label>
            <input type="text" name="bookCounts" class="form-control" id="bkcounts">
        </div>
        <div class="form-group">
            <label for="bkdetail">书籍描述</label>
            <input type="text" name="detail" class="form-control" id="bkdetail">
        </div>
        <div class="form-group">
            <input type="submit" class="form-control" value="添加">
        </div>

    </form>

</div>
</body>
</html>

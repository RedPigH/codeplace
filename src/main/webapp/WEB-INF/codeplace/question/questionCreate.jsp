<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Board Create</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <script
            src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script
            src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script
            src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <h2>Create Board form</h2>
    <form action="/questions/write" method="post">
        <div class="form-group">
            <label>Title:</label> <input type="text"
                                                    class="form-control" id="title" placeholder="Enter Title"
                                                    name="title">
        </div>
        <div class="form-group">
            <label>contents:</label>
            <textarea rows="20" cols="100" id="contents"
                      placeholder="Enter contents" name="contents"></textarea>
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
    <a href="/questions/list"><button type="button" class="btn btn-info">Move to List</button></a>
</div>
</body>
</html>


<%--<%@ page language="java" contentType="text/html; charset=UTF-8"--%>
<%--         pageEncoding="UTF-8"%>--%>
<%--<!DOCTYPE html>--%>
<%--<html lang="en">--%>
<%--<head>--%>
<%--    <meta charset="UTF-8">--%>
<%--    <title>Title</title>--%>
<%--</head>--%>
<%--<body>--%>
<%--<form  action="/questions/write" method="post">--%>
<%--    oid : <input type="text" name="oid"> <br>--%>
<%--    poid : <input type="text" name="parentsoid"> <br>--%>
<%--    제목 : <input type="text" name="title"> <br>--%>
<%--    작성자 : <input type="text" name="creatoroid"> <br>--%>
<%--    <textarea name="contents"></textarea><br>--%>

<%--    <input type="submit" value="등록">--%>
<%--</form>--%>
<%--</body>--%>
<%--</html>--%>
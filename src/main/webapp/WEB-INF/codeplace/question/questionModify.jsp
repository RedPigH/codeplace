<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Bootstrap Read</title>
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
    <h2>Update Board form</h2>
    <form action="/questions/modify/${Question.oid}" method="post">
        <input type="hidden" value="${Question.oid }" name="oid">

        <div class="form-group">
            <label>tag:</label> <input type="text"
                                                     class="form-control" id="writer" name="tag"
                                                    value="${Question.tag }">
        </div>

        <div class="form-group">
            <label>Title:</label> <input type="text"
                                                    class="form-control" id="title" name="title"
                                                    value="${Question.title}">
        </div>
        <div class="form-group">
            <label>contents:</label>
            <textarea rows="20" cols="100" id="contents" name="contents"
            >${Question.contents}</textarea>
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
    <a href="/questions/view/${Question.oid}"><button type="button" class="btn btn-danger">Cancel</button></a>
    <a href="/questions/list"><button type="button" class="btn btn-info">Move to List</button></a>
</div>
</body>
</html>
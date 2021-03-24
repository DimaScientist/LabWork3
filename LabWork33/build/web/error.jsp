<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page isErrorPage="true" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Error</title>
    </head>
    <body>
        <h1>Произошла ошибка</h1>
        <button id="go-back">Ok</button>
    </body>
</html>
<script>
    document.getElementById("go-back").addEventListener('click', ()=>{
        history.back();
    });
</script>

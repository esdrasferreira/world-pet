<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <title>Pet world!</title>
</head>
<body class="p-3 mb-2 bg-secondary">
<!-- Just an image -->
<nav class="navbar navbar-dark bg-dark">
   <ul class="nav justify-content-left">
    <li class="nav-item">
        <a class="nav-link active" href="/pets">Pets</a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="/pets/cadastrar">Pets-cadastro</a>
    </li>
       <li class="nav-item">
           <a class="nav-link active" href="/usuarios">Usuários</a>
       </li>
       <li class="nav-item">
           <a class="nav-link" href="/usuarios/cadastrar">Cadastro-usuários</a>
       </li>
    </ul>

</nav>
<table class="table table-dark">

    <thead>
    <tr>
        <th  scope="col">id</th>
        <th  scope="col">nome</th>
        <th  scope="col">idade</th>
        <th  scope="col">sexo</th>
        <th  scope="col">endereço</th>

    </tr>
    </thead>

    <tbody>
    <c:forEach var="usuario" items="${usuarios}">
    <form method="get" action="/usuarios/editar/${usuario.id}">
        <tr>
            <th>${usuario.id}</th>
            <th>${usuario.nome}</th>
            <th>${usuario.idade}</th>
            <th>${usuario.sexo}</th>
            <th>${usuario.endereco}</th>
            <th><button type="submit" class="btn btn-link">editar</button></th>
        </tr>
    </form>
    </c:forEach>
        </tbody>
</table>
</body>


<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

</html>

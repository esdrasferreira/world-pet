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
<div class="container">
<form method="post" action="/usuarios/salvar">
    <input type="hidden" name="id" id="id" value="${usuario.id}">
    <div class="form-group row">
        <label for="nome" class="col-sm-2 col-form-label">Nome:</label>
        <div class="col-auto">
            <input type="text" class="form-control" name="nome" id="nome" placeholder="" value="${usuario.nome}">
        </div>
    </div>
    <div class="form-group row">
        <label for="idade" class="col-sm-2 col-form-label">Idade:</label>
        <div class="col-auto">
            <input type="date" class="form-control" name="idade" id="idade" placeholder="" value="${usuario.idade}">
        </div>
    </div>

    <fieldset class="form-group">
        <div class="row">
            <legend class="col-form-label col-sm-2 pt-0">Sexo:</legend>
            <div class="col-auto">
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="sexo" id="masculino" value="masculino" checked>
                    <label class="form-check-label" for="masculino">
                        Masculino
                    </label>
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="sexo" id="feminino" value="feminino">
                    <label class="form-check-label" for="feminino">
                       Feminino
                    </label>
                </div>
                <div class="form-check disabled">
                    <input class="form-check-input" type="radio" name="sexo" id="duvida" value="duvida">
                    <label class="form-check-label" for="duvida">
                        Dúvida
                    </label>
                </div>
            </div>
        </div>
    </fieldset>
    <div class="form-group row">
        <label for="endereco" class="col-sm-2 col-form-label">Endereço:</label>
        <div class="col-auto">
            <input type="texto" class="form-control" name="endereco" id="endereco" placeholder="" value="${usuario.endereco}">
        </div>
    </div>
    <div class="form-group row">
        <div class="col-sm-10">
            <button type="submit" class="btn btn-primary">Salvar</button>
        </div>
    </div>
</form>
</div>



<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>

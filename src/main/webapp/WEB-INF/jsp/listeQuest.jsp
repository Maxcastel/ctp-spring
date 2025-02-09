<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List,fr.but3.revision.models.*" %>

<!doctype html>
<html lang="fr">
<head>
    <!-- Required meta tags -->
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <title>CTP</title>
</head>
<body>
    <header class="d-flex align-items-center">
        <img src="/logo.png" alt="Logo Université" width="150" height="auto" class="flex-grow-1">
        <!-- <p class="mx-auto">Connecté : ${loguedUserName}</p> -->
        <p class="mx-auto">Connecté : ${pageContext.request.userPrincipal.name}</p>
        <!-- <p class="mx-auto">Connecté : ${userViaPrincipal}</p> -->
    </header>
    <div class="container">
        <h1>Questions</h1>

        <%
            String error = (String) request.getAttribute("error");
            if (error != null) {
        %>
            <div class="alert alert-danger" role="alert">
                <%= error %>
            </div>
        <%
            }
        %>

        <%
            String message = (String) request.getAttribute("message");
            if (message != null) {
        %>
            <div class="alert alert-success" role="alert">
                <%= message %>
            </div>
        <%
            }
        %>

        <!-- <c:if test="${not empty error}">
            <div class="alert alert-danger" role="alert">
                ${error}
            </div>
        </c:if>

        <c:if test="${not empty message}">
            <div class="alert alert-success" role="alert">
                ${message}
            </div>
        </c:if> -->

        <table class="table">
            <thead>
                <tr>
                    <th>Numero</th>
                    <th>Libelle</th>
                    <th>Active</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <% List<Question> questions = (List<Question>) request.getAttribute("questions");%>
                <% for(Question question : questions) { %>
                    <tr>
                        <td>
                            <%= question.getQno() %>
                        </td>
                        <td>
                            <%= question.getLibelle() %>
                        </td>
                        <td>
                            <%= question.isActive() ? "Oui" : "Non" %>
                        </td>
                        <td class="d-flex">
                            <form action='<%= question.isActive() ? "/questions/desactiver" : "/questions/activer" %>' method="post">
                                <input type="hidden" name="questionNum" value="<%= question.getQno() %>" />

                                <% if (question.isActive()) { %>
                                    <input type="submit" class="btn btn-warning" value="Desactiver" />
                                <% } else { %>
                                    <input type="submit" class="btn btn-primary" value="Activer" />
                                <% } %>
                            </form>
                            <a href="/questions/voir?questionNum=<%= question.getQno() %>" class="btn btn-primary ml-2">
                                Voir
                            </a>
                        </td>
                    </tr>
                <% }%>
                <tr>
                    <td>500</td>
                    <td>Question qui n'existe pas en bdd (pour tester erreur)</td>
                    <td>Non</td>
                    <td class="d-flex">
                        <form action='/questions/activer' method="post">
                            <input type="hidden" name="questionNum" value="500" />
                            <input type="submit" class="btn btn-primary" value="Activer" />
                        </form>
                        <a href="/questions/voir?questionNum=500" class="btn btn-primary ml-2">
                            Voir
                        </a>
                    </td>
                </tr>
            </tbody>
        </table>
    </div>

</body>
</html>






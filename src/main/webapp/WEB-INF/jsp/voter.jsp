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
        <p class="mx-auto">Connecté : ${pageContext.request.userPrincipal.name}</p>
    </header>
    <div class="container">
        <%
            Question question = (Question) request.getAttribute("question");
            String error = (String) request.getAttribute("error");
            String message = (String) request.getAttribute("message");
        %>

        <h1 class="mt-3 mb-5"><%= question == null ? "Aucune question" : question.getLibelle() %></h1>

        <% 
            if (error != null) {
        %>
            <div class="alert alert-danger" role="alert">
                <%= error %>
            </div>
        <% 
            }
        %>

        <%
            if (message  != null) {
        %>
            <div class="alert alert-success" role="alert">
                <%= message %>
            </div>
        <% 
            }
        %>
        
        <%
            if (question != null) {
        %>

            <form action="/questions/voter" method="post">
                <input type="hidden" name="questionNum" value="<%= question.getQno() %>" />

                <h3 class="my-4">Choisissez une option :</h3>

                <% 
                    List<Choix> choixList = (List<Choix>) request.getAttribute("choix");
                    for (Choix choix : choixList) {
                %>
                    <div>
                        <input type="radio" name="choixNum" value="<%= choix.getCno() %>" required />
                        <label><%= choix.getLibelle() %> (Nb Choix : <%= choix.getNbChoix() %>)</label>
                    </div>
                <% 
                    }
                %>
                <div>
                    <input type="radio" name="choixNum" value="500" required />
                    <label>Choix qui n'existe pas en bdd (pour tester erreur)</label>
                </div>
                <%
                    Choix choixFromOtherQuestion = (Choix) request.getAttribute("choixFromNotActiveQuest");
                %>
                <div>
                    <input type="radio" name="choixNum" value="<%= choixFromOtherQuestion.getCno() %>" required />
                    <label><%= choixFromOtherQuestion.getLibelle() %> Choix qui existe en bdd mais qui appartient a une autre question (pour tester erreur)</label>
                </div>

                <button type="submit" class="mt-2 btn btn-primary">Valider mon choix</button>
            </form>
        <% 
            }
        %>
    </div>

</body>
</html>






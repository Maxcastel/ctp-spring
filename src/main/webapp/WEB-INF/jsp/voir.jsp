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
            if (question != null) {
        %>
            <h3>Choix :</h3>
            <ul>
                <% 
                    List<Choix> choixList = (List<Choix>) request.getAttribute("choix");
                    for (Choix choix : choixList) {
                %>
                    <li>
                        <%= choix.getLibelle() %> (Nombre de votes : <%= choix.getNbChoix() %>)
                    </li>
                <% 
                    }
                %>
            </ul>

            <% 
                int nbVotesTotal = (Integer) request.getAttribute("nbVotesTotal");
                Double percentage = (Double) request.getAttribute("percentageCorrect");
            %>
            <h3>Nombre de votes : <%= nbVotesTotal %></h3>
            <h3>Pourcentage de votes corrects : <%= String.format("%.2f", percentage) %>%</h3>
        <% 
            }
        %>

        <a href="/questions/activer" class="btn btn-primary mt-5">Liste des questions</a>
    </div>

</body>
</html>






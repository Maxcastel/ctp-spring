<%@ page import="java.util.List,fr.but3.revision.models.*" %>

<!doctype html>
<html lang="fr">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <title>CTP</title>
</head>
<body>
    <div class="container">
        <h1>Hello, Authors</h1>

        <table class="table">
            <tr>
                <th>Nom</th>
                <th>Prenom</th>
            </tr>
            <% List<Auteur> data = (List<Auteur>) request.getAttribute("auteurs");%>
            <% for(Auteur auteur : data) { %>
                <tr>
                    <td>
                        <%= auteur.getNom()%>
                    </td>
                    <td>
                        <%= auteur.getPrenom()%>
                    </td>
                </tr>
            <% }%>
        </table>
    </div>

</body>
</html>






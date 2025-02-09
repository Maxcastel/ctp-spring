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
        <!-- <p>${}</p> -->
        <h1>Hello, listeQuestions</h1>

        <table class="table">
            <tr>
                <th>libelle</th>
                <th>statut</th>
            </tr>
            <% List<Question> data = (List<Question>) request.getAttribute("questions");%>
            <% for(Question question : data) { %>
                <tr>
                    <td>
                        <%= question.libelle()%>
                    </td>
                    <!-- <td>
                        <%= question.getActive()%>
                    </td> -->
                </tr>
            <% }%>
        </table>
    </div>

</body>
</html>






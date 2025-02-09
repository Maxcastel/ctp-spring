
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Ajout d auteur</title>

    <!-- Bootstrap core CSS -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>
<div class="container">
    <div class="page-header">
        <h1>Ajouter un auteur</h1>
    </div>
    <div class="row">
        <div class="col-xs-6 col-xs-offset-3">
            <form action="/pushAuteur" method="post" >
              <div class="form-group">
                <label for="name">Enter your name: </label>
                <input class="form-control" type="text" name="nom" id="nom"  />
              </div>
              <div class="form-group">
                <label for="prenom">Enter your prenom: </label>
                <input class="form-control" type="text" name="prenom" id="prenom"  />
              </div>

              <input type="submit" class="btn btn-primary"  value="Ajoute un Auteur!" />

            </form>
        </div>

    </div>
</div>
</body>
</html>


${error}
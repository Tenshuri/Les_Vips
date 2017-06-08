<table class="table">

    <thead>
    <tr>
        <th>Numéro Visa</th>
        <th>Titre</th>
        <th>Genre</th>
        <th>Année</th>
    </tr>
    </thead>

    <tbody>
    <?php foreach ($films as $film): ?>
    <tr>
            <th scope="row"><?php echo $film['numvisa']; ?></th>
            <td><?php echo $film['titre']; ?></td>
            <td><?php echo $film['libelle']; ?></td>
            <td><?php echo $film['annee']; ?></td>
    </tr>
    <?php endforeach; ?>
    </tbody>

</table>
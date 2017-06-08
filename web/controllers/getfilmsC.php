<?php
require 'models/Film.php';
$filmM = new vips\Film($db);


$films = $filmM->getFilms();
require 'views/getfilmsV.php';

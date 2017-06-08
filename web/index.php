<?php
namespace vips;

// Application VIPs - Point d'entrée

// Dépendances
require './util/db.php';
require './util/helpers.php';
require './models/Model.php';
$db = new DB();

// Routage vers la page demandée en paramètres de l'URL
if (isset($_GET['page'])) {
    if (checkRoute($_GET['page'])) {
        // La route est bonne
        require 'controllers/'.$_GET['page'].'C.php';
    } else {
        // La route n'est pas bonne
        require 'controllers/notfoundC.php';
    }
} else {
    // Aucune route demandée : envoyer sur la page d'accueil
    require 'controllers/homeC.php';
}


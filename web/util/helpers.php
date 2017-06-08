<?php

// Fonctions utilitaires

// Vérifier si une route est valide
function checkRoute($route) {
    return (preg_match("/^[a-z]+$/i", $route) === 1) &&
    (file_exists('controllers/'.$route.'C.php'));
}

<?php
namespace vips;
use vips\Model as Model;

// Modèle relatif à la gestion des sessions
class Film extends Model {

    public function getFilms() {
        $getFilmsReq = "SELECT F.numvisa, F.titre, F.annee, G.libelle
                        FROM film F
                        INNER JOIN genre G ON F.idgenre = G.idgenre;";

        $this->_db->arrayQuery($getFilmsReq);
        return $this->_db->_data;
    }

}

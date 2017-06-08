<?php
namespace vips;

// Il faut hériter de cette classe pour définir les différents modèles nécessaires
abstract class Model {
    protected $_db;

    public function __construct(DB $db) {
        $this->_db = $db;
    }
}
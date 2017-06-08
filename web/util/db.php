<?php
namespace vips;
use \PDO;

class DB {
    private $_db;
    public $_data;
    public $_rowcount;

    function __construct() {
        try {
            $host = 'iutdoua-web.univ-lyon1.fr';
            $dbname = 'p1205854';
            $user = 'p1205854';
            $passw = '172275';
            $this->_db = new PDO('mysql:host='.$host.';dbname='.$dbname, $user, $passw);
            $this->_db->exec('SET NAMES utf8');
            $this->_db->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
        }
        catch (PDOException $e) {
            die('Erreur : '.$e->getMessage());
        }
   }

    public function __destruct() {
        $this->_db = null;
    }

    public function getLastId() {
        // TODO
    }

    public function updateQuery($query, $params = array()) {
        try {
            $prepStmt = $this->_db->prepare($query);
            $prepStmt->execute($params);
        }
        catch (Exception $e) {
            die('Erreur : '.$e->getMessage());
        }
    }

    public function arrayQuery($query, $params = array()) {
        try {
            $prepStmt = $this->_db->prepare($query);
            $prepStmt->execute($params);

            $this->_data = $prepStmt->fetchAll();
            $this->_rowcount = count($this->_data);
        }
        catch (Exception $e) {
            die('Erreur : '.$e->getMessage());
        }
    }

    public function rowQuery($query, $params = array()) {
        try {
            $prepStmt = $this->_db->prepare($query);
            $prepStmt->execute($params);

            $this->_data= $prepStmt->fetch();
            $this->_rowcount = count($this->_rowcount);
        }
        catch (Exception $e) {
            die('Erreur : '.$e->getMessage());
        }
    }
}
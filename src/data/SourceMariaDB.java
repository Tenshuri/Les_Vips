package data;

import org.mariadb.jdbc.MariaDbDataSource;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.net.PasswordAuthentication;
import java.util.Properties;

public class SourceMariaDB {

    public static DataSource getSource(PasswordAuthentication login) throws Exception {
        // récupération des informations d'authentification
        String user = login.getUserName();
        String pwd = new String(login.getPassword());
        // création d'un objet Properties à parir du fichier 
        Properties props = new Properties();
        FileInputStream fichier = new FileInputStream("src/connexion.properties");
        props.load(fichier);
        MariaDbDataSource ds = new MariaDbDataSource();
        ds.setPortNumber(Integer.parseInt(props.getProperty("port")));
        ds.setDatabaseName(props.getProperty("service"));
        ds.setServerName(props.getProperty("serveur"));
        ds.setUser(user);
        ds.setPassword(pwd);
        return ds;
    }
}

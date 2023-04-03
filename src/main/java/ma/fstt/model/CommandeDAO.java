package ma.fstt.model;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CommandeDAO extends BaseDAO<Commande>{
    public CommandeDAO() throws SQLException {

        super();
    }

    @Override
    public void save(Commande object) throws SQLException {

        String request = "insert into commande (datedebut, datefin, km, etat ) values (? , ?, ?, ? )";

        // mapping objet table

        this.preparedStatement = this.connection.prepareStatement(request);
        // mapping
        this.preparedStatement.setString(1 , object.Datedebut());

        this.preparedStatement.setString(2, object.Datedebut()) ;
        this.preparedStatement.setFloat(3 , object.getKm());
        this.preparedStatement.setString(4 , object.getEtat());




        this.preparedStatement.execute();
    }

    @Override
    public void update(Commande object) throws SQLException {

    }

    @Override
    public void delete(Commande object) throws SQLException {

    }

    @Override
    public List<Commande> getAll()  throws SQLException {

        List<Commande> mylist = new ArrayList<Commande>();

        String request = "select * from commande ";

        this.statement = this.connection.createStatement();

        this.resultSet =   this.statement.executeQuery(request);

// parcours de la table
        while ( this.resultSet.next()){

// mapping table objet
          mylist.add(new Commande(this.resultSet.getString(1) ,
                    this.resultSet.getString(2) ,this.resultSet.getFloat(3),this.resultSet.getString(4) ));


        }


        return mylist;
    }

    @Override
    public Commande getOne(Long id) throws SQLException {
        return null;
    }

}
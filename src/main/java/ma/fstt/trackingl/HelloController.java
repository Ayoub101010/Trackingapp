package ma.fstt.trackingl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import ma.fstt.model.Livreur;
import ma.fstt.model.LivreurDAO;
import org.controlsfx.control.spreadsheet.CellGraphicFactory;

import javax.security.auth.callback.Callback;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class HelloController implements Initializable {



    @FXML
    private TextField nom ;


    @FXML
    private TextField tele ;


    @FXML
    private TableView<Livreur> mytable ;


    @FXML
    private TableColumn<Livreur ,Long> col_id ;

    @FXML
    private TableColumn <Livreur ,String> col_nom ;

    @FXML
    private TableColumn <Livreur ,String> col_tele ;


    @FXML
    protected void onSaveButtonClick() {

        // accees a la bdd

        try {
            LivreurDAO livreurDAO = new LivreurDAO();

            Livreur liv = new Livreur(0l , nom.getText() , tele.getText());

            livreurDAO.save(liv);


            UpdateTable();




        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
    @FXML
    protected void onDeleteButtonClick() {
        Livreur selectedlivreur = mytable.getSelectionModel().getSelectedItem();

        if (selectedlivreur!= null) {
            try {
                LivreurDAO liv = new LivreurDAO();

                liv.delete(selectedlivreur);

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            UpdateTable();
        }
    }

    public void UpdateTable(){
        col_id.setCellValueFactory(new PropertyValueFactory<Livreur,Long>("id_livreur"));
        col_nom.setCellValueFactory(new PropertyValueFactory<Livreur,String>("nom"));

        col_tele.setCellValueFactory(new PropertyValueFactory<Livreur,String>("telephone"));



        mytable.setItems(this.getDataLivreurs());
        if(mytable.getColumns().size()<7){
        }
    }

    public static ObservableList<Livreur> getDataLivreurs(){

        LivreurDAO livreurDAO = null;

        ObservableList<Livreur> listfx = FXCollections.observableArrayList();

        try {
            livreurDAO = new LivreurDAO();
            for (Livreur ettemp : livreurDAO.getAll())
                listfx.add(ettemp);

        }catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return listfx ;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        UpdateTable();

    }

}


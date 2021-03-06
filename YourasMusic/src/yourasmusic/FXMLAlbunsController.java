package yourasmusic;

import classes.Album;
import classes.Artista;
import classes.Utilizador;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import yourasmusic.YourasMusic;


public class FXMLAlbunsController implements Initializable {
    
    
    @FXML TilePane tileAlbuns;
    @FXML BorderPane mainPane;
    @FXML ScrollPane scrollPane;
    @FXML ComboBox cmbTipoOrdenacao;
    
    List<Album> albums;
    
    // --- verificar se o user já selecionou no combo box
    Boolean ordenacaoSelecionada;
    
    Session session;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {        
        cmbTipoOrdenacao.getItems().addAll("Ordenar por Ano", "Ordenar por Nome");
        cmbTipoOrdenacao.getSelectionModel().selectFirst();
        
        carregarAlbums();
    }   
    
    private void carregarAlbums(){
        
        session = hibernate.HibernateUtil.getSessionFactory().openSession();        
        //ArrayList<Button> buttons = new ArrayList<>();
        //this.albums = session.createCriteria(Album.class).list();

 
        Query obterAlbuns = session.createQuery("From Album ORDER BY ano DESC");
        obterAlbuns.setFirstResult(0);
        obterAlbuns.setMaxResults(12);
        albums = obterAlbuns.list();

        displayAlbuns();
        session.close();
        
    }
    
    public void buttonClicked(String idAlbum) throws IOException, SQLException{
        Album albumClicado = new Album();
        // --- Iguala o album clicado a um novo album dentro da função
        for(Album a : albums){
            if(String.valueOf(a.getAlbumId()).equals(idAlbum)){
                albumClicado = a;
            }
        }         
        // ---- PASSAR AS INFORMAÇÕES DO ALBUM PARA O FXML DE ALBUM INDIVIDUAL
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("FXMLAlbumIndividual.fxml"));
        
        // ---- ABRIR ALBUM INDIVIDUAL
        YourasMusic.getROOT().setRight(loader.load());
        
        FXMLAlbumIndividualController album = loader.getController();
        album.initData(albumClicado);       
    }
        
    @FXML
    public void ordenarAlbuns(ActionEvent event){
        
        session = hibernate.HibernateUtil.getSessionFactory().openSession();
        
        if(cmbTipoOrdenacao.getValue().toString().equals("Ordenar por Ano")){            
            Query obterAlbuns = session.createQuery("From Album ORDER BY ano DESC");
            obterAlbuns.setFirstResult(0);
            obterAlbuns.setMaxResults(12);
            albums = obterAlbuns.list();
        } else if(cmbTipoOrdenacao.getValue().toString().equals("Ordenar por Nome")){
            Query obterAlbuns = session.createQuery("From Album ORDER BY nome ASC");
            obterAlbuns.setFirstResult(0);
            obterAlbuns.setMaxResults(12);
            albums = obterAlbuns.list();
        }
        
        tileAlbuns.getChildren().clear();
        
        displayAlbuns();
        
        session.close();
    }
    
    
    private void displayAlbuns(){
        for(Album a : albums){
            Button btnAlbuns = new Button();
            String nomeAlbum = a.getNome().toString();
            String ano = a.getAno().toString();

            btnAlbuns.setId("button_tile");
            btnAlbuns.setMinSize(200, 200);
            btnAlbuns.setMaxSize(200, 200);            

            btnAlbuns.setText(nomeAlbum + "\n" + ano);

            // --- Personalização do TilePane
            tileAlbuns.setHgap(20);
            tileAlbuns.setVgap(20);
            tileAlbuns.setAlignment(Pos.TOP_CENTER);
            tileAlbuns.getChildren().add(btnAlbuns);

            // --- Quando o botão é clicado, passa o id do album clicado como parametro
            btnAlbuns.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {

                    try {
                        buttonClicked(String.valueOf(a.getAlbumId()));
                    } catch (IOException ex) {
                        Logger.getLogger(FXMLAlbunsController.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SQLException ex) {
                        Logger.getLogger(FXMLAlbunsController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });

        }
    }
}

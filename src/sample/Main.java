package sample;

import com.sun.org.apache.xml.internal.security.encryption.AgreementMethod;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import sample.OperacionesClientes;
import java.awt.event.ActionEvent;
import java.sql.*;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        root.setStyle("-fx-background-color: #9C7CFF ;");
        AnchorPane Eduardo = new AnchorPane(); //aqui se crea el pane para meter los diseñoas
        TabPane tabpane = new TabPane(); //aqui se crea una tabla de pestañas
        Tab Pestaña1 = new Tab();
        Tab Pestaña2 = new Tab();
        Tab Pestaña3 = new Tab();
        Tab Pestaña4 = new Tab();
        TableView<Cliente> table;
        ObservableList data;
        table = new TableView();
        //creacion de la columna id
        TableColumn IDColl = new TableColumn("ID");
        IDColl.setCellValueFactory(new PropertyValueFactory("clienteId"));
        //cracion de la columna nombre
        TableColumn Nomcoll = new TableColumn("Nombre");
        Nomcoll.setCellValueFactory(new PropertyValueFactory("nombre"));
        //creacion de la columna apellido
        TableColumn ApeColl = new TableColumn("Apellidos");
        ApeColl.setCellValueFactory(new PropertyValueFactory("apellidos"));
        //crecion de la columna direccion
        TableColumn DirecColl = new TableColumn("Dirección");
        DirecColl.setCellValueFactory(new PropertyValueFactory("direccion"));
        //se agreagan las columnas a la tabla
        table.getColumns().setAll(IDColl,Nomcoll,ApeColl, DirecColl);
        table.setPrefWidth(450);
        table.setPrefHeight(300);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        tabpane.setStyle("-fx-background-color: #9C7CFF ;");
        //------------------------------------------------------------------------------------
        DBManager accesoBD = new DBManager();
        accesoBD.getConnection();
        OperacionesClientes opCliente = new OperacionesClientes(accesoBD.getConnection());
        //System.out.println("Nuevo cliente: " + regCliente);
        //opCliente.deleteCliente(12);
        //opCliente.getCliente(12);
        //opCliente.insertCliente("Jorge", "Estrada", "Lázaro Cárdenas 123");
        //-----------------------------------------------------------------------
        Tab Pestaña0 = new Tab();
        Pestaña0.setText("Menus");
        AnchorPane aser = new AnchorPane();
        //--------------------------------------
        Button Agregar = new Button();
        Agregar.setText("Agregar Cliente");
        Agregar.setLayoutX(100);
        Agregar.setLayoutY(100);
        Agregar.setOnMousePressed((MouseEvent evt)-> {
                    tabpane.getTabs().add(Pestaña1);
                    System.out.println(opCliente.getCliente(12));
                }
        );
        aser.getChildren().add(Agregar);
        //------------------------------------------------
        Button Modificar = new Button();
        Modificar.setText("Modificar Cliente");
        Modificar.setLayoutX(100);
        Modificar.setLayoutY(150);
        Modificar.setOnMousePressed((MouseEvent evt)-> {
                    tabpane.getTabs().add(Pestaña2);
                }
        );
        aser.getChildren().add(Modificar);
        //----------------------------------------------------------------
        Button Eliminar = new Button();
        Eliminar.setText("Eliminar Cliente");
        Eliminar.setLayoutX(100);
        Eliminar.setLayoutY(200);
        Eliminar.setOnMousePressed((MouseEvent evt)-> {
                    tabpane.getTabs().add(Pestaña3);
                }
        );
        aser.getChildren().add(Eliminar);
        //-------------------------------------------------------
        //boton para abrir la pestaña consultar donde se abrirar
        Button Consultar = new Button();
        Consultar.setText("Consultar Cliente");
        Consultar.setLayoutX(100);
        Consultar.setLayoutY(250);
        Consultar.setOnMousePressed((MouseEvent evt)-> {
                    tabpane.getTabs().add(Pestaña4);
                }
        );
        aser.getChildren().add(Consultar);
        //todos los botones estaran dentro de las pestaña 0 que es el menu
        Pestaña0.setContent(aser);
        tabpane.getTabs().add(Pestaña0);//no usar los caracteres especiales por posibles problemas
        //---------------------------------------------------------------------------------
        //dentro de la pestañas que se abre por los botones anteriores
        // Creacion de la primera pestaña
        Pestaña1.setText("Agregar Cliente");
        //Creacion del label y el textfield para el nombre
        Label Anom = new Label(" Escribir el Nombre: ");
        Anom.setLayoutX(100);
        Anom.setLayoutY(100);
        Eduardo.getChildren().add(Anom);
        TextField top = new TextField();
        top.setPromptText("Nombre");
        Eduardo.getChildren().add(top);
        top.setLayoutX(220);
        top.setLayoutY(100);
        //Creacion del label y el textfield para el apellido
        Label Aapel = new Label(" Escribir el Apellido: ");
        Aapel.setLayoutX(100);
        Aapel.setLayoutY(130);
        Eduardo.getChildren().add(Aapel);
        TextField top1 = new TextField();
        top1.setPromptText("Apellido");
        Eduardo.getChildren().add(top1);
        top1.setLayoutX(220);
        top1.setLayoutY(130);
        //Creacion del label y el textfield para la direccion
        Label Adirec = new Label(" Escribir la Direccion: ");
        Adirec.setLayoutX(100);
        Adirec.setLayoutY(160);
        Eduardo.getChildren().add(Adirec);
        TextField top2 = new TextField();
        top2.setPromptText("Direccion");
        Eduardo.getChildren().add(top2);
        top2.setLayoutX(220);
        top2.setLayoutY(160);
        //Creacion del boton para agregar datos a la base de datos
        Button Agregar2 = new Button();
        Agregar2.setText("Agregar al Cliente");
        Agregar2.setLayoutX(220);
        Agregar2.setLayoutY(300);
        Eduardo.getChildren().add(Agregar2);
        Agregar2.setOnMousePressed((MouseEvent evt)->{
                    String nom,ape,direc;
                    nom = top.getText();
                    ape = top1.getText();
                    direc = top2.getText();
                    String validar="",validar1="",validar2="";
                    validar = top.getText();
                    validar1 = top1.getText();
                    validar2 = top2.getText();
                    if(validar.equals("")){
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Celda vacia");
                        alert.setHeaderText("La celda de nombre esta vacia");
                        alert.setContentText(null);
                        alert.showAndWait();
                    }else if(validar1.equals("")){
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Celda vacia");
                        alert.setHeaderText("La celda de apellido esta vacia esta vacia");
                        alert.setContentText(null);
                        alert.showAndWait();
                    } else if(validar2.equals("")){
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Celda vacia");
                        alert.setHeaderText("La celda de Direccion esta vacia esta vacia");
                        alert.setContentText(null);
                        alert.showAndWait();
                    } else{
                        //incerta los datos del cliente en la base de datos
                        opCliente.insertCliente(nom,ape,direc);
                        System.out.println("hola");
                    }
                }
        );
        //aqui se hace un evento cuando se precione el boton

        //Agregar en la pestaña 1 el contenido del panel en eduardo
        Pestaña1.setContent(Eduardo);
        //--------------------------------------------------------------------------------------------------------------
        //Creacion del metodo para modificar cliente
        AnchorPane cat = new AnchorPane();
        Pestaña2.setText("Modificar Cliente");
        // creacion del contenido del panel cat
        Label sda = new Label(" Escribir el ID del Cliente: ");
        sda.setLayoutX(100);
        sda.setLayoutY(130);
        cat.getChildren().add(sda);
        TextField hgf = new TextField();
        hgf.setPromptText("ID Cliente");
        cat.getChildren().add(hgf);
        hgf.setLayoutX(280);
        hgf.setLayoutY(130);
        //creacion de label y textfiel del nombre
        Label cat1 = new Label(" Escribir el Nombre del cliente: ");
        cat1.setLayoutX(100);
        cat1.setLayoutY(160);
        cat.getChildren().add(cat1);
        TextField gas = new TextField();
        gas.setPromptText("Nombre");
        cat.getChildren().add(gas);
        gas.setLayoutX(280);
        gas.setLayoutY(160);
        //creacion del label y el textfield del apellido
        Label Jhoedy = new Label(" Escribir el Apellido del cliente: ");
        Jhoedy.setLayoutX(100);
        Jhoedy.setLayoutY(190);
        cat.getChildren().add(Jhoedy);
        TextField Shila = new TextField();
        Shila.setPromptText("Apellido");
        cat.getChildren().add(Shila);
        Shila.setLayoutX(280);
        Shila.setLayoutY(190);
        //creacion del label y el textfield direccion
        Label Pedro = new Label(" Escribir la Direccion del cliente: ");
        Pedro.setLayoutX(100);
        Pedro.setLayoutY(220);
        cat.getChildren().add(Pedro);
        TextField mochila = new TextField();
        mochila.setPromptText("Direccion");
        cat.getChildren().add(mochila);
        mochila.setLayoutX(280);
        mochila.setLayoutY(220);
        // cracion del botton para guardar los datos en el panel de cat
        Button Guard = new Button();
        Guard.setText("Guardar Datos Nuevos");
        Guard.setLayoutX(100);
        Guard.setLayoutY(250);
        cat.getChildren().add(Guard);
        gas.setEditable(false);
        Shila.setEditable(false);
        mochila.setEditable(false);
        //aqui se hace un evento cuando se precione el boton
        Guard.setOnMousePressed((MouseEvent evt)->{
                    String validar="",validar1="",validar2="";
                    validar = gas.getText();
                    validar1 = Shila.getText();
                    validar2 = mochila.getText();
                    if(validar.equals("")){
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Celda vacia");
                        alert.setHeaderText("La celda de nombre esta vacia");
                        alert.setContentText(null);
                        alert.showAndWait();
                    }else if(validar1.equals("")){
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Celda vacia");
                        alert.setHeaderText("La celda de apellido esta vacia esta vacia");
                        alert.setContentText(null);
                        alert.showAndWait();
                    } else if(validar2.equals("")){
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Celda vacia");
                        alert.setHeaderText("La celda de Direccion esta vacia esta vacia");
                        alert.setContentText(null);
                        alert.showAndWait();
                    } else{
                        //incerta los datos del cliente en la base de datos
                        gas.setEditable(true);
                        Shila.setEditable(true);
                        mochila.setEditable(true);
                        int t= Integer.parseInt(hgf.getText());
                        opCliente.modificarCliente(t,gas.getText(),Shila.getText(),mochila.getText());
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("se a guardado los nuevos datos");
                        alert.setHeaderText("los nuevos datos se han guardado porfavor verifique con la pestaña de consultar");
                        alert.setContentText(null);
                        alert.showAndWait();
                    }
                }
        );
        // cracion del botton para guardar los datos en el panel de cat
        Button confirmar = new Button();
        confirmar.setText("Confirmar si existe el ID");
        confirmar.setLayoutX(280);
        confirmar.setLayoutY(250);
        cat.getChildren().add(confirmar);
        //aqui se hace un evento cuando se precione el boton
        confirmar.setOnMousePressed((MouseEvent evt)->{
            if(hgf.getText().length()==0){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("la casilla id esta vacia");
                alert.setHeaderText("esta vacia la casilla de id");
                alert.setContentText(null);
                alert.showAndWait();
            }else{
                int id=Integer.parseInt(hgf.getText());
                int prueba = opCliente.consultar(id);
                if(prueba==1){
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Si existe el id");
                    alert.setHeaderText("se a encontrado los datos solicitados y estan listos para ser modificados");
                    alert.setContentText(null);
                    alert.showAndWait();
                    hgf.setEditable(false);
                    gas.setEditable(true);
                    Shila.setEditable(true);
                    mochila.setEditable(true);
                    String nom = gas.getText();
                    String ape = gas.getText();
                    String direc = gas.getText();
                    Cliente sS = opCliente.getCliente(id);
                    gas.setText(sS.getNombre());
                    Shila.setText(sS.getApellidos());
                    mochila.setText(sS.getDireccion());
                }else{
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("el id es incorrecto");
                    alert.setHeaderText("no existe");
                    alert.setContentText(null);
                    alert.showAndWait();

                }
            }
        });
        Pestaña2.setContent(cat);
        //-------------------------------------------------------------------------------------------------------------------
        AnchorPane pop = new AnchorPane();
        Pestaña3.setText("Eliminar Cliente");
        Label Elid = new Label(" Escribir el ID del Cliente: ");
        Elid.setLayoutX(100);
        Elid.setLayoutY(130);
        pop.getChildren().add(Elid);
        TextField to1 = new TextField();
        to1.setPromptText("ID Cliente");
        pop.getChildren().add(to1);
        to1.setLayoutX(250);
        to1.setLayoutY(130);
        Pestaña3.setContent(pop);
        //cracion del boton de eliminar
        Button Eliminar1 = new Button();
        Eliminar1.setText("Eliminar al Cliente");
        Eliminar1.setLayoutX(220);
        Eliminar1.setLayoutY(170);
        pop.getChildren().add(Eliminar1);
        //aqui se hace un evento cuando se precione el boton
        Eliminar1.setOnMousePressed((MouseEvent evt)->{
            if(to1.getText().length()==0){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("la casilla id esta vacia");
                alert.setHeaderText("esta vacia la casilla de id");
                alert.setContentText(null);
                alert.showAndWait();
            }else {
                int id = Integer.parseInt(to1.getText());
                int prueba = opCliente.deleteCliente(id);
                if (prueba == 1) {
                    id = Integer.parseInt(to1.getText());
                    opCliente.deleteCliente(id);
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("el cliente a sido borrado");
                    alert.setHeaderText("ya se elimino al cliente de la base de datos");
                    alert.setContentText(null);
                    alert.showAndWait();
                } else {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("el id es incorrecto");
                    alert.setHeaderText("no existe");
                    alert.setContentText(null);
                    alert.showAndWait();
                }

            }
        });

        //---------------------------------------------------------------------------------------------------------------------
        AnchorPane Sais = new AnchorPane();

        Pestaña4.setText("Consultar Cliente");
        Label app = new Label(" Consultar (ID): ");
        app.setLayoutX(100);
        app.setLayoutY(380);
        Sais.getChildren().add(app);
        TextField trac = new TextField();
        trac.setPromptText("ID");
        Sais.getChildren().add(trac);
        trac.setLayoutX(220);
        trac.setLayoutY(380);
        //
        Label frew = new Label(" Consultar (Apellido): ");
        frew.setLayoutX(100);
        frew.setLayoutY(410);
        Sais.getChildren().add(frew);
        TextField feds = new TextField();
        feds.setPromptText("Apellido");
        Sais.getChildren().add(feds);
        feds.setLayoutX(220);
        feds.setLayoutY(410);

        //Consultar por apllido boton
        Button Apellido6 = new Button();
        Apellido6.setText("Consultar por apellido");
        Apellido6.setLayoutX(350);
        Apellido6.setLayoutY(450);
        Apellido6.setOnMousePressed((MouseEvent evt)-> {
                    if(feds.getText().length()==0){
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("la casilla Apellido esta vacia");
                        alert.setHeaderText("esta vacia la casilla de Apellido");
                        alert.setContentText(null);
                        alert.showAndWait();
                    }else {
                        String apellido = feds.getText();
                        Cliente sS = opCliente.getCliente(apellido);
                        if (sS != null) {
                            ObservableList data2 = FXCollections.observableList(opCliente.fes(feds.getText()));
                            table.setItems(data2);
                            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setTitle("Si existe el id");
                            alert.setHeaderText("se a encontrado los datos solicitados");
                            alert.setContentText(null);
                            alert.showAndWait();
                        } else {
                            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setTitle("el id es incorrecto");
                            alert.setHeaderText("no existe");
                            alert.setContentText(null);
                            alert.showAndWait();
                        }
                    }
                }
        );
        //consultar por id boton
        Button ID = new Button();
        ID.setText("Consultar por ID");
        ID.setLayoutX(220);
        ID.setLayoutY(450);
        ID.setOnMousePressed((MouseEvent evt)-> {

                    if(trac.getText().length()==0){
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("la casilla id esta vacia");
                        alert.setHeaderText("esta vacia la casilla de id");
                        alert.setContentText(null);
                        alert.showAndWait();
                    }else {
                        int id = Integer.parseInt(trac.getText());
                        Cliente sS = opCliente.getCliente(id);
                        if (sS != null) {
                            ObservableList data1 = FXCollections.observableList(opCliente.gar(Integer.parseInt(trac.getText())));
                            table.setItems(data1);
                            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setTitle("Si existe el id");
                            alert.setHeaderText("se a encontrado los datos solicitados");
                            alert.setContentText(null);
                            alert.showAndWait();
                        } else {
                            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setTitle("el id es incorrecto");
                            alert.setHeaderText("no existe");
                            alert.setContentText(null);
                            alert.showAndWait();
                        }
                    }
                }
        );
        Sais.getChildren().add(table);
        Sais.getChildren().add(Apellido6);
        Sais.getChildren().add(ID);
        Pestaña4.setContent(Sais);
        //---------------------------------------------------------------------
        // Creaciion de muestra de scena
        primaryStage.setScene(new Scene(tabpane,600,600));// se agrega las pestañas
        primaryStage.setTitle("Hello World");
        primaryStage.show();
        //primaryStage.setScene(new Scene(root, 300, 1000));
    }


    public static void main(String[] args) {
        launch(args);
    }
}

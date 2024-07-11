package Controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;

import bo.BoFactory;
import bo.custom.CategoryBo;
import dto.CategoryDto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Color;
import view.Tm.CategoryTm;

public class CategoryController {

    @FXML
    private TableColumn<CategoryTm, Integer> colid;

    @FXML
    private TableColumn<CategoryTm, String> colname;

    @FXML
    private TableView<CategoryTm> table;

    @FXML
    private TableColumn<CategoryTm, Button> coldelete;

    @FXML
    private TextField catName;



    private Integer id;
    CategoryBo bo = BoFactory.getInstant().getBo(BoFactory.botype.CATEGORY);

    public void initialize() throws ClassNotFoundException, SQLException {
      getCategory();
      colid.setCellValueFactory(new PropertyValueFactory<>("CategoryID"));
      colname.setCellValueFactory(new PropertyValueFactory<>("CategoryName"));
      coldelete.setCellValueFactory(new PropertyValueFactory<>("btnDelete"));
    }

    public void getCategory(){
        try {
            ArrayList<CategoryDto> categoryDtos = bo.getAllCategory();
            ObservableList<CategoryTm> tmList = FXCollections.observableArrayList();
            for(CategoryDto cat : categoryDtos){
                Button btnDelete = new Button("Delete");
                btnDelete.setMaxSize(100, 50);
                btnDelete.setCursor(Cursor.HAND);
                btnDelete.setStyle("-fx-background-color:red; -fx-font-weight:bold");
                btnDelete.setTextFill(Color.web("white"));
                CategoryTm categoryTm = new CategoryTm(cat.getCategoryID(), cat.getCategoryName(), btnDelete);
                tmList.add(categoryTm);
                btnDelete.setOnAction((e) -> {
                   ButtonType ok=new ButtonType("yes",ButtonBar.ButtonData.OK_DONE);
                   ButtonType no=new ButtonType("no",ButtonBar.ButtonData.CANCEL_CLOSE); 
                   Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure ?", ok, no);
                   Optional<ButtonType> result = alert.showAndWait();
                   if(result.orElse(no)==ok){
                        try {
                            if(bo.deleteCategory(categoryTm.getCategoryID())){
                                new Alert(AlertType.CONFIRMATION, "Customer is deleted.!").show();
                                getCategory();
                               
                            return;
                            }
                        } catch (Exception e1) {
                           
                            e1.printStackTrace();
                        }
                   }
                });

            }
            table.setItems(tmList);
            table.setRowFactory(tv -> {
                TableRow<CategoryTm> row = new TableRow<>();
                row.setOnMouseClicked(event -> {
                    if (!row.isEmpty()) {
                        CategoryTm rowData = row.getItem();
                        System.out.println("Clicked Row: " + rowData.getCategoryID() + " " + rowData.getCategoryName());
                        id = rowData.getCategoryID();
                        catName.setText(rowData.getCategoryName());
                    }
                });
                return row;

            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //-------------------------- your name is here -----------------
     @FXML
    void btnAddOnAction(ActionEvent event) {
        System.out.println("hello");
        try {
            ButtonType ok=new ButtonType("yes",ButtonBar.ButtonData.OK_DONE);
            ButtonType no=new ButtonType("no",ButtonBar.ButtonData.CANCEL_CLOSE); 
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure ?", ok, no);
            Optional<ButtonType> result = alert.showAndWait();
            if(result.orElse(no)==ok){
                boolean isSaved = bo.saveCategory(new CategoryDto(0, catName.getText()));
                if(isSaved){
                     new Alert(AlertType.CONFIRMATION, "Category is Added.!").show();
                      getCategory();
                      catName.setText("");
                      return;
                }else{
                    new Alert(AlertType.ERROR,"Catehory Adding Failed").show();
                }
              
            }    
        } catch (Exception e) {
            new Alert(AlertType.ERROR, "Error"+e).show();
        }
        catName.setText("");
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        System.out.println("hello");
        try {
            ButtonType ok=new ButtonType("yes",ButtonBar.ButtonData.OK_DONE);
            ButtonType no=new ButtonType("no",ButtonBar.ButtonData.CANCEL_CLOSE); 
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure ?", ok, no);
            Optional<ButtonType> result = alert.showAndWait();
            if(result.orElse(no)==ok){
                boolean isSaved = bo.updateCategory(new CategoryDto(id, catName.getText()));
                if(isSaved){
                     new Alert(AlertType.CONFIRMATION, "Category is Updated.!").show();
                      getCategory(); 
                      catName.setText("");
                      return;
                }else{
                    new Alert(AlertType.ERROR,"Catehory Updating Failed").show();
                }
              
            }    
        } catch (Exception e) {
            new Alert(AlertType.ERROR, "Error"+e).show();
        }
        catName.setText("");
    }
    //Crud
    // create 
    //read
    //update
    //delete   
}

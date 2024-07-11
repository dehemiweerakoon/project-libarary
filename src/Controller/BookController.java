package Controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;

import bo.BoFactory;
import bo.custom.BookBo;
import bo.custom.CategoryBo;
import dto.BookDto;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Color;
import view.Tm.BookTm;

public class BookController {
    @FXML
    private TableColumn<BookTm, String> colAuthor;

    @FXML
    private TableColumn<BookTm, String> colCategory;

    @FXML
    private TableColumn<BookTm, Button> coldelete;

    @FXML
    private TableColumn<BookTm, Integer> colid;

    @FXML
    private TableColumn<BookTm, String> colpublisher;

    @FXML
    private TableColumn<BookTm, String> coltitle;

    @FXML
    private TableColumn<BookTm, Integer> colyear;

    @FXML
    private TableView<BookTm> table;

    @FXML
    private ComboBox<String> cmbcategory;

    @FXML
    private TableColumn<BookTm,Integer> colQty;

    @FXML
    private TextField txtAuthor;

    @FXML
    private TextField txtPublisher;

    @FXML
    private TextField txtTitle;

    @FXML
    private TextField txtYear;

    @FXML
    private TextField txtQty;

    private Integer id;
    BookBo bo = BoFactory.getInstant().getBo(BoFactory.botype.BOOK);
    CategoryBo categoryBo = BoFactory.getInstant().getBo(BoFactory.botype.CATEGORY);

   

     public void initialize() throws ClassNotFoundException, SQLException {
        getBook();

        getAllCategories();

        colid.setCellValueFactory(new PropertyValueFactory<>("BookID"));
        coltitle.setCellValueFactory(new PropertyValueFactory<>("Title"));
        colAuthor.setCellValueFactory(new PropertyValueFactory<>("Author"));
        colCategory.setCellValueFactory(new PropertyValueFactory<>("Category"));
        colyear.setCellValueFactory(new PropertyValueFactory<>("Year"));
        colpublisher.setCellValueFactory(new PropertyValueFactory<>("Publisher"));
        coldelete.setCellValueFactory(new PropertyValueFactory<>("btnDelete"));
        colQty.setCellValueFactory(new PropertyValueFactory<>("qty"));
     }

     public void getBook(){
       try {
        ArrayList<BookDto> books = bo.getAllBook();
        ObservableList<BookTm> tmlList = FXCollections.observableArrayList();
        for(BookDto book : books){
                Button btnDelete = new Button("Delete");
                btnDelete.setMaxSize(100, 50);
                btnDelete.setCursor(Cursor.HAND);
                btnDelete.setStyle("-fx-background-color:red; -fx-font-weight:bold");
                btnDelete.setTextFill(Color.web("white"));
                BookTm bookTm = new BookTm(book.getBookID(), book.getTitle(), book.getAuthor(), book.getCategory(), book.getYear(), book.getPublisher(),book.getQty() ,btnDelete);
                tmlList.add(bookTm);
           btnDelete.setOnAction((e)->{
                   ButtonType ok=new ButtonType("yes",ButtonBar.ButtonData.OK_DONE);
                   ButtonType no=new ButtonType("no",ButtonBar.ButtonData.CANCEL_CLOSE); 
                   Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure ?", ok, no);
                   Optional<ButtonType> result = alert.showAndWait();
                   if(result.orElse(no)==ok){
                    try {
                        if(bo.deleteBook(book.getBookID())){
                          new Alert(AlertType.CONFIRMATION, "Book is deleted.!").show();
                            getBook();
                            return;
                        }
                    } catch (Exception e1) {
                       System.out.println(e1);
                    }
                   }
           });
        }
        table.setItems(tmlList);
        table.setRowFactory(tv -> {
                TableRow<BookTm> row = new TableRow<>();
                row.setOnMouseClicked(event -> {
                    if (!row.isEmpty()) {
                        BookTm rowData = row.getItem();
                        id = rowData.getBookID();
                        txtPublisher.setText(rowData.getPublisher());
                        txtAuthor.setText(rowData.getAuthor());
                        txtTitle.setText(rowData.getTitle());
                        txtYear.setText(rowData.getYear()+"");
                        cmbcategory.setValue(rowData.getCategory());
                        txtQty.setText(rowData.getQty()+"");
                    }
                });
                return row;

            });
    } catch (Exception e) {
       
        e.printStackTrace();
    } 
     }
     public void getAllCategories(){
        ObservableList<String> categoryList = FXCollections.observableArrayList();
        try {
            ArrayList<CategoryDto> allCategories = categoryBo.getAllCategory();
            for(CategoryDto cat : allCategories){
                categoryList.add(cat.getCategoryName());
            }
            cmbcategory.setItems(categoryList);
        } catch (Exception e) {
           
        }
     }
     @FXML
    void OnActionAdd(ActionEvent event) {
    try {
         String title = txtTitle.getText();
      String Author = txtAuthor.getText();
      String publisher = txtPublisher.getText();
      int year = Integer.parseInt(txtYear.getText());
      String category = cmbcategory.getValue();
      int qty = Integer.parseInt(txtQty.getText());
      ButtonType ok=new ButtonType("yes",ButtonBar.ButtonData.OK_DONE);
      ButtonType no=new ButtonType("no",ButtonBar.ButtonData.CANCEL_CLOSE); 
      Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure ?", ok, no);
      Optional<ButtonType> result = alert.showAndWait();
      if(result.orElse(no)==ok){
        try {
            if(bo.saveBook(new BookDto(0, title, Author, category, year, publisher,qty))){
                new Alert(AlertType.CONFIRMATION,"Book is Saved !").show();
                getBook();
            }
        } catch (Exception e) {
            new Alert(AlertType.ERROR, "Book Save Errors").show();
            e.printStackTrace();
        }
      }
      txtTitle.setText("");
      txtAuthor.setText("");
      txtPublisher.setText("");
      txtYear.setText("");
    } catch (Exception e) {
        new Alert(AlertType.ERROR, "Please fill all book details"+e).show();
    }
     
    }

    @FXML
    void OnActionUpdate(ActionEvent event) {
    try {
         String title = txtTitle.getText();
        String Author = txtAuthor.getText();
        String publisher = txtPublisher.getText();
        int year = Integer.parseInt(txtYear.getText());
        String category = cmbcategory.getValue();
        int qty = Integer.parseInt(txtQty.getText());
        ButtonType ok=new ButtonType("yes",ButtonBar.ButtonData.OK_DONE);
        ButtonType no=new ButtonType("no",ButtonBar.ButtonData.CANCEL_CLOSE); 
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure ?", ok, no);
        Optional<ButtonType> result = alert.showAndWait();
        if(result.orElse(no)==ok){
          try {
              if(bo.updateBook(new BookDto(id, title, Author, category, year, publisher,qty))){
                  new Alert(AlertType.CONFIRMATION,"Book is Saved !").show();
                  getBook();
              }
          } catch (Exception e) {
              new Alert(AlertType.ERROR, "Book Save Errors").show();
              e.printStackTrace();
          }
        }
        txtTitle.setText("");
        txtAuthor.setText("");
        txtPublisher.setText("");
        txtYear.setText("");
    } catch (Exception e) {
        new Alert(AlertType.ERROR, "Please select A book To update from table").show();
    }
       
    }
}

package Controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import bo.BoFactory;
import bo.custom.BookBo;
import bo.custom.BorrowBo;
import bo.custom.MemberBo;
import dto.BookDto;
import dto.BorrowDto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class BorrowController {
    @FXML
    private DatePicker dateissue;

    @FXML
    private TextField txtBookId;

    @FXML
    private TextField txtmemberId;

    private BookDto bookDto;

    private BookBo bookBo = BoFactory.getInstant().getBo(BoFactory.botype.BOOK);
    private MemberBo memberBo = BoFactory.getInstant().getBo(BoFactory.botype.MEMBER);
    private BorrowBo borrowBo = BoFactory.getInstant().getBo(BoFactory.botype.BORROW);
    private Boolean bval=false;
    private Boolean mval=false;

    @FXML
    void OnBookCheck(ActionEvent event)  {
      int book_id = Integer.parseInt(txtBookId.getText());
      try {
        bookDto = bookBo.getBook(book_id);
        if(bookDto.getQty()==0){
            new Alert(AlertType.ERROR,"All books are issued on this").show();
            txtBookId.setText("");
        }else{
            bval=true;
        }
    } catch (Exception e) {
        new Alert(AlertType.ERROR,"No book avaliable").show();
        txtBookId.setText("");
    }
    }

    @FXML
    void OnMemeberCheck(ActionEvent event) {
   
    try {
        int member_id = Integer.parseInt(txtmemberId.getText());
        if(memberBo.getMember(member_id)==null){
            new Alert(AlertType.ERROR,"Not A valid member").show();
            txtmemberId.setText("");
            
        }else{
            mval=true;
        }
    } catch (Exception e) {
        new Alert(AlertType.ERROR,"Not A valid a member").show();
    }
    }

    @FXML
    void onButtonIssue(ActionEvent event) {
      int member_id = Integer.parseInt(txtmemberId.getText());
      Date currentDate = new Date();
        
      // Create a SimpleDateFormat instance
      SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
      
      // Create a Calendar instance and set it to the current date
      Calendar calendar = Calendar.getInstance();
      calendar.setTime(currentDate);
      
      // Add 10 days to the current date
      calendar.add(Calendar.DAY_OF_MONTH, 10);
      
      // Get the new date
      Date futureDate = calendar.getTime();
      
      // Format and print the current and future dates
      String currentDateString = formatter.format(currentDate);
      String futureDateString = formatter.format(futureDate);
      if(mval && bval){
        Boolean isSaved;
        try {
            if(bookDto.getQty()>0){
                int new_qty = bookDto.getQty()-1;
                 isSaved = borrowBo.saveBorrow(new BorrowDto(0, member_id,bookDto.getBookID(),currentDateString+"",futureDateString+""),new BookDto(bookDto.getBookID(), bookDto.getTitle(), bookDto.getAuthor(), bookDto.getCategory(), bookDto.getYear(),bookDto.getPublisher(),new_qty));
                 if(isSaved){
                    new Alert(AlertType.CONFIRMATION,"Book Has Issued").show();
                 }else{
                    new Alert(AlertType.ERROR,"Book Issue Error").show();
                 }
            }
        } catch (Exception e) {
            new Alert(AlertType.ERROR,"Book Issue Error").show();
        }
       
      }
    }
}

package Controller;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import bo.BoFactory;
import bo.custom.BookBo;
import bo.custom.BorrowBo;
import bo.custom.MemberBo;
import bo.custom.ReturnBo;
import dto.BookDto;
import dto.BorrowDto;
import dto.MemberDto;
import dto.ReturnDto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class ReturnController {
      @FXML
    private ComboBox<Integer> txtbook;

    @FXML
    private TextField txtmember;

    @FXML
    private ComboBox<Integer> txtborrowId;

    private BookBo bookbo = BoFactory.getInstant().getBo(BoFactory.botype.BOOK);
    private MemberBo memberBo = BoFactory.getInstant().getBo(BoFactory.botype.MEMBER);
    private BorrowBo borrowBo = BoFactory.getInstant().getBo(BoFactory.botype.BORROW);
    private BookDto bookDto;
    private MemberDto memberDto;
    private BorrowDto borrowDto;
    ArrayList<BorrowDto> borrowDtos;
    private ReturnBo returnBo = BoFactory.getInstant().getBo(BoFactory.botype.RETURN);
    
    @FXML
    void OnReturnClicked(ActionEvent event) {
       getBookAndMember();


       SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
       Date currentDate = new Date();
       Calendar calendar = Calendar.getInstance();
       calendar.setTime(currentDate);
       String currentDateString = formatter.format(currentDate);

        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        LocalDate date1 = LocalDate.parse(currentDateString, formatter2);
        LocalDate date2 = LocalDate.parse(borrowDto.getDue_date(), formatter2);
        
        // Calculate the difference in days
        int daysBetween = (int)ChronoUnit.DAYS.between(date1, date2);
        int wandi =0;
        if(daysBetween>10){
           wandi=(daysBetween-10)*2;
        }

        MemberDto new_memberDto = new MemberDto(memberDto.getId(), memberDto.getName(), memberDto.getContactNo(), memberDto.getAddress(),wandi);
        BookDto new_bookDto = new BookDto(bookDto.getBookID(), bookDto.getTitle(),bookDto.getAuthor(),bookDto.getCategory(), bookDto.getYear(), bookDto.getPublisher(),bookDto.getQty()+1);
       try {
       Boolean isSaved = returnBo.saveReturn(new ReturnDto(0, borrowDto.getMember_id(), borrowDto.getBook_id(), borrowDto.getIssue_date(), borrowDto.getDue_date(),currentDateString), new_bookDto,new_memberDto);
       if(isSaved){
        new Alert(AlertType.CONFIRMATION,"Book is Returned").show();
       }
      } catch (Exception e) {
        e.printStackTrace();
      }
    } 

    void getBookAndMember(){
       try {
        bookDto = bookbo.getBook(txtbook.getValue());
        memberDto = memberBo.getMember(Integer.parseInt(txtmember.getText()));
       
      } catch (NumberFormatException e) {
        
        e.printStackTrace();
      } catch (Exception e) {
        
        e.printStackTrace();
      }
    }        

    @FXML
    void onSerachClicked(ActionEvent event) {
      try {
       borrowDtos = borrowBo.getMemberBorrowList(Integer.parseInt(txtmember.getText()));
       ObservableList<Integer> obsList = FXCollections.observableArrayList();
       for(BorrowDto bDto:borrowDtos){
        obsList.add(bDto.getBook_id());
       }
       txtbook.setItems(obsList);

    } catch (NumberFormatException e) {
       
        e.printStackTrace();
    } catch (Exception e) {
       
        e.printStackTrace();
    }
    }
    @FXML
    void OnbookIdAction(ActionEvent event) {
      int val = txtbook.getSelectionModel().getSelectedIndex();
      borrowDto= borrowDtos.get(val);
    }
}

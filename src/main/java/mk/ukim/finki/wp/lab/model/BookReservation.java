package mk.ukim.finki.wp.lab.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class BookReservation {


    String bookTitle;
    String readerName;
    String readerAddress;
    Long numberOfCopies;

    public BookReservation(String bookTitle, String readerName, String readerAddress, Long numberOfCopies) {
        this.bookTitle = bookTitle;
        this.readerName = readerName;
        this.readerAddress = readerAddress;
        this.numberOfCopies = numberOfCopies;
    }

    public BookReservation() {
        this.bookTitle = "";
        this.readerName = "";
        this.readerAddress = "";
        this.numberOfCopies = 0L;
    }
}

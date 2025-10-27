package mk.ukim.finki.wp.lab.repository.implementation;

import mk.ukim.finki.wp.lab.bootstrap.DataHolder;
import mk.ukim.finki.wp.lab.model.BookReservation;
import mk.ukim.finki.wp.lab.repository.BookReservationRepository;
import org.springframework.stereotype.Repository;

@Repository
public class InMemoryBookReservationRepository implements BookReservationRepository {
    private final DataHolder dataHolder;

    public InMemoryBookReservationRepository() {
        this.dataHolder = new DataHolder();
    }

    @Override
    public BookReservation save(BookReservation reservation) {
        dataHolder.addReservation(reservation);
        return reservation;
    }
}

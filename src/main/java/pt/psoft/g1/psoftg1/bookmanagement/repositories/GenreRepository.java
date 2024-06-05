package pt.psoft.g1.psoftg1.bookmanagement.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.util.Pair;
import pt.psoft.g1.psoftg1.bookmanagement.api.GenreLendingsPerMonthView;
import pt.psoft.g1.psoftg1.bookmanagement.model.Genre;
import pt.psoft.g1.psoftg1.bookmanagement.services.GenreBookCountDTO;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface GenreRepository {

    Iterable<Genre> findAll();
    Optional<Genre> findByString(String genreName);
    Genre save(Genre genre);
    Page<GenreBookCountDTO> findTop5GenreByBookCount(Pageable pageable);
    List<Pair<Genre, Double>> getAverageLendings(String period, LocalDate startDate, LocalDate endDate);
    List<GenreLendingsPerMonthView> getLendingsPerMonthLastYearByGenre();
}

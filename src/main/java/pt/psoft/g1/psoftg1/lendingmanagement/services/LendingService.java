package pt.psoft.g1.psoftg1.lendingmanagement.services;

import pt.psoft.g1.psoftg1.lendingmanagement.model.Lending;
import java.util.Optional;

public interface LendingService {
    /**
     *
     * @param lendingNumber
     * @return {@code Optional<Lending>}
     */
    Optional<Lending> findByLendingNumber(String lendingNumber);
    Iterable<Lending> findAll();

    Iterable<Lending> listByReaderNumberAndIsbn(String readerNumber, String isbn);

    Lending create(CreateLendingRequest resource); //No ID passed, as it is auto generated

    Lending setReturned(String id, SetLendingReturnedDto resource, long desiredVersion);



}

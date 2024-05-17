package pt.psoft.g1.psoftg1.readermanagement.infraestructure.repositories.impl;

import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import pt.psoft.g1.psoftg1.readermanagement.model.ReaderDetails;
import pt.psoft.g1.psoftg1.readermanagement.repositories.ReaderRepository;

import java.util.Optional;


public interface SpringDataReaderRepositoryImpl extends ReaderRepository, CrudRepository<ReaderDetails, Long> {
    @Override
    @Query("SELECT r " +
            "FROM ReaderDetails r " +
            "WHERE r.readerNumber.readerNumber = :readerNumber")
    Optional<ReaderDetails> findByReaderNumber(@Param("readerNumber") @NotNull String readerNumber);

    @Override
    @Query("SELECT r " +
            "FROM ReaderDetails r " +
            "JOIN User u ON r.reader.id = u.id " +
            "WHERE u.username = :username")
    Optional<ReaderDetails> findByUsername(@Param("username") @NotNull String username);

    @Override
    @Query("SELECT r " +
            "FROM ReaderDetails r " +
            "JOIN User u ON r.reader.id = u.id " +
            "WHERE u.id = :userId")
    Optional<ReaderDetails> findByUserId(@Param("userId") @NotNull Long userId);


    @Override
    @Query("SELECT COUNT (rd) " +
            "FROM ReaderDetails rd " +
            "JOIN User u ON rd.reader.id = u.id " +
            "WHERE YEAR(u.createdAt) = YEAR(CURRENT_DATE)")
    int getCountFromCurrentYear();

/*
    @Override
    @Modifying
    @Query("UPDATE Reader r SET "+
            "r.fullName = COALESCE(:name, r.fullName), " +
            "r.phoneNumber = COALESCE(:phoneNumber, r.phoneNumber), " +
            "r.birthDate = COALESCE(:birthDate, r.birthDate), " +
            "r.marketingConsent = COALESCE(:marketing, r.marketingConsent), " +
            "r.thirdPartySharingConsent = COALESCE(:thirdParty, r.thirdPartySharingConsent) " +
            "WHERE r.readerNumber = :readerNumber")
    public Optional<Reader> updateReader(@Param("readerNumber") @NotNull String readerNumber, @Param("readerName") String name, @Param("readerPhoneNumber") String phoneNumber, @Param("birthDate") LocalDate birthDate, @Param("marketing") boolean marketing, @Param("thirdParty") boolean thirdParty);
*/

/*
    @Override
    @Query("UPDATE User u SET " +
            "u.username = COALESCE(:username, u.username), "+
            "u.password = COALESCE(:password, u.password) "+
            "WHERE u.id = :userNumber")
    public void updateUser(@Param("userNumber") @NotNull Long userNumber, @Param("username") String username, @Param("password") String password);
*/


}

package pt.psoft.g1.psoftg1.authormanagement.services;

import pt.psoft.g1.psoftg1.authormanagement.model.Author;
import pt.psoft.g1.psoftg1.authormanagement.model.AuthorCountDTO;


import java.util.List;
import java.util.Optional;

public interface AuthorService {

    Iterable<Author> findAll();

    Optional<Author> findByAuthorNumber(Long authorNumber);
    List<Author> findByName(String name);

    Author create(CreateAuthorRequest resource);

    Author partialUpdate(Long authornumber, UpdateAuthorRequest resource, long desiredVersion);

    List<Author> findTopAuthorByLendings();
}

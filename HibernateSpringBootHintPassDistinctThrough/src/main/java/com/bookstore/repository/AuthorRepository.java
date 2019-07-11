package com.bookstore.repository;

import com.bookstore.entity.Author;
import java.util.List;
import javax.persistence.QueryHint;
import static org.hibernate.jpa.QueryHints.HINT_PASS_DISTINCT_THROUGH;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    @Transactional(readOnly = true)
    @Query("SELECT a FROM Author a LEFT JOIN FETCH a.books")
    List<Author> fetchWithDuplicates();

    @Transactional(readOnly = true)
    @Query("SELECT DISTINCT a FROM Author a LEFT JOIN FETCH a.books")
    List<Author> fetchWithoutHint();

    @Transactional(readOnly = true)
    @Query("SELECT DISTINCT a FROM Author a LEFT JOIN FETCH a.books")
    @QueryHints(value = @QueryHint(name = HINT_PASS_DISTINCT_THROUGH, value = "false"))
    List<Author> fetchWithHint();
}

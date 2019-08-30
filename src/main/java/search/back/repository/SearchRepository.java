package search.back.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import search.back.model.Search;
import search.back.model.User;

import java.util.List;

@Repository
public interface SearchRepository extends CrudRepository<Search, Long> {

    List<Search> findByUser(User user);
    Page<Search> findByUser(User user, Pageable pageable);

}

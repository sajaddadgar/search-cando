package search.back.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import search.back.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findByEmail(String email);
}

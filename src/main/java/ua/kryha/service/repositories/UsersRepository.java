package ua.kryha.service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.kryha.service.models.JUser;

import java.util.List;
import java.util.Optional;

public interface UsersRepository extends JpaRepository<JUser, Long> {
    List<JUser> findAllByFirstName(String firstName);

    Optional<JUser> findOneByLogin(String login);
}

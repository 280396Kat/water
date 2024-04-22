package ru.it2g.h2o.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.it2g.h2o.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

    Optional<User> findByMail(String email);
}

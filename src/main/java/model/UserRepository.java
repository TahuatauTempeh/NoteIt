package model;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
//    methods

//    finding a user based on their username
    Optional<User> findByUsername(String username);

//    finding a user based on their email
    Optional<User> findByEmail(String email);

//    check if that user exists based on their username
    boolean isUserExistByUsername(String username);

//    check if that user exists based on their email
    boolean isUserExistByEmail(String email);
}

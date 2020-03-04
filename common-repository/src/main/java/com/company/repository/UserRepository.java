package com.company.repository;

import com.company.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findByEmail(String email);

    boolean existsUserByEmail(String email);

    @Modifying
    @Query("update User u set u.isBanned = :is_banned where u.email = :email")
    void updateUserBanned(@Param("email") String email, @Param("is_banned")boolean isBanned);

    @Query("select u.email from User u where u.isBanned = true")
    List<String> listOfBannedUserEmail();
}
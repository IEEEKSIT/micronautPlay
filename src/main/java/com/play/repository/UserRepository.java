package com.play.repository;

import com.play.dao.User;
import io.micronaut.data.annotation.Query;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.jpa.repository.JpaRepository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    @Query(nativeQuery = true,value="select * from user where email = :emailId order by createdOn desc")
    Optional<User> findTop1ByEmailOrderByCreatedOnDesc(String emailId);
}

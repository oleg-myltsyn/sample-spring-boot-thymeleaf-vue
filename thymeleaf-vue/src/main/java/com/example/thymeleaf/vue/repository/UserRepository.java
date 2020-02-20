package com.example.thymeleaf.vue.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.thymeleaf.vue.entity.User;

/**
 * @author o.myltsyn * @since 18 дек. 2019 г.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("SELECT u FROM User u WHERE u.username =:username")
    User loadByUsername(String username);
}

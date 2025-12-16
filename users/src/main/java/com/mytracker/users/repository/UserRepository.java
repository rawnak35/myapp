package com.mytracker.users.repository;

import com.mytracker.users.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Accessor - Data access abstraction for querying and persisting data JPA
 */
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);
}

package com.gnemirko.omdb_to_sql.Repository;

import com.gnemirko.omdb_to_sql.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface UserRepository  extends JpaRepository<User, Long> {
    User findByTelegramId(String telegramId);
}


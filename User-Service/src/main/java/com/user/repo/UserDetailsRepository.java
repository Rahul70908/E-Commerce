package com.user.repo;

import com.user.entity.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDetailsRepository extends JpaRepository<User, Long> {

    boolean existsByEmail(String email);

    @Transactional
    @Modifying
    @Query(value = "update user_detail set active_status=:status where user_email=:email", nativeQuery = true)
    void updateUserStatus(String status, String email);
}

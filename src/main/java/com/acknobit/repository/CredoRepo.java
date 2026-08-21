package com.acknobit.repository;

import com.acknobit.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CredoRepo extends JpaRepository<Admin, Long> {
    Optional<Admin> findByEmail(String email);

}

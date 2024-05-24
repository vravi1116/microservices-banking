package com.org.rkv.useraccount.dao;

import com.org.rkv.useraccount.model.UserAccountDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDetailsRepository extends JpaRepository<UserAccountDetails, Long> {
  UserAccountDetails findByEmail(String email);
}

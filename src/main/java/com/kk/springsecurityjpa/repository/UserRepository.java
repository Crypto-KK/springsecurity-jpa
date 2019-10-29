package com.kk.springsecurityjpa.repository;

import com.kk.springsecurityjpa.pojo.FKUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<FKUser, Long> {
    FKUser findByLoginName(String loginName);

}

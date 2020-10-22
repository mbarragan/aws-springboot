package com.quercusdata.awsspringboot.repository;

import com.quercusdata.awsspringboot.model.PUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<PUser, Long> {

    PUser findByUserId(Long userId);
}

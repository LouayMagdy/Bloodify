package com.bloodify.backend.AccountManagement.dao.interfaces;

import com.bloodify.backend.AccountManagement.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("UserRepository")
public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findByEmail(String email);

    List<User> findByNationalID(String nationalID);

    List<User> findByBloodType(String bloodType);

    List<User> findByBloodTypeIn(List<String> bloodTypes);


    @Transactional
    @Modifying
    @Query(value =
            "UPDATE User " +
            "SET status = :newStatus " +
            "WHERE userID = :userID",
            nativeQuery = true)
    void updateUserStatus(@Param("userID") int userID, @Param("newStatus") int newStatus);

}

package com.fact.tax.facttax.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fact.tax.facttax.model.AdminUser;
import com.fact.tax.facttax.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
   // @Query("from User a where a.userName= ? and a.password= ?")
    List<User> findByFirstName(String firstName);
    @Query("SELECT u FROM User u WHERE u.email = ?1 and u.password = ?2")
    User findUserByStatusAndName(String status, String name);
    @Query("SELECT u FROM AdminUser u WHERE u.email = ?1 and u.password = ?2")
    AdminUser findByAdminUser(String status, String name);
    @Query("SELECT u FROM AdminUser u WHERE u.level = ?1 ")

    List<AdminUser>getAdminUsersByDocumentLevel(String levelName);
  
   // @Query("select p from User p where  p.level = ?1")
     //List<User> findUsersByLevel(List<Integer> custIds);
    @Query("SELECT e FROM User e WHERE e.id IN (:custIds)")     // 2. Spring JPA In cause using @Query
    List<User> findUsersByLevel(@Param("custIds")List<Integer> custIds);

}

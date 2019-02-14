package com.example.springbootdemo.webapplication.repository;

import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import java.util.List;

/* Extends JpaRepository which provide all basic crud methods to entity Employee table. */

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    //understand JpaRepository to know about the derived method for CRUD operations

    /* We add a custom methodS,for custom queries here, but do not use it in this example.
     * The method name must follow findBy<column name> pattern, then JpaRepository
     * will implement the detail jdbc query code which we do not need to care, we just
     * need to call this method and pass in the userName to get result list.
     * Basically JpaRepository is the CRUD repository.
     * */

    /**jpaRepository class is a generics and takes the following two parameters as arguments-
     What type of entitu Object will this repository be working with- In our case Employee.
     Id will be what type of object- Long(since id defined in the Employee class is long)
     **/


    //note below inherited custom query method of JPA
  /*  @Query(value = "SELECT * FROM USERS u WHERE u.username = username AND u.password=password",
            nativeQuery = true)
    Employee findByUserNameAndAndPassword(String username, String password);*/
}
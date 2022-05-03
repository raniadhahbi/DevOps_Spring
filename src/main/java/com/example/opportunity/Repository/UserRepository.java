package com.example.opportunity.Repository;

import com.example.opportunity.Entity.Customer;
import com.example.opportunity.Entity.Roles;
import com.example.opportunity.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {

    public List<User> findAll();
    public User findUserById(Long id);
    public User findUserByEmail(String email);
    public void deleteUserById(Long id);
    @Query("SELECT distinct p FROM  User p ,Departement d, Business_Line l ,BusinessUnit u,Area a where   p.firstName  like %?1% or p.lastName  like %?1% " +
            "or p.email  like %?1%  or d.nameDep  like %?1% or l.name  like %?1% or u.name like %?1% " +
            " or a.nameArea like %?1%  ")
    public List<User> finding(String name);

    @Query("SELECT distinct p FROM  User p  where p.email  like %?1% ")
    public List<User> findingEmail(String email);

    @Query("SELECT distinct p FROM  User p  where  p.lastName  like %?1% ")
    public List<User> findingLastname(String lastname);

    @Query("SELECT distinct p FROM  User p where   p.firstName  like %?1% ")
    public List<User> findingFirstname(String firstname);

    @Query("SELECT distinct p FROM  User p  where   p.login  like %?1% ")
    public List<User> findingLogin(String login);

    @Query("SELECT distinct p FROM  User p ,Departement d where d.nameDep  like %?1% ")
    public List<User> findingDep(String dep);

    @Query("SELECT distinct p FROM  User p ,BusinessUnit u where u.name like %?1% ")
    public List<User> findingUnit(String unit);

    @Query("SELECT distinct p FROM  User p , Business_Line l where  l.name  like %?1%")
    public List<User> findingLine(String line);

    @Query("SELECT distinct p FROM  User p ,Area a where a.nameArea like %?1%  ")
    public List<User> findingArea(String area);

    @Query("SELECT distinct p FROM  User p ,Roles r where r.name like %?1%  ")
    public List<User> findingRole(String role);

    public List<User> findByRoles(Roles name);
}

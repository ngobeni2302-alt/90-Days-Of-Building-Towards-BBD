package com.bbd.day24;
import jakarta.persistence.*;
@Entity @Table(name="users")
public class User {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
    @Column(unique=true) private String username; private String password; private String role="USER";
    public User(){} public User(String u,String p){username=u;password=p;}
    public Long getId(){return id;} public void setId(Long id){this.id=id;}
    public String getUsername(){return username;} public void setUsername(String u){username=u;}
    public String getPassword(){return password;} public void setPassword(String p){password=p;}
    public String getRole(){return role;} public void setRole(String r){role=r;}
}

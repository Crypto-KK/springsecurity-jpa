package com.kk.springsecurityjpa.pojo;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "role")
public class FKRole implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "authority")
    private String authority;

    public FKRole() {
        super();
    }

    @Override
    public String toString() {
        return "FKRole{" +
                "id=" + id +
                ", authority='" + authority + '\'' +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}

package com.venkat.project_fiinal.Entity;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.NaturalId;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "users")
public class User implements UserDetails{
    private static final long serialVersionUID = 1840361243951715062L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String username;
    @JsonIgnore
    private String password;
   
   private String role;
  private String name;	

	public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public static long getSerialversionuid() {
	return serialVersionUID;
}

public void setAuthorities(List<Authority> authorities) {
	this.authorities = authorities;
}

	public String getRole() {
	return role;
}

public void setRole(String role) {
	this.role = role;
}

	private String cohortStartDate;
    
    @OneToMany(fetch=FetchType.EAGER, mappedBy="user")
    @JsonIgnore
    private List<Authority>authorities = new ArrayList<>();




    public String getCohortStartDate() {
        return cohortStartDate;
    }

    public void setCohortStartDate(String cohortStartDate) {
        this.cohortStartDate = cohortStartDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

  
   

    @Override
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                
                ", cohortStartDate=" + cohortStartDate +
               '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id.equals(user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}



}
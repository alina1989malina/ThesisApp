package pack.thesis.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

/**
 * Simple JavaBean domain object that represents a User.
 */

@Entity
@Table(name = "users")
public class User {
    @Id
    @Column(name = "id", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username")
    private String username = "";

    @Column(name = "password")
    private String password = "";

    @Column(name = "name")
    private String name = "";

    @Column(name = "surname")
    private String surname = "";

    @Column(name = "rating")
    private float rating = 1.0f;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phoneNumber;

    //@Temporal(TemporalType.DATE) //     @Temporal should only be set on a java.util.Date or java.util.Calendar property
    @Column(name = "birthday")
    private Date birthday;

    @Column(name = "gender")
    private int gender;  // 0 = not specified, 1 = male, 2 = female

    @Column(name = "avatar", nullable = false)
    private String pathToAvatar;

    @Column(name = "status")
    private String status;

    @Column(name = "location")
    private String geoLocation;

    @Transient
    private String confirmPassword;

    @Transient
    private String newPassword;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    public User() {
    }

    public User(Long id) {
        this.id = id;
    }

    public String getNewPassword() {
        return newPassword;
    }
    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }
    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPathToAvatar() {
        return pathToAvatar;
    }
    public void setPathToAvatar(String pathToAvatar) {
        this.pathToAvatar = pathToAvatar;
    }

    //============= native fields =============================

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getGeoLocation() {
        return geoLocation;
    }

    public void setGeoLocation(String geoLocation) {
        this.geoLocation = geoLocation;
    }

    //=========== Join fields ====================

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "Id: " + id + "\n" +
                "Username: " + username + "\n" +
                "Name: " + name + "\n" +
                "Surname: " + surname + "\n" +
                "Rating: " + rating + "\n" +
                "E-mail: " + email + "\n" +
                "Phone number: " + phoneNumber + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return  Objects.equals(id, user.id) &&
                Objects.equals(username, user.username) &&
                Objects.equals(password, user.password) &&
                Objects.equals(name, user.name) &&
                Objects.equals(surname, user.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, name, surname);
    }
}

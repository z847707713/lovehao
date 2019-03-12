package cn.lovehao.entity;

import org.hibernate.validator.constraints.NotEmpty;

public class User {

    private Integer id;
    private String username;
    private String password;
    @NotEmpty(message = "email 不能为空")
    private String email;
    private Boolean deleteFlag;
    private String rememberMe;

    public User() {
    }

    public User(Integer id) {
      this.id = id;
    }

    public User(String username) {
        this.username = username;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Boolean deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public String getRememberMe() {
        return rememberMe;
    }

    public void setRememberMe(String rememberMe) {
        this.rememberMe = rememberMe;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", deleteFlag=" + deleteFlag +
                ", rememberMe='" + rememberMe + '\'' +
                '}';
    }
}

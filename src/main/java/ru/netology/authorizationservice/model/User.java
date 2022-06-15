package ru.netology.authorizationservice.model;

import javax.validation.constraints.Size;
import java.util.Objects;

public class User {
    @Size(min = 2, max = 30, message = "параметр user должен находиться в диапазоне от 2 до 30")
    private String name;
    @Size(min = 6, max = 128, message = "параметр password должен находиться в диапазоне от 2 до 30")
    private String password;

    public User() {
    }

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name) &&
                Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, password);
    }
}

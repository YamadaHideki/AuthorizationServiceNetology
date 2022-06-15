package ru.netology.authorizationservice.repository;

import org.springframework.stereotype.Repository;
import ru.netology.authorizationservice.model.User;
import ru.netology.authorizationservice.types.Authorities;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class UserRepository {

    private final Map<User, List<Authorities>> userDb = new ConcurrentHashMap<>();

    public UserRepository() {

        List<Authorities> authoritiesList = new LinkedList<>();
        authoritiesList.add(Authorities.READ);
        authoritiesList.add(Authorities.WRITE);
        authoritiesList.add(Authorities.DELETE);

        userDb.put(new User("root", "123456"), authoritiesList);
    }

    public List<Authorities> getUserAuthorities(User user) {
        return userDb.get(user) != null ? userDb.get(user) : new LinkedList<>();
    }
}

package ru.netology.authorizationservice.repository;

import org.springframework.stereotype.Repository;
import ru.netology.authorizationservice.types.Authorities;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class UserRepository {

    private final Map<String, String> userDb = new ConcurrentHashMap<>();
    private final Map<String, List<Authorities>> authoritiesDb = new ConcurrentHashMap<>();

    public UserRepository() {
        userDb.put("root", "1");

        List<Authorities> authoritiesList = new ArrayList<>();
        authoritiesList.add(Authorities.READ);
        authoritiesList.add(Authorities.WRITE);
        authoritiesList.add(Authorities.DELETE);

        authoritiesDb.put("root", authoritiesList);
    }

    public List<Authorities> getUserAuthorities(String user, String password) {
        return userDb.get(user).equals(password) ? authoritiesDb.get(user) : new ArrayList<>();
    }
}

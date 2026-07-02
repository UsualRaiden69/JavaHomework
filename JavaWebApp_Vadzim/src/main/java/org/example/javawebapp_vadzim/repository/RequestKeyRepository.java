package org.example.javawebapp_vadzim.repository;

import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository
public class RequestKeyRepository {

    private final Set<String> keys = new HashSet<>();

    public boolean exists(String key) {
        return keys.contains(key);
    }

    public void save(String key) {
        keys.add(key);
    }
}
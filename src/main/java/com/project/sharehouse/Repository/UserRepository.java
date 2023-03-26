package com.project.sharehouse.Repository;

import com.project.sharehouse.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserRepository {

    private final EntityManager em;

    public void save(User user) {
        em.persist(user);
    }

    public User findOne(Long memberId) {
        return em.find(User.class, memberId);
    }

    public List<User> findAll() {
        return em.createQuery("select u from User u", User.class)
                .getResultList();
    }

    public List<User> findByUserName(String userName) {
        return em.createQuery("select u from User u where userName = :userName", User.class)
                .setParameter("userName", userName)
                .getResultList();
    }

    public List<User> findByPhoneNumber(String phoneNumber) {
        return em.createQuery("select u From User u where phoneNumber = :phoneNumber", User.class)
                .setParameter("phoneNumber", phoneNumber)
                .getResultList();
    }
}

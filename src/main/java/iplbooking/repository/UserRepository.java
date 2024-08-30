package iplbooking.repository;

import org.springframework.data.repository.CrudRepository;

import iplbooking.iplbooking.entity.User;

public interface UserRepository extends CrudRepository<User, Long> {
    public User findByUserName(String userName);
}
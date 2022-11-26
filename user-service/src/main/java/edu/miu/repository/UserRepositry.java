package edu.miu.repository;

import edu.miu.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepositry extends CrudRepository<User, Integer> {

    List<User> findAll();
}

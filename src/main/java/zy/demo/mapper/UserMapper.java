package zy.demo.mapper;

import org.springframework.stereotype.Repository;
import zy.demo.entity.User;

@Repository
public interface UserMapper {
    User sel(int id);

    void add(User user);
}

package service;

import bean.UserEntity;

public interface UserService {
    void add(UserEntity user);
    void read(int id);
}

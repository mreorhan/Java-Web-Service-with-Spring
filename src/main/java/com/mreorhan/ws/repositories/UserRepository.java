package com.mreorhan.ws.repositories;

import com.mreorhan.ws.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {
    UserEntity findByEmail(String email);

    UserEntity findByUserId(String id); //method name must be same with db name such as UserId->db.user_id

}

package in.dataman.repository;

import org.springframework.data.mongodb.repository.MongoRepository;


import in.dataman.entity.User;

public interface UserRepository extends MongoRepository<User, Integer>{

}

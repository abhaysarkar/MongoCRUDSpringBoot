package in.dataman.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.dataman.entity.User;
import in.dataman.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public User saveUser(User user) {	
		return repository.save(user);
	}
	
	public Optional<User> showUser(int userId) {
		return repository.findById(userId);
	}
	
	public List<User> getAllUsers() {
        return repository.findAll();
    }
	
	


}

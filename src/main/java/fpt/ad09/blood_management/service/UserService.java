package fpt.ad09.blood_management.service;

import fpt.ad09.blood_management.model.User;
import fpt.ad09.blood_management.repository.UserRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {
    @Autowired
    UserRepository userRepository;
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
	public List<User> findAll() {
		return userRepository.findAll();
	}
	public List<User> findByEnabled(int enabled) {
		return userRepository.findByEnabled(enabled);
	}
	public User findByIdUser(int idUser) {
		return userRepository.findByIdUser(idUser);
	}
	public User save(User userChange) {
		 return userRepository.save(userChange);
	}
	public int deleteByIdUser(int idUser) {
		return userRepository.deleteByIdUser(idUser);
		
	}
}

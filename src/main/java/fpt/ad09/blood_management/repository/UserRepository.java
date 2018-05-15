package fpt.ad09.blood_management.repository;

import fpt.ad09.blood_management.model.User;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
	public User findByUsernameAndEnabled(String username, int i);

	User findByUsername(String username);

	List<User> findAll();

	public List<User> findByEnabled(int enabled);

	public User findByIdUser(int idUser);

	@SuppressWarnings("unchecked")
	public User save(User user);

	public int deleteByIdUser(int idUser);
}

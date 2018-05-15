package fpt.ad09.blood_management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fpt.ad09.blood_management.model.DetailUser;

@Repository
public interface DetailUserRepository extends CrudRepository<DetailUser, Long> {

	List<DetailUser> findAll();

	@Query(value = "select * from detailuser a inner join user b On a.id_user = b.id_user where b.enabled=?1", nativeQuery = true)
	List<DetailUser> findByEnabled(int enabled);

	DetailUser findByIdUser(int idUser);
	
	@SuppressWarnings("unchecked")
	DetailUser save(DetailUser objDetail);

	List<DetailUser> findByAddressContaining(String address);

	List<DetailUser> findByPhoneContaining(String phone);

	List<DetailUser> findByFullnameContaining(String fullname);
}

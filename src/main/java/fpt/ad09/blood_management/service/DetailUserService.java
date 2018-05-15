package fpt.ad09.blood_management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fpt.ad09.blood_management.model.DetailUser;
import fpt.ad09.blood_management.repository.DetailUserRepository;

@Service
@Transactional
public class DetailUserService {
	
	@Autowired
	DetailUserRepository detailUserRepository;

	public List<DetailUser> findAll() {
		return detailUserRepository.findAll();
	}

	public List<DetailUser> findByEnabled(int enabled) {
		return detailUserRepository.findByEnabled(enabled);
	}

	public DetailUser findByIduser(int idUser) {
		return detailUserRepository.findByIdUser(idUser);
	}

	public DetailUser save(DetailUser newDetailUser) {
		return detailUserRepository.save(newDetailUser);
		
	}

	public List<DetailUser> findByAddressContaining(String address) {
		return detailUserRepository.findByAddressContaining(address);
	}

	public List<DetailUser> findByPhoneContaining(String phone) {
		return detailUserRepository.findByPhoneContaining(phone);
	}

	public List<DetailUser> findByFullnameContaining(String fullname) {
		return detailUserRepository.findByFullnameContaining(fullname);
	}


}

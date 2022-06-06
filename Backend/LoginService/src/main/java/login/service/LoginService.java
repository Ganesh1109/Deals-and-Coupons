package login.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import login.model.Login;
import login.repo.LoginRepo;

@Service
public class LoginService {
	@Autowired
	private LoginRepo loginRepo;
	
	public Login fetchusermail(String useremail) {
		return loginRepo.findByUseremail(useremail);
	}
	public Login fetchuserIdAndPassword(String useremail,Integer password) {
		return loginRepo.findByUseremailAndPassword(useremail, password);	
	}
	public List<Login> userIdAndPassword() {
		List<Login> details = new ArrayList<>();
		loginRepo.findAll()
		.forEach(details::add);
		return details;
	}
}
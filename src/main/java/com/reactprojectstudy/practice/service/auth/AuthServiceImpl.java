package com.reactprojectstudy.practice.service.auth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.reactprojectstudy.practice.enitity.User;
import com.reactprojectstudy.practice.enums.UserRole;
import com.reactprojectstudy.practice.pojo.SignupRequest;
import com.reactprojectstudy.practice.repository.UserRepository;

@Service
public class AuthServiceImpl implements AuthService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public String createUser(SignupRequest signupRequest) {
		try {
			User user = new User();
			user.setName(signupRequest.getName());
			user.setEmail(signupRequest.getEmail());
			user.setPassword(new BCryptPasswordEncoder().encode(signupRequest.getPassword()));
			user.setUserRole(UserRole.SUPERADMIN);
			userRepository.save(user);
			return "User added successfully...";
		} catch (Exception e) {
			e.printStackTrace();
			return "User added failed !!";
		}
	}
}

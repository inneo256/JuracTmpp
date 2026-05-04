package com.example.freelance;
import com.example.freelance.model.ContactRequest;
import com.example.freelance.model.ContactRequestRepository;
import com.example.freelance.model.UserEntity;
import com.example.freelance.UserRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final ContactRequestRepository contactRequestRepository;

    public AuthService(UserRepository userRepository,
                       ContactRequestRepository contactRequestRepository) {
        this.userRepository = userRepository;
        this.contactRequestRepository = contactRequestRepository;
    }

    public boolean register(String username, String password, String role) {
        if (userRepository.findByUsername(username).isPresent()) {
            return false;
        }

        UserEntity user = new UserEntity(username, password, role);

        userRepository.save(user);
        return true;
    }

    public UserEntity login(String username, String password) {
        return userRepository.findByUsername(username)
                .filter(user -> user.getPassword().equals(password))
                .orElse(null);
    }
    public void updateSkillType(String username, String skillType) {
        UserEntity user = userRepository.findByUsername(username).orElse(null);

        if (user != null) {
            user.setSkillType(skillType);
            userRepository.save(user);
        }
    }
    public void updateContacts(String username, String email, String telegram) {
        UserEntity user = userRepository.findByUsername(username).orElse(null);

        if (user != null) {
            user.setEmail(email);
            user.setTelegram(telegram);
            userRepository.save(user);
        }
    }
    public void sendRequest(String clientName, String freelancerName) {
        boolean exists = contactRequestRepository
                .findByClientNameAndFreelancerName(clientName, freelancerName)
                .isPresent();

        if (!exists) {
            ContactRequest request = new ContactRequest(clientName, freelancerName);
            contactRequestRepository.save(request);
        }
    }

    public java.util.List<ContactRequest> getRequestsForFreelancer(String freelancerName) {
        return contactRequestRepository.findByFreelancerName(freelancerName);
    }

    public void approveRequest(Long requestId) {
        ContactRequest request = contactRequestRepository.findById(requestId).orElse(null);

        if (request != null) {
            request.setApproved(true);
            contactRequestRepository.save(request);
        }
    }

    public boolean isRequestApproved(String clientName, String freelancerName) {
        return contactRequestRepository
                .findByClientNameAndFreelancerName(clientName, freelancerName)
                .map(ContactRequest::isApproved)
                .orElse(false);
    }
}

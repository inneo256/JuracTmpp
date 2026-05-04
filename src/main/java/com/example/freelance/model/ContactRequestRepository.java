package com.example.freelance.model;

import com.example.freelance.model.ContactRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ContactRequestRepository extends JpaRepository<ContactRequest, Long> {

    List<ContactRequest> findByFreelancerName(String freelancerName);

    Optional<ContactRequest> findByClientNameAndFreelancerName(String clientName, String freelancerName);
}
package com.example.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.api.model.Invitation;

public interface InvitationRepository extends JpaRepository<Invitation, Long> {

}

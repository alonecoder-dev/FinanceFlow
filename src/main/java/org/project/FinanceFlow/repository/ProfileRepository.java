package org.project.FinanceFlow.repository;

import java.util.Optional;

import org.project.FinanceFlow.entity.ProfileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository <ProfileEntity, Long> {
    
    Optional<ProfileEntity> findByEmail(String email); 

    

}

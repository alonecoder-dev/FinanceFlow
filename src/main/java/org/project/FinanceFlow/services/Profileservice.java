package org.project.FinanceFlow.services;

import java.time.LocalDateTime;
import java.util.UUID;

import org.project.FinanceFlow.dto.ProfileDTO;

import org.project.FinanceFlow.entity.ProfileEntity;
import org.project.FinanceFlow.repository.ProfileRepository;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class Profileservice {




    private final ProfileRepository profileRepository;

    public ProfileDTO registerProfile(ProfileDTO profileDTO) {
        ProfileEntity newProfile = toEntity(profileDTO);

        newProfile.setActivationtoken(UUID.randomUUID().toString());
        newProfile = profileRepository.save(newProfile);

       return toDTO(newProfile);
    }
    
    ProfileEntity toEntity(ProfileDTO profileDTO) {
        return ProfileEntity.builder()
                .FullName(profileDTO.getFullName())
                .email(profileDTO.getEmail())
                .password(profileDTO.getPassword())
                .profileImageUrl(profileDTO.getProfileImageUrl())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .isactive(false)
                .build();
    }


    public ProfileDTO toDTO(ProfileEntity profileEntity) {
        return ProfileDTO.builder()
                .id(profileEntity.getId())
                .FullName(profileEntity.getFullName())
                .email(profileEntity.getEmail())
                .profileImageUrl(profileEntity.getProfileImageUrl())
                .createdAt(profileEntity.getCreatedAt())
                .updatedAt(profileEntity.getUpdatedAt())
                .build();
    }   

  

}

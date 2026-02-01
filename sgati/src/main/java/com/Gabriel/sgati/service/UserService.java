package com.Gabriel.sgati.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Gabriel.sgati.dto.CreateUserRequest;
import com.Gabriel.sgati.dto.UserDTO;
import com.Gabriel.sgati.model.User;
import com.Gabriel.sgati.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional(readOnly = true)
    public List<UserDTO> findAll() {
        return userRepository.findAll()
                .stream()
                .map(UserDTO::fromEntity)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public UserDTO findById(Long id) {
        return userRepository.findById(id)
                .map(UserDTO::fromEntity)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }

    @Transactional(readOnly = true)
    public UserDTO findByEmail(String email) {
        return userRepository.findByEmail(email)
                .map(UserDTO::fromEntity)
                .orElseThrow(() -> new RuntimeException("User not found with email: " + email));
    }

    @Transactional
    public UserDTO create(CreateUserRequest request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already registered: " + request.getEmail());
        }

        User user = User.builder()
                .email(request.getEmail())
                .name(request.getName())
                .password(request.getPassword())
                .role(User.UserRole.USER)
                .active(true)
                .build();

        User saved = userRepository.save(user);
        return UserDTO.fromEntity(saved);
    }

    @Transactional
    public UserDTO update(Long id, CreateUserRequest request) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));

        user.setName(request.getName());
        user.setPassword(request.getPassword());

        User updated = userRepository.save(user);
        return UserDTO.fromEntity(updated);
    }

    @Transactional
    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}

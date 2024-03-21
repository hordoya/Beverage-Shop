package de.uniba.dsam.group.project.services;

import de.uniba.dsam.group.project.models.User;
import de.uniba.dsam.group.project.repos.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {
    private final UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<User> getAllUsers() {
        return this.userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return this.userRepository.findById(id).orElse(null);
    }

    @Override
    public User getUserByUserName(String userName) {
        return this.userRepository.findByUserName(userName);
    }

    @Override
    public void createUser(User user) {
        //Encoding the password before saving
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        this.userRepository.save(user);
    }
    @Override
    public Boolean deleteUserById(Long id) {
        if (this.userRepository.existsById(id)){
            this.userRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Boolean updateUser(User updatedUser, Long userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isPresent()) {
            User existingUser = optionalUser.get();

            // Update fields with non-null values from updatedUser
            if (updatedUser.getUserName() != null) {
                existingUser.setUserName(updatedUser.getUserName());
            }

            if (updatedUser.getPassword() != null) {
                existingUser.setPassword(updatedUser.getPassword());
            }

            if (updatedUser.getBirthday() != null) {
                existingUser.setBirthday(updatedUser.getBirthday());
            }
            if (updatedUser.getEmail() != null) {
                existingUser.setEmail(updatedUser.getEmail());
            }
            // Save the updated user
            userRepository.save(existingUser);
            return true;
        }
        return false;
    }




    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUserName(username); // logic to load user details from the database

        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username); //throws UsernameNotFoundException if no user found
        }
        String role = user.getUserName().contains("admin") ? "ADMIN" : "USER";

        UserDetails userDetails = org.springframework.security.core.userdetails.User
                .withUsername(user.getUserName())
                .password(user.getPassword())
                //.passwordEncoder(password -> passwordEncoder().encode(password))
                .roles(role)
                .build();

        return userDetails; //if the user is found
    }
}


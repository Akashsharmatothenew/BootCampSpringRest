package com.project.ecommerce.projectEcommerce.Service;


import com.project.ecommerce.projectEcommerce.Repository.AddressRepository;
import com.project.ecommerce.projectEcommerce.Repository.UserRepository;
import com.project.ecommerce.projectEcommerce.dto.AddressUpdateDTO;
import com.project.ecommerce.projectEcommerce.dto.PasswordUpdateDTO;
import com.project.ecommerce.projectEcommerce.dto.ResetPasswordDTO;
import com.project.ecommerce.projectEcommerce.entities.Address;
import com.project.ecommerce.projectEcommerce.entities.Role;
import com.project.ecommerce.projectEcommerce.entities.User;
import com.project.ecommerce.projectEcommerce.exception.TokenNotFoundException;
import com.project.ecommerce.projectEcommerce.exception.UserNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    AddressRepository addressRepository;
    @Autowired
    EmailService emailService;


    public Boolean receiveToken(String email, HttpServletRequest request) {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new UserNotFoundException("There is no user with the given email id");
        }
        if (user.getIsActive()) {
            user.setConfirmationToken(UUID.randomUUID().toString());
            user.setExpiryDate(5);
            userRepository.save(user);
            String appUrl = request.getScheme() + "://" + request.getServerName();
            emailService.sendEmail(user.getEmail(), appUrl, "Reset Password", user.getConfirmationToken(), "/reset/token?=");
            return true;
        }
        return false;
    }


    public Boolean resetPassword(ResetPasswordDTO resetPasswordDTO) {
        User userExists = userRepository.findByConfirmationToken(resetPasswordDTO.getConfirmationToken());
        if (userExists == null) {
            throw new TokenNotFoundException("This is an Invalid Token");
        }
        Calendar cal = Calendar.getInstance();
        if ((userExists.getExpiryDate().getTime() - cal.getTime().getTime()) <= 0) {
            userExists.setConfirmationToken("NULl");
            userRepository.save(userExists);
            emailService.sendEmail(userExists.getEmail(),"Password Not Updated","Your token has been expired.please get another token and try with that token to reser your password");
            return false;
        } else {
            if (resetPasswordDTO.getPassword().equals(resetPasswordDTO.getConfirmPassword())) {
                String newPassword = bCryptPasswordEncoder.encode(resetPasswordDTO.getConfirmPassword());
                userExists.setPassword(newPassword);
                userExists.setConfirmationToken("NULL");
                userRepository.save(userExists);
                emailService.sendEmail(userExists.getEmail(),"Password Updated","Your password has been updated , please enjoy our website");
                return true;
            }
            return false;
        }
    }


    public boolean updatePassword(String username, PasswordUpdateDTO passwordUpdateDTO) {
        if (passwordUpdateDTO.getPassword().equals(passwordUpdateDTO.getConfirmPassword())) {
            String newPassword = bCryptPasswordEncoder.encode(passwordUpdateDTO.getConfirmPassword());
            User user = userRepository.findByEmail(username);
            user.setPassword(newPassword);
            userRepository.save(user);
            emailService.sendEmail(user.getEmail(),"Password Updated","Your password has been updated for your acoount");
            return true;
        } else
            return false;
    }


    public Boolean activate(Long id) {

        User user = userRepository.findById(id).orElse(null);
        if (user == null) {
            throw new UserNotFoundException("There is no User with the given id");
        } else if (!user.getIsActive()) {
            user.setIsActive(true);
            userRepository.save(user);
            emailService.sendEmail(user.getEmail(), "Account Activated", "Your account has been activated.");
            return true;
        } else
            return false;
    }

    @SuppressWarnings({"Duplicates"})
    public Boolean deactivate(Long id) {
        User user = userRepository.findById(id).orElse(null);
        if (user == null) {
            throw new UserNotFoundException("There is no User with the given id");
        } else if (user.getIsActive()) {
            user.setIsActive(false);
            userRepository.save(user);
            emailService.sendEmail(user.getEmail(), "Account De-Activated", "Your account has been de-activated.");
            return true;
        } else {
            return false;
        }
    }


    public boolean updateAddress(Long id, AddressUpdateDTO addressUpdateDTO) {
        if(addressUpdateDTO.getCity()!=null)
        {
            Address address=addressRepository.findById(id).get();
            address.setCity(addressUpdateDTO.getCity());
            addressRepository.save(address);
        }
        if(addressUpdateDTO.getCountry()!=null)
        {
            Address address=addressRepository.findById(id).get();
            address.setCountry(addressUpdateDTO.getCountry());
            addressRepository.save(address);
        }
        if(addressUpdateDTO.getLabel()!=null)
        {
            Address address=addressRepository.findById(id).get();
            address.setLabel(addressUpdateDTO.getLabel());
            addressRepository.save(address);
        }
        if(addressUpdateDTO.getState()!=null)
        {
            Address address=addressRepository.findById(id).get();
            address.setState(addressUpdateDTO.getState());
            addressRepository.save(address);
        }
        if(addressUpdateDTO.getZipCode()!=null)
        {
            Address address=addressRepository.findById(id).get();
            address.setZipCode(addressUpdateDTO.getZipCode());
            addressRepository.save(address);
        }
        if(addressUpdateDTO.getAddressLine()!=null)
        {
            Address address=addressRepository.findById(id).get();
            address.setAddressLine(addressUpdateDTO.getAddressLine());
            addressRepository.save(address);
        }
        return true;

    }

    public List<Role> getRole(String email){
        User user = userRepository.findByEmail(email);
        if(user!=null){
            return user.getRole();
        }
        return null;
    }
}

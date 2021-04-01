package com.project.ecommerce.projectEcommerce.Service;

import com.project.ecommerce.projectEcommerce.Repository.AddressRepository;
import com.project.ecommerce.projectEcommerce.Repository.SellerRepository;
import com.project.ecommerce.projectEcommerce.dto.SellerProfileResponseDTO;
import com.project.ecommerce.projectEcommerce.dto.SellerRegisterDTO;
import com.project.ecommerce.projectEcommerce.dto.SellerResponseDTO;
import com.project.ecommerce.projectEcommerce.dto.SellerUpdateProfileDTO;
import com.project.ecommerce.projectEcommerce.entities.Role;
import com.project.ecommerce.projectEcommerce.entities.Seller;
import com.project.ecommerce.projectEcommerce.exception.EmailAlreadyExistsException;
import com.project.ecommerce.projectEcommerce.exception.PasswordNotMatchedException;
import com.project.ecommerce.projectEcommerce.exception.UserNotFoundException;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.security.Principal;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class SellerService {

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    SellerRepository sellerRepository;

    @Autowired
    AddressRepository addressRepository;

    @Autowired
    EmailService emailService;


    public boolean registerSeller(SellerRegisterDTO sellerRegisterDto){
        Seller sellerExists=sellerRepository.findByEmail(sellerRegisterDto.getEmail());
        if(sellerExists !=null){
            throw new EmailAlreadyExistsException("Seller already registered with this E-mail.");
        }
        else {
            if(sellerRegisterDto.getPassword().equals(sellerRegisterDto.getConfirmPassword())) {
                ModelMapper modelMapper = new ModelMapper();
                String newPassword = bCryptPasswordEncoder.encode(sellerRegisterDto.getPassword());
                sellerRegisterDto.setPassword(newPassword);
                Seller seller = modelMapper.map(sellerRegisterDto, Seller.class);
                seller.setRole(Arrays.asList(new Role("ROLE_SELLER")));
                seller.setIsActive(false);
                seller.setConfirmationToken(UUID.randomUUID().toString());
                seller.setExpiryDate(24*60);
                sellerRepository.save(seller);
                emailService.sendEmail(seller.getEmail(), "Account Created", "Your Account has been created. We need you to be a little patient with the approval of your Account. ");
                return true;
            }else
            {
                throw new PasswordNotMatchedException("Password and confirm password does not match");
            }
        }
    }


    public Boolean activateSeller(Long id){
        Seller seller=sellerRepository.findById(id).orElse(null);
        if(seller == null){
            throw new UserNotFoundException("There is no Seller with the given id");
        }
        else if(!seller.getIsActive()){
            seller.setIsActive(true);
            sellerRepository.save(seller);
            emailService.sendEmail(seller.getEmail(),"Account Activated","Your account has been activated.");
            return true;
        }
        else
            return false;
    }


    public Boolean deactivateSeller(Long id) {
        Seller seller=sellerRepository.findById(id).orElse(null);
        if(seller == null){
            throw new UserNotFoundException("There is no Seller with the given id");
        }
        else if(seller.getIsActive()){
            seller.setIsActive(false);
            sellerRepository.save(seller);
            emailService.sendEmail(seller.getEmail(),"Account De-Activated","Your account has been de-activated.");
            return true;
        }
        else {
            return false;
        }
    }


    public PageImpl<SellerResponseDTO> pagingSeller(Pageable pageable) {
        pageable= PageRequest.of(0,10, Sort.Direction.ASC,"username");
        Page<Seller> sellers=sellerRepository.findAll(pageable);
        List<SellerResponseDTO> sellerResponseDTOList=sellers.stream().map(this::toSellerResponseDTO).collect(Collectors.toList());
        return new PageImpl<SellerResponseDTO>(sellerResponseDTOList,pageable,sellers.getTotalPages());
    }


    private SellerResponseDTO toSellerResponseDTO(Seller seller) {
        return new SellerResponseDTO(seller.getId(),seller.getEmail(),seller.getFirstName(),seller.getMiddleName(),seller.getLastName(),seller.getIsActive(),seller.getCompanyName(),seller.getCompanyContact(),seller.getGst());
    }


    public boolean updateProfile(String username, SellerUpdateProfileDTO sellerUpdateProfileDTO) {
        if(sellerUpdateProfileDTO.getFirstName()!=null)
        {
            Seller seller=sellerRepository.findByUsername(username);
            seller.setFirstName(sellerUpdateProfileDTO.getFirstName());
            sellerRepository.save(seller);
        }
        if(sellerUpdateProfileDTO.getMiddleName()!=null)
        {
            Seller seller=sellerRepository.findByUsername(username);
            seller.setMiddleName(sellerUpdateProfileDTO.getMiddleName());
            sellerRepository.save(seller);
        }
        if(sellerUpdateProfileDTO.getLastName()!=null)
        {
            Seller seller=sellerRepository.findByUsername(username);
            seller.setLastName(sellerUpdateProfileDTO.getLastName());
            sellerRepository.save(seller);
        }
        if(sellerUpdateProfileDTO.getGst()!=null)
        {
            Seller seller=sellerRepository.findByUsername(username);
            seller.setGst(sellerUpdateProfileDTO.getGst());
            sellerRepository.save(seller);
        }
        if(sellerUpdateProfileDTO.getCompanyContact()!=null)
        {
            Seller seller=sellerRepository.findByUsername(username);
            seller.setCompanyContact(sellerUpdateProfileDTO.getCompanyContact());
            sellerRepository.save(seller);
        }
        if(sellerUpdateProfileDTO.getCompanyName()!=null) {
            Seller seller = sellerRepository.findByUsername(username);
            seller.setCompanyContact(sellerUpdateProfileDTO.getCompanyContact());
            sellerRepository.save(seller);
        }
        return true;
    }


    public SellerProfileResponseDTO viewProfile(Principal principal) {
        String username=principal.getName();
        Seller seller=sellerRepository.findByUsername(username);
        ModelMapper modelMapper=new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        SellerProfileResponseDTO sellerProfileResponseDTO=modelMapper.map(seller,SellerProfileResponseDTO.class);
        return sellerProfileResponseDTO;
    }
}

package com.project.ecommerce.projectEcommerce.Service;


import com.project.ecommerce.projectEcommerce.Repository.AddressRepository;
import com.project.ecommerce.projectEcommerce.Repository.CustomerRepository;
import com.project.ecommerce.projectEcommerce.Repository.UserRepository;
import com.project.ecommerce.projectEcommerce.dto.*;
import com.project.ecommerce.projectEcommerce.entities.Address;
import com.project.ecommerce.projectEcommerce.entities.Customer;
import com.project.ecommerce.projectEcommerce.entities.Role;
import com.project.ecommerce.projectEcommerce.entities.User;
import com.project.ecommerce.projectEcommerce.exception.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.security.Principal;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    EmailService emailService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    AddressRepository addressRepository;

    public Boolean registerCustomer(CustomerRegisterDTO customerRegisterDTO, HttpServletRequest request) {
        Customer customerExists = customerRepository.findByEmail(customerRegisterDTO.getEmail());
        if (customerExists != null) {
            throw new EmailAlreadyExistsException("Buyer already registered with this E-mail.");
        } else {
            if (customerRegisterDTO.getPassword().equals(customerRegisterDTO.getConfirmPassword())) {
                ModelMapper modelMapper = new ModelMapper();
                String newPassword = bCryptPasswordEncoder.encode(customerRegisterDTO.getPassword());
                customerRegisterDTO.setPassword(newPassword);
                Customer customer = modelMapper.map(customerRegisterDTO, Customer.class);
                customer.setRole(Arrays.asList(new Role("ROLE_BUYER")));
                customer.setIsActive(false);
                customer.setConfirmationToken(UUID.randomUUID().toString());
                customer.setExpiryDate(24 * 60);
                customerRepository.save(customer);
                String appUrl = request.getScheme() + "://" + request.getServerName();
                emailService.sendEmail(customer.getEmail(), appUrl, "Registration Confirmation",
                        customer.getConfirmationToken());
                return true;
            } else {
                throw new PasswordNotMatchedException("Password and confirm password does not match");
            }
        }
    }


    public Boolean confirmToken(String token, HttpServletRequest request) {
        Customer customer = customerRepository.findByConfirmationToken(token);
        if (customer == null) {
            throw new TokenNotFoundException("This is an Invalid Token");
        }
        Calendar cal = Calendar.getInstance();
        if ((customer.getExpiryDate().getTime() - cal.getTime().getTime()) <= 0) {
            customer.setConfirmationToken(UUID.randomUUID().toString());
            customer.setExpiryDate(5);
            customerRepository.save(customer);
            String appUrl = request.getScheme() + "://" + request.getServerName();
            // Create an email instance
            emailService.sendEmail(customer.getEmail(), appUrl, "Registration Confirmation"
                    , customer.getConfirmationToken());
        } else {
            if (customer.getConfirmationToken().equals(token)) {
                // System.out.println("Activated.........");
                customer.setIsActive(true);
                customer.setConfirmationToken("NULL");
                customerRepository.save(customer);
                return true;
            }
        }
        return false;
    }


    public Boolean reactivateToken(String email, HttpServletRequest request) {
        Customer customer = customerRepository.findByEmail(email);
        if (customer == null) {
            throw new UserNotFoundException("No User Found with this E-mail.....Please enter a correct E-mail ID");
        }
        if (!customer.getIsActive()) {
            customer.setConfirmationToken(UUID.randomUUID().toString());
            customer.setExpiryDate(10);
            customerRepository.saveAndFlush(customer);
            String appUrl = request.getScheme() + "://" + request.getServerName();
            emailService.sendEmail(customer.getEmail(), appUrl, "Registration Confirmation", customer.getConfirmationToken());
            return true;
        } else {
            return false;
        }
    }


    public Boolean activateCustomer(Long id) {
       Customer customer= customerRepository.findById(id).orElse(null);
        if (customer == null) {
            throw new UserNotFoundException("There is no Buyer with the given id");
        } else if (!customer.getIsActive()) {
            customer.setIsActive(true);
            customerRepository.save(customer);
            emailService.sendEmail(customer.getEmail(), "Account Activated", "Your account has been activated.");
            return true;
        } else {
            return false;
        }
    }


    public Boolean deactivateCustomer(Long id) {
        Customer customer = customerRepository.findById(id).orElse(null);
        if (customer == null) {
            throw new UserNotFoundException("There is no Buyer with the given id");
        } else if (customer.getIsActive()) {
            customer.setIsActive(false);
            customerRepository.save(customer);
            emailService.sendEmail(customer.getEmail(), "Account De-Activated", "Your account has been de-activated.");
            return true;
        } else {
            return false;
        }
    }


    //paging for buyer
    public PageImpl<CustomerResponseDTO> pagingCustomer(Pageable pageable) {
        pageable = PageRequest.of(0, 10, Sort.Direction.ASC, "id");
        Page<Customer> customer = customerRepository.findAll(pageable);
        List<CustomerResponseDTO> customerResponseDTOList = customer.getContent().stream().map(this::toBuyerResponseDTO).collect(Collectors.toList());
        return new PageImpl<CustomerResponseDTO>(customerResponseDTOList);
    }


    private CustomerResponseDTO toBuyerResponseDTO(Customer customer) {
        return new CustomerResponseDTO(customer.getId(), customer.getEmail(), customer.getFirstName(), customer.getMiddleName(), customer.getLastName(), customer.getIsActive());
    }


    public boolean updateProfile(String username, UpdateProfileDTO updateProfileDTO) {
        if (updateProfileDTO.getFirstName() == null && updateProfileDTO.getMiddleName() == null && updateProfileDTO.getLastName() == null && updateProfileDTO.getContact() == null) {
            return false;
        }
        if (updateProfileDTO.getFirstName() != null) {
            User user = userRepository.findByUsername(username);
            user.setFirstName(updateProfileDTO.getFirstName());
            userRepository.save(user);
        }
        if (updateProfileDTO.getMiddleName() != null) {
            User user = userRepository.findByUsername(username);
            user.setMiddleName(updateProfileDTO.getMiddleName());
            userRepository.save(user);
        }
        if (updateProfileDTO.getLastName() != null) {
            User user = userRepository.findByUsername(username);
            user.setLastName(updateProfileDTO.getLastName());
            userRepository.save(user);
        }
        if (updateProfileDTO.getContact() != null) {
            Customer customer = customerRepository.findByUsername(username);
            customer.setContact(updateProfileDTO.getContact());
            customerRepository.save(customer);
        }
        return true;
    }


    public boolean deleteAddress(Long address_id) {
        Address address = addressRepository.findById(address_id).orElse(null);
        if (address == null) {
            throw new AddressNotFoundException("There is no record with the id provided.");
        } else {
            address.setIsDeleted(true);
            addressRepository.save(address);
            return true;
        }
    }


    public List<AddressResponseDTO> getAddressList(String username)
    {
        User user=userRepository.findByUsername(username);
        if(user!=null)
        {
            Set<Address> addresses=user.getAddress();
            Iterator<Address> it=addresses.iterator();
            while(it.hasNext()){
                if(it.next().getIsDeleted()==true){
                    it.remove();
                }
            }
            return addresses.stream().map(this::toAddressDto).collect(Collectors.toList());
        }else
            throw new UserNotFoundException("There is no user present in the system ");
    }


    private AddressResponseDTO toAddressDto(Address address)
    {
        return new AddressResponseDTO(address.getAddress_id(),address.getCity(),address.getState(),address.getCountry(),address.getAddressLine(),address.getZipCode(),address.getLabel());
    }


    public CustomerProfileResponseDTO viewProfile(Principal principal) {
        String username=principal.getName();
        Customer customer=customerRepository.findByUsername(username);
        ModelMapper modelMapper=new ModelMapper();
       CustomerProfileResponseDTO customerProfileResponseDto=modelMapper.map(customer,CustomerProfileResponseDTO.class);
        return customerProfileResponseDto;
    }


    public Boolean addAddress(String username, @Valid AddressDTO addressDTO) {
        User buyer=userRepository.findByUsername(username);
        ModelMapper modelMapper=new ModelMapper();
        Address address= modelMapper.map(addressDTO,Address.class);
        HashSet<Address> addressHashSet=new HashSet<Address>();
        addressHashSet.add(address);
        address.setUser(buyer);
        buyer.setAddress(addressHashSet);
        userRepository.save(buyer);
        return true;

    }

}

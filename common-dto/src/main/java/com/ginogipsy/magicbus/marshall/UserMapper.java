package com.ginogipsy.magicbus.marshall;

import com.ginogipsy.magicbus.customexception.notfound.UserNotFoundException;
import com.ginogipsy.magicbus.domain.User;
import com.ginogipsy.magicbus.dto.UserDTO;
import com.ginogipsy.magicbus.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


@Component
public class UserMapper {

    private final ModelMapper modelMapper;
    private final UserRepository userRepository;

    public UserMapper(ModelMapper modelMapper, UserRepository userRepository) {
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
    }

    public UserDTO findUserByUsername(String username){
        return convertToDTO(userRepository.findByUsername(username));
    }

    public UserDTO findById(Integer id){
        return convertToDTO(userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("Utente non trovato!")));
    }

    public Boolean existsByUsername(String username){
        return userRepository.existsByUsername(username);
    }

    public Boolean existsByEmail(String email){
        return userRepository.existsByEmail(email);
    }

    public UserDTO findUserByEmail(String email){
        return convertToDTO(userRepository.findByEmail(email));
    }

    public User convertToEntity(UserDTO userDTO){
        return (userDTO != null) ? modelMapper.map(userDTO, User.class) : null;
    }

    public UserDTO convertToDTO(User user){
        return (user != null) ? modelMapper.map(user, UserDTO.class) : null;
    }

    public UserDTO save(UserDTO userDTO){
        return convertToDTO(userRepository.save(convertToEntity(userDTO)));
    }

    public List<UserDTO> findByUsernameOrEmail(String username, String email){
        List<User> users = userRepository.findByUsernameOrEmail(username, email);
        return (!users.isEmpty()) ? users.stream().map(this::convertToDTO).toList() : null;
    }

    public UserDTO findByFiscalCode(String fiscalCode){
        return Optional.ofNullable(convertToDTO(userRepository.findByFiscalCode(fiscalCode))).orElse(null);
    }

    public UserDTO findByCellNumber(String cellNumber){
        return Optional.ofNullable(convertToDTO(userRepository.findByCellNumber(cellNumber))).orElse(null);
    }

}

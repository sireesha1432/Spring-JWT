package com.Spring.JWT.Security.Service;

import com.Spring.JWT.Security.Model.RequestDTO;
import com.Spring.JWT.Security.Model.ResponseDTO;
import com.Spring.JWT.Security.Model.SecurityEntity;
import com.Spring.JWT.Security.Repository.SecurityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class Securityservice {
    @Autowired
    private SecurityRepo securityrepo;

    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    public ResponseDTO getdata(int id) {
        Optional<SecurityEntity>  entity= Optional.ofNullable(securityrepo.findById(id));
        ResponseDTO dto=new ResponseDTO();
        dto.setUser(entity.get().getName());
        dto.setPassword(entity.get().getPassword());

        return dto;
    }
    public SecurityEntity save(RequestDTO requestDTO)
    {
        SecurityEntity securityEntity = new SecurityEntity();
        securityEntity.setName(requestDTO.getName());
        securityEntity.setPassword(encoder.encode(requestDTO.getPassword()));

        SecurityEntity savedEntity = securityrepo.save(securityEntity);
        return savedEntity;

    }

}


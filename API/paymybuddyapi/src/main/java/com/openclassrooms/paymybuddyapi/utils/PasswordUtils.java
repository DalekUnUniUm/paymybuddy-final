package com.openclassrooms.paymybuddyapi.utils;

import com.openclassrooms.paymybuddyapi.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class PasswordUtils {

    @Autowired
    private UtilisateurRepository utilisateurRepository ;

    private BCryptPasswordEncoder encoder ;

    public String hashPassword(String password){

        encoder = new BCryptPasswordEncoder(16);
        String hashPassword = encoder.encode(password);
        return hashPassword ;
    }

    public String getPasswordFromDb(String password, String mail){
        encoder = new BCryptPasswordEncoder(16);
        String pwd = utilisateurRepository.findPwdByMail(mail);
        if(encoder.matches(password,pwd))
            return pwd ;

        return "false" ;
    }
}

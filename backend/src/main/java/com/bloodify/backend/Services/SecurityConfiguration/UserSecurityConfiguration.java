// package com.bloodify.backend.services.SecurityConfiguration;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.beans.factory.annotation.Qualifier;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.core.annotation.Order;
// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.core.userdetails.UserDetailsService;


// @Configuration
// @EnableWebSecurity
// @Order(1)
// public class UserSecurityConfiguration extends SecurityConfiguration {


//     @Autowired
//     @Qualifier("userDAOImp")
//     UserDetailsService userDao;

//     @Override
//     UserDetailsService userDetailsService() {
//         return userDao;
//     }

//     @Override
//     String getLoginEndpoint() {
//         return "/api/v1/userlogin";
//     }
    
// }

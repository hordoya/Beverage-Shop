package de.uniba.dsam.group.project.security;


//import de.uniba.dsam.group.project.services.UserServiceImpl;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebSecurity
public class SecurityConfig implements WebMvcConfigurer {


    private final String[] permitAllURL = {

            "/cart",
            "/addToCart/bottle/{productId}",
            "/addToCart/crate/{productId}",
            "/cart/delete/{itemId}",
    };
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {


        http
                .authorizeRequests()
                .requestMatchers(permitAllURL).hasRole("USER")
                .requestMatchers("/h2-console/**").permitAll()
                .requestMatchers("/browser/**").permitAll()
                .requestMatchers("//**").permitAll()
                .requestMatchers("/register").permitAll()
                .requestMatchers("/css/**").permitAll()
                .requestMatchers("/admin/**").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin((form) -> form
                        .loginPage("/login")
                        .failureHandler(customAuthenticationFailureHandler()) // Handling authentication failures in login
                        .successHandler((request, response, authentication) -> {
                            // Determine the role and redirect accordingly
                            if (authentication.getAuthorities().stream()
                                    .anyMatch(grantedAuthority -> grantedAuthority.getAuthority().equals("ROLE_ADMIN"))) {
                                response.sendRedirect("/allOrder"); // Redirect admin to the admin dashboard
                            } else {
                                response.sendRedirect("/"); // Redirect user to the user dashboard
                            }
                        })
                        .permitAll()

                )
                .csrf(request -> request.ignoringRequestMatchers(PathRequest.toH2Console()))
                .headers(headers -> headers.frameOptions(option -> option.sameOrigin()))
                .logout(logout ->
                        logout
                                .logoutUrl("/logout")
                                .logoutSuccessUrl("/login?logout")// Redirecting to login page after logout
                                .permitAll()
                );
        return http.build();

    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationFailureHandler customAuthenticationFailureHandler() {
        return new CustomAuthenticationFailureHandler();
    }

}

package cs544;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user = User.withDefaultPasswordEncoder()
                .username("user").password("pass").roles("USER").build();
        UserDetails admin = User.withDefaultPasswordEncoder()
                .username("admin").password("pass").roles("ADMIN", "USER").build();

        return new InMemoryUserDetailsManager(user, admin);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http.authorizeHttpRequests(auth -> auth.requestMatchers("/important/**").hasRole("USER"))
        http.authorizeHttpRequests(
                auth -> auth.requestMatchers("/", "/WEB-INF/views/index.jsp", "/login", "/logout", "/accessDenied", "/WEB-INF/views/login.jsp").permitAll()
                .requestMatchers(HttpMethod.GET, "/cars").hasRole("USER")
                .requestMatchers(HttpMethod.GET, "/**").hasAnyRole("ADMIN")
                .requestMatchers(HttpMethod.POST, "/**").hasAnyRole("ADMIN"))//Make it more detailed

                .formLogin(Customizer.withDefaults())
                .logout(Customizer.withDefaults());

        return http.build();
    }

//    @Bean
//    public WebSecurityCustomizer ignoringCustomizer() {
//        return (web) -> web.debug(true).ignoring().requestMatchers("/js/**", "/css/**");
//    }

//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.
//                httpBasic()
//                .and()
//                .authorizeRequests()
//
//                .antMatchers("/").hasRole("USER")
//                .antMatchers("/cars").hasRole("USER")
//
//                .antMatchers("/cars/add").hasRole("ADMIN")
//                .antMatchers("/cars/delete").hasRole("ADMIN")
//                .antMatchers("/cars/{id}").hasRole("ADMIN")
//
//                .and()
//                .formLogin();
//    }
}

package com.bbd.day23;
import com.bbd.day23.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import java.util.Map;
@RestController @RequestMapping("/api/auth")
@CrossOrigin
public class AuthController {
    @Autowired UserRepository userRepo; @Autowired PasswordEncoder encoder; @Autowired AuthenticationManager authManager; @Autowired JwtUtil jwtUtil;
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user){
        if(userRepo.existsByUsername(user.getUsername())) return ResponseEntity.badRequest().body(Map.of("error","Username taken"));
        user.setPassword(encoder.encode(user.getPassword()));
        userRepo.save(user);
        return ResponseEntity.ok(Map.of("message","Registered"));
    }
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user){
        try{
            authManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
            String token = jwtUtil.generateToken(user.getUsername());
            return ResponseEntity.ok(Map.of("token",token,"username",user.getUsername()));
        } catch(BadCredentialsException e){ return ResponseEntity.status(401).body(Map.of("error","Invalid credentials")); }
    }
}

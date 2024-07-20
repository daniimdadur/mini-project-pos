package org.project.pos.auth.controller;

import lombok.RequiredArgsConstructor;
import org.project.pos.auth.model.req.ChangePasswordReq;
import org.project.pos.auth.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {
    private final AuthService authService;
    @PatchMapping
    public ResponseEntity<?> changePassword(@RequestBody ChangePasswordReq request, Principal principal) {
        this.authService.changePassword(request, principal);
        return ResponseEntity.ok().build();
    }
}

package org.project.pos.auth.service;

import org.project.pos.auth.model.req.ChangePasswordReq;

import java.security.Principal;

public interface AuthService {
    void changePassword(ChangePasswordReq request, Principal connectedUser);
}

package com.user.manager.services;

import com.user.manager.model.Role;

public interface RoleService {
    Role getRole(String name);
    void saveRole();
}

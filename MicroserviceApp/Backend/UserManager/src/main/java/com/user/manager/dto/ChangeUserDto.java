package com.user.manager.dto;

import lombok.Data;

import java.util.List;

@Data
public class ChangeUserDto {
    private String email;
    private List<Long> roleIds;
    private List<Long> permissionIds;
    private boolean isBanned;
}

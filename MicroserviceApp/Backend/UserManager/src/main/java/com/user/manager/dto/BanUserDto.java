package com.user.manager.dto;

import com.user.manager.mapper.DtoEntity;
import lombok.Data;

@Data
public class BanUserDto implements DtoEntity {
    private String email;
    private String name;
    private boolean isBanned;
    private String city;
    private boolean isForbidden;

}

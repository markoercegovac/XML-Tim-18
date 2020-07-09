package com.user.manager.mq.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserMQ {

    private String email;
    private boolean isBanned;
    private boolean isRemoved;
    private boolean isCreationEnabled;
    private boolean isForbiddenAdvert;
}

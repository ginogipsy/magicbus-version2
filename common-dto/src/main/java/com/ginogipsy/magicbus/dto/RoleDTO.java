package com.ginogipsy.magicbus.dto;


import com.ginogipsy.magicbus.domain.enums.Profilo;
import lombok.Data;

@Data
public class RoleDTO {

    private int id;
    private Profilo profilo;
}

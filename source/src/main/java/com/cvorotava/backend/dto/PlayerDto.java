package com.cvorotava.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PlayerDto {
    private Integer id;
    private String dni;
    private String name;
    private String surname1;
    private String surname2;
    private String telephone;
    private String email;
    private String address;
    private String birthday;
    private String category;
    private String image;
}

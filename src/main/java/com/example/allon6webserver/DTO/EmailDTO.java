package com.example.allon6webserver.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailDTO {

    private String name;
    private String email;
    private int phone;
    private String message;



}

package com.example.Proxym.dto.AssureDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class AssureResponseDTO {
    private Long idAssure ;
    private String email ;
    private String name ;
    private String password ;
    private String numTel ;
    private Date dateIncrit ;
    private Long idAddress ;

}

package com.example.Proxym.sahred;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder

public class ErrorMessage {
    String message ;
    Date timestamp ;
    Integer code ;
}

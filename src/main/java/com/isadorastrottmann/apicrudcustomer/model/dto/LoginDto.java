package com.isadorastrottmann.apicrudcustomer.model.dto;

import org.springframework.web.bind.annotation.RequestBody;

public record LoginDto (String email, String password){
}

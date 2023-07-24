package com.deere.channel.jdws.payment.account;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Account {

    @NonNull
    Integer number;

    Integer balance ;

}

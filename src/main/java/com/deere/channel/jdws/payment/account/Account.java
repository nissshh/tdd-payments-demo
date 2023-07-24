package com.deere.channel.jdws.payment.account;

import lombok.Data;
import lombok.NonNull;

@Data
public class Account {

    @NonNull
    Integer number;

    Integer balance ;

}

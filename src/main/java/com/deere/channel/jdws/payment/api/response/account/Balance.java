package com.deere.channel.jdws.payment.api.response.account;

import lombok.Data;

@Data
public class Balance {

    Integer amount;

    String currency;
}

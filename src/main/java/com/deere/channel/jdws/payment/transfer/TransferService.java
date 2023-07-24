package com.deere.channel.jdws.payment.transfer;


import java.util.HashMap;
import java.util.Map;

import com.deere.channel.jdws.payment.account.Account;
import com.deere.channel.jdws.payment.api.response.account.Balance;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransferService {

    TransfersDAO transferDao;

    Map<Integer,Account> data = new HashMap<>();

    
    public void init(Map<Integer,Account> data){
        this.data=data;
    }

    public Balance transfer(Account accountFrom, Account accountTo) {
    
        return null;
    }

}

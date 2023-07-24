package com.deere.channel.jdws.payment.transfer;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

import java.io.IOException;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.deere.channel.jdws.payment.account.Account;
import com.deere.channel.jdws.payment.api.response.account.Balance;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TransferServiceTest {

    TransferService transferService = new TransferService();

    @BeforeEach
    public void setup() throws IOException{
        transferService.setData(getSampleData());
    }

    @Test
    public void test_Transfer_Base() {
        // Assemble
        TransfersDAO transfersDAO = mock(TransfersDAO.class);
        transferService.setTransferDao(transfersDAO);
        Account accountFrom = new Account(101);
        Account accountTo = new Account(102);
        // Act
        Balance fromAccountBalance = transferService.transfer(accountFrom, accountTo);
        // Assert
        assertNotNull(fromAccountBalance);
    }

    @Test
    public void test_Transfer_PositiveBalance() {
        // Assemble
        TransfersDAO transfersDAO = mock(TransfersDAO.class);
        transferService.setTransferDao(transfersDAO);
        Account accountFrom = new Account(100);
        Account accountTo = new Account(101);
        // Act
        Balance fromAccountBalance = transferService.transfer(accountFrom, accountTo);
        // Assert
        assertNotNull(fromAccountBalance);
        assertTrue(fromAccountBalance.getAmount() >= 0);
    }

    @Test
    public void test_Transfer_NegativeBalance() {
        // Assemble
        TransfersDAO transfersDAO = mock(TransfersDAO.class);
        transferService.setTransferDao(transfersDAO);
        Account accountFrom = new Account(100);
        Account accountTo = new Account(101);
        // Act
        Balance fromAccountBalance = transferService.transfer(accountFrom, accountTo);
        // Assert
        assertNotNull(fromAccountBalance);
        assertTrue(fromAccountBalance.getAmount() >= 0);
    }

    private Map<Integer, Account> getSampleData() throws IOException {
        ObjectMapper mapper = new ObjectMapper();  
        mapper.readValue(DATA,new TypeReference<Map<String, Account>>() {  
        });   
        return null;
    }

    public static final String DATA = "{\"101\":{\"number\":101,\"balance\":0},\"102\":{\"number\":102,\"balance\":0}}";

}

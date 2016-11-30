package clientAccountDocumentProject;

import java.math.BigDecimal;
/**
 * Created by Пентагон on 09.10.2016.
 */
public class Account {
    private Long id;
    private BigDecimal saldo;
    private String accountNumber;
    private Client client;

    public Account(){
        this.id = null;
        this.saldo = null;
        this.accountNumber = null;
        this.client = null;
    }

    public Account(Long id, BigDecimal saldo, String accountNumber, Client client) {
        this.id = id;
        this.saldo = saldo;
        this.accountNumber = accountNumber;
        this.client = client;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}

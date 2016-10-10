package clientAccountDocumentProject;

import java.math.BigDecimal;

/**
 * Created by Пентагон on 09.10.2016.
 */
public class Client {
    private Long id;
    private String name;

    public Client() {
        this.id = null;
        this.name = null;
    }

    public Client(Long newId, String newName) {
        this.id = newId;
        this.name = newName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

/*
        DROP TABLE clients;

        CREATE TABLE IF NOT EXISTS clients(id INT, name VARCHAR2(100));

        INSERT INTO clients VALUES (1, 'big bos');
        INSERT INTO clients VALUES (2, 'not a bos');

        SELECT * FROM clients;
*/

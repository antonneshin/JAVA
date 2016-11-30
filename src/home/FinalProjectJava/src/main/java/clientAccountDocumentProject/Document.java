package clientAccountDocumentProject;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Пентагон on 23.10.2016.
 */
public class Document {
    private Long id;
    private Account accDT;
    private Account accCT;
    private BigDecimal summa;
    private String purpose;
    private Date docDate;

    public Document() {
        this.id = null;
        this.accCT = null;
        this.accDT = null;
        this.summa = null;
        this.purpose = null;
        this.docDate = null;
    }

    public Document(Long id, Account accDT, Account accCT, BigDecimal summa, String purpose, Date docDate) {
        this.id = id;
        this.accDT = accDT;
        this.accCT = accCT;
        this.summa = summa;
        this.purpose = purpose;
        this.docDate = docDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Account getAccDT() {
        return accDT;
    }

    public void setAccDT(Account accDT) {
        this.accDT = accDT;
    }

    public Account getAccCT() {
        return accCT;
    }

    public void setAccCT(Account accCT) {
        this.accCT = accCT;
    }

    public BigDecimal getSumma() {
        return summa;
    }

    public void setSumma(BigDecimal summa) {
        this.summa = summa;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public Date getDocDate() {
        return docDate;
    }

    public void setDocDate(Date docDate) {
        this.docDate = docDate;
    }
}
/*
CREATE TABLE documents(
id INTEGER,
accDT INTEGER,
accCT INTEGER,
summa INTEGER,
purpose VARCHAR(100),
docDate DATE
);
*/
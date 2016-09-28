package src.home.sbt.homeClientAccountDocument;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

/**
 * Created by Пентагон on 29.09.2016.
 */
public class Document {
    private Long id;
    private Account accDT;
    private Account accCT;
    private BigDecimal summa;
    private String purpose;
    private Date docDate;

    public Document(Long id, Account accDT, Account accCT, BigDecimal summa, String purpose, Date docDate) {
        this.id = id;
        this.accDT = accDT;
        this.accCT = accCT;
        this.summa = summa;
        this.purpose = purpose;
        this.docDate = docDate;
        loadDocumentInDB(id, accDT, accCT, summa, purpose, docDate);
    }

    private void loadDocumentInDB(Long id, Account accDT, Account accCT, BigDecimal summa, String purpose, Date docDate) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "");
            PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO documents(id, accDT, accCT, summa, purpose, docDate) VALUES (?,?,?,?,?,?)");
            preparedStatement.setLong(1, id);
            preparedStatement.setLong(2, accDT.getId());
            preparedStatement.setLong(3, accCT.getId());
            preparedStatement.setBigDecimal(4, summa);
            preparedStatement.setString(5, purpose);
            preparedStatement.setDate(6, (java.sql.Date) docDate);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Long getId() {
        return id;
    }

    public Account getAccDT() {
        return accDT;
    }

    public Account getAccCT() {
        return accCT;
    }

    public BigDecimal getSumma() {
        return summa;
    }

    public String getPurpose() {
        return purpose;
    }

    public Date getDocDate() {
        return docDate;
    }
}

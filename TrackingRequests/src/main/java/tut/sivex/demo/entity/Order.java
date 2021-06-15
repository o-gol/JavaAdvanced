package tut.sivex.demo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * $table.getTableComment()
 */
@Data
@Entity
@Table(name = "order")
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "employee_id", nullable = false)
    private Long employeeId;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employeeCustomer;

    @Column(name = "employee_id_verifier", nullable = false)
    private Long employeeIdVerifier;

    @ManyToOne
    @JoinColumn(name = "employee_id_verificator")
    private Employee employeeVerifier;

    @Column(name = "order_finished", nullable = false)
    private Boolean orderFinished;

    @Column(name = "date_begin", nullable = false, updatable = false)
    @JsonFormat(pattern = "yyyy-mm-dd HH:mm:ss")
    private LocalDateTime dateBegin;

    @Column(name = "date_finished", nullable = false, updatable = false)
    @JsonFormat(pattern = "yyyy-mm-dd HH:mm:ss")
    private LocalDateTime dateFinished;

    @Column(name = "department_id")
    private Long departmentId;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;


    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "comment")
    private String comment;

    @PrePersist
    protected void onCreate(){
        this.dateBegin=LocalDateTime.now();
    }



}

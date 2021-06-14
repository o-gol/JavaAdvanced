package tut.sivex.demo.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * $table.getTableComment()
 */
@Data
@Entity
@Table(name = "order")
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "employee_id", nullable = false)
    private Long employeeId;

    @Column(name = "order_finished", nullable = false)
    private Boolean orderFinished;

    @Column(name = "date_begin", nullable = false)
    private LocalDate dateBegin;

    @Column(name = "date_finished", nullable = false)
    private LocalDate dateFinished;

    @Column(name = "department_id")
    private Long departmentId;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "comment")
    private String comment;

}

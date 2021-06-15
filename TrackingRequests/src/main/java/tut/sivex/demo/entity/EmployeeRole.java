package tut.sivex.demo.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * $table.getTableComment()
 */
@Data
@Entity
@Table(name = "employee_role")
public class EmployeeRole implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "employee_id", nullable = false)
    private Long employeeId;

    @Column(name = "role_id", nullable = false)
    private Long roleId;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


}

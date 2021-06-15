package tut.sivex.demo.entity;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import tut.sivex.demo.entity.enums.Role;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

/**
 * $table.getTableComment()
 */
@Data
@Entity
@Table(name = "employee")
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "department_id", nullable = false)
    private Long departmentId;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "surname", nullable = false)
    private String surname;

    @Column(name="post_id",nullable = false)
    private Long postId;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    @Column(name = "parent_id")
    private Long parentId;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Employee employee;


    @Column(length = 3000)
    private String password;

    @ElementCollection(targetClass = Role.class)
    @CollectionTable(name="employee_role",
    joinColumns = {@JoinColumn(name= "employee_id"),@JoinColumn(name = "role_id")}
     )
    private Set<Role> roles=new HashSet<>();

    @OneToMany(targetEntity = Order.class, mappedBy = "employeeCustomer")
    private List<Order> orders=new ArrayList<>();

    @Transient
    private Collection<? extends GrantedAuthority> authorities;






}

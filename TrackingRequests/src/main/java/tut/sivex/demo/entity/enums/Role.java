/*
package tut.sivex.demo.entity.enums;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

*/
/**
 * $table.getTableComment()
 *//*

@Data
@Entity
@Table(name = "role")
public class Role implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

}
*/

package tut.sivex.demo.entity.enums;
public enum Role{
    ROLE_USER,
    ROLE_MASTER,
    ROLE_ADMIN,
    ROLE_REVISION
}

package merveozer.pokemonWorld.model.auth;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Data
@Table(name="role_table")
public class Role {

    @Id
    @Column(name="role_id")
    private Long roleId;
    
    @Column(name="role_name")
    private String roleName;

}
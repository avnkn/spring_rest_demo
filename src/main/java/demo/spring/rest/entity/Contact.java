package demo.spring.rest.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Contact {
    @Id
    @Column(name = "ID")
    private int id;
    @Column(name = "NAME")
    private String name;
}

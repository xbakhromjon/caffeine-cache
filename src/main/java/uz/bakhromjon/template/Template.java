package uz.bakhromjon.template;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author : Bakhromjon Khasanboyev
 * @since : 19/10/22, Wed, 09:49
 **/
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Template {
    @Id
    private Long id;
    private String description;
}

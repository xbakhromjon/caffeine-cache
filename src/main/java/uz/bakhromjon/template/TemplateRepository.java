package uz.bakhromjon.template;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author : Bakhromjon Khasanboyev
 * @username: @xbakhromjon
 * @since : 19/10/22, Wed, 09:51
 **/
@Repository
public interface TemplateRepository extends JpaRepository<Template, Long> {
}

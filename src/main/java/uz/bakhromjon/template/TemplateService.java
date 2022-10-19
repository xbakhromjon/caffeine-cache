package uz.bakhromjon.template;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.bakhromjon.exception.ElementNotFoundException;

import java.util.List;
import java.util.Optional;

/**
 * @author : Bakhromjon Khasanboyev
 * @username: @xbakhromjon
 * @since : 19/10/22, Wed, 09:51
 **/
@Service
public class TemplateService {
    private final String HASH = "template";
    @Autowired
    private TemplateRepository repository;

    @Autowired
    private CacheManager cacheManager;

    public ResponseEntity<?> create(Template template) {
        Template saved = repository.save(template);
        return ResponseEntity.ok(saved);
    }

    @CachePut(value = HASH, key = "#template.id")
    public ResponseEntity<?> update(Template template) {
        Template updated = repository.save(template);
        return ResponseEntity.ok(updated);
    }

    @Cacheable(value = HASH, key = "#id")
    public ResponseEntity<?> get(Long id) {
        Optional<Template> optional =
                repository.findById(id);
        Template template = optional.orElseThrow(() -> {
            throw new ElementNotFoundException("Element not found", HttpStatus.NOT_FOUND);
        });
        return ResponseEntity.ok(template);
    }

    public ResponseEntity<?> list() {
        List<Template> all = repository.findAll();
        return ResponseEntity.ok(all);
    }

    @CacheEvict(value = HASH, key = "#id")
    public ResponseEntity<?> delete(Long id) {
        repository.deleteById(id);
        return ResponseEntity.ok(true);
    }
}

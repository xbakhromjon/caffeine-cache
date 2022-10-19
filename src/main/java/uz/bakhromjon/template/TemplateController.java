package uz.bakhromjon.template;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author : Bakhromjon Khasanboyev
 * @username: @xbakhromjon
 * @since : 19/10/22, Wed, 09:51
 **/
@RestController
@RequestMapping("/template")
public class TemplateController {
    @Autowired
    private TemplateService service;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Template template) {
        return service.create(template);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Template template) {
        return service.update(template);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable Long id) {
        return service.get(id);
    }

    @GetMapping()
    public ResponseEntity<?> list() {
        return service.list();
    }

    @DeleteMapping()
    public ResponseEntity<?> delete(@RequestParam Long id) {
        return service.delete(id);
    }
}

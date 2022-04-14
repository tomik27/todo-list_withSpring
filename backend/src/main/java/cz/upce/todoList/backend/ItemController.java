package cz.upce.todoList.backend;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/api/items")
    public Page<Item> getItems(@RequestParam(defaultValue = "0") Integer page,@RequestParam(defaultValue = "id") String sortBy){
     return   itemService.getItem(page, sortBy);
    }

    @PostMapping("/api/item")
    public ItemDto createItem(@RequestBody @Valid CreateItemDtoIn createItemDtoIn){
        return   itemService.createItem(createItemDtoIn);
    }
    @DeleteMapping("/api/item/{id}")
    public ResponseEntity<?> deleteItem(@PathVariable Long id) {
        try {
            itemService.delete(id);
            return ResponseEntity.ok().build();
        }
        catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
        }
    }
}

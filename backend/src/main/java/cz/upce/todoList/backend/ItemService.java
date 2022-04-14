package cz.upce.todoList.backend;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class ItemService {
    private final ItemRepository itemRepository;

    private final ModelMapper mapper;
    public ItemService(ItemRepository itemRepository, ModelMapper mapper) {
        this.itemRepository = itemRepository;
        this.mapper = mapper;
    }

    public Page<Item> getItem(Integer page, String sortBy) {

        PageRequest of = PageRequest.of(page, 10, Sort.Direction.ASC, sortBy);
        return   itemRepository.findAll(of);
    }

    public ItemDto createItem(CreateItemDtoIn createItemDtoIn) {

        Item item = mapper.map(createItemDtoIn, Item.class);
        Item save = itemRepository.save(item);
        return mapper.map(save, ItemDto.class);
    }

    public void delete(Long id) {
        itemRepository.deleteById(id);
    }
}

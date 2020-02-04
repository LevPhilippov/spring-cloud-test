package lev.filippov.service;

import lev.filippov.ItemDto;
import lev.filippov.mappers.ItemItemDtoMapper;
import lev.filippov.model.Item;
import lev.filippov.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    private ItemRepository itemRepository;
    private ItemItemDtoMapper itemItemDtoMapper;

    @Autowired
    public ItemService(ItemRepository itemRepository, ItemItemDtoMapper itemItemDtoMapper) {
        this.itemRepository = itemRepository;
        this.itemItemDtoMapper = itemItemDtoMapper;
    }

    public List<ItemDto> getAllItemDtos() {
        List<Item> items = itemRepository.findAll();
        return itemItemDtoMapper.ItemsToItemsDtos(items);
    }

    public ItemDto save(ItemDto itemDto) {
        Item item = itemItemDtoMapper.ItemDtoToItem(itemDto);
        System.out.println(item);
        return itemItemDtoMapper.ItemToItemDto(itemRepository.save(item));
    }

    public void delete(Long id) {
        itemRepository.deleteById(id);
    }
}

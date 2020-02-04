package lev.filippov.controller;

import lev.filippov.ItemDto;
import lev.filippov.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ItemControllerImpl implements ItemController {

    private ItemService itemService;

    @Autowired
    public ItemControllerImpl(ItemService itemService) {
        this.itemService = itemService;
    }

    @Override
    @GetMapping(value = "/get")
    public List<ItemDto> getAllItems() {
        return itemService.getAllItemDtos();
    }

    @Override
    @PostMapping(value = "/save")
    public ItemDto saveItem(@RequestBody ItemDto itemDto) {
        return itemService.save(itemDto);
    }

    @Override
    @GetMapping (value = "/delete/{id}")
    public String delete(@PathVariable(value = "id") Long id){
        itemService.delete(id);
        return HttpStatus.OK.getReasonPhrase();
    }
}

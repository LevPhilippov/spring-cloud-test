package lev.filippov.controller;

import lev.filippov.ItemDto;
import lev.filippov.model.Item;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface ItemController {

    @GetMapping(value = "/get")
    List<ItemDto> getAllItems();

    @PostMapping(value = "/save")
    ItemDto saveItem(@RequestBody ItemDto itemDto);

    @GetMapping (value = "/delete/{id}")
    String delete(@PathVariable(value = "id") Long id);
}

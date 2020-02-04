package lev.filippov.controllers;

import lev.filippov.ItemDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("backend")
public interface ItemClient {

    @GetMapping(value = "/get")
    List<ItemDto> getAllItems();

    @PostMapping(value = "/save")
    ItemDto saveItem(@RequestBody ItemDto itemDto);

    @GetMapping (value = "/delete/{id}")
    String delete(@PathVariable(value = "id") Long id);
}

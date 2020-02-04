package lev.filippov.controllers;

import lev.filippov.ItemDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import java.util.List;

@Controller
public class MainControllerImpl {
    private ItemClient itemClient;
    private RestTemplate restTemplate;

    @Autowired
    public MainControllerImpl(ItemClient itemClient, RestTemplate restTemplate) {
        this.itemClient = itemClient;
        this.restTemplate = restTemplate;
    }

    @GetMapping(value = "/items")
    public String getAllItems(Model model){
        List<ItemDto> items = itemClient.getAllItems();
//        List<ItemDto> items =(List<ItemDto>)restTemplate.getForObject("http://backend/get", List.class);
        model.addAttribute("items",items);
        return "index";
    }

    @PostMapping(value = "/items/save")
    @ResponseBody
    public ItemDto saveItemDto(@ModelAttribute ItemDto itemDto){
        System.out.println(itemDto);
        return restTemplate.postForObject("http://backend/save",itemDto,ItemDto.class);
    }

    @GetMapping(value = "/items/add")
    public String addItem(Model model) {
        model.addAttribute(new ItemDto());
        return "add";
    }

    @GetMapping(value = "/items/delete/{id}")
    @ResponseBody
    public String delete(@PathVariable Long id){
        return itemClient.delete(id);
    }


}

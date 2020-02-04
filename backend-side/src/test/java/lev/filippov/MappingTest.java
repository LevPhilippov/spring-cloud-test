package lev.filippov;

import lev.filippov.mappers.ItemItemDtoMapper;
import lev.filippov.model.Item;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class MappingTest {
    ItemItemDtoMapper itemItemDtoMapper;
    Item item;
    ItemDto myItemDto;

    List<Item> items;

    @Autowired
    public MappingTest(ItemItemDtoMapper itemItemDtoMapper) {
        this.itemItemDtoMapper = itemItemDtoMapper;
    }

    @BeforeEach
    void beforeEach() {
        item = new Item();
        item.setId(1L);
        item.setTitle("Condoms");
        item.setPrice(350);

        myItemDto=new ItemDto();

        myItemDto.setId(2L);
        myItemDto.setTitle("Slave");
        myItemDto.setPrice(1000000000);


        items = new ArrayList<>();

        Item item1 = new Item();
        item1.setId(3L);
        item1.setTitle("Condoms");
        item1.setPrice(300);
        items.add(item1);
        Item item2 = new Item();
        item2.setId(4L);
        item2.setTitle("Slaves");
        item2.setPrice(400);
        items.add(item2);
    }

    @Test
    void ItemToDto() {
        ItemDto itemDto = itemItemDtoMapper.ItemToItemDto(item);
        assertEquals(item.getId(),itemDto.getId());
        assertEquals(item.getTitle(),itemDto.getTitle());
        assertEquals(item.getPrice(),itemDto.getPrice());
    }

    @Test
    void ItemDtoToItem() {
        Item item = itemItemDtoMapper.ItemDtoToItem(myItemDto);
        assertEquals(myItemDto.getId(),item.getId());
        assertEquals(myItemDto.getTitle(),item.getTitle());
        assertEquals(myItemDto.getPrice(),item.getPrice());
    }

    @Test
    void ItemsToDtos() {
        List<ItemDto> itemDtos = itemItemDtoMapper.ItemsToItemsDtos(items);
        for(int i = 0; i<itemDtos.size(); i++){
            assertEquals(itemDtos.get(i).getId(),items.get(i).getId());
            assertEquals(itemDtos.get(i).getTitle(),items.get(i).getTitle());
            assertEquals(itemDtos.get(i).getPrice(),items.get(i).getPrice());
        }
    }


}

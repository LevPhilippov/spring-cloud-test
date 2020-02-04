package lev.filippov.mappers;

import lev.filippov.ItemDto;
import lev.filippov.model.Item;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface ItemItemDtoMapper {
    ItemDto ItemToItemDto(Item item);
    Item ItemDtoToItem(ItemDto itemDto);

    List<ItemDto> ItemsToItemsDtos(List<Item> items);

    List<Item> ItemDtosToItems(List<ItemDto> itemDtos);
}


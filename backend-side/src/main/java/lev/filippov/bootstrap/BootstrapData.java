package lev.filippov.bootstrap;

import lev.filippov.model.Item;
import lev.filippov.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements ApplicationListener<ContextRefreshedEvent> {

    private ItemRepository itemRepository;

    public BootstrapData(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        Item item = new Item(1L,"Condoms",350);
        Item item1 = new Item(2L,"Slaves", 450);
        Item item3 = new Item(3L, "Chairs", 550);
        itemRepository.save(item);
        itemRepository.save(item1);
        itemRepository.save(item3);
    }
}

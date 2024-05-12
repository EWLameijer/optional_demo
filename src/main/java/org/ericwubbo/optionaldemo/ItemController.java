package org.ericwubbo.optionaldemo;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ItemController {
    private final ItemRepository itemRepository;

    @GetMapping
    public Iterable<Item> getAll() {
        return itemRepository.findAll();
    }

    @GetMapping("{name}")
    public Item getByName(@PathVariable String name) {
        Item item = itemRepository.findByName(name);
        String storedName = item.getName();
        String moreImpressiveName = Character.toUpperCase(storedName.charAt(0)) + storedName.substring(1);
        item.setName(moreImpressiveName); 
        return item;
    }
}
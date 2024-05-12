package org.ericwubbo.optionaldemo;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

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
        Optional<Item> possibleItem = itemRepository.findByName(name);
        if (possibleItem.isEmpty()) return null;
        Item item = possibleItem.get();
        String storedName = item.getName();
        String moreImpressiveName = Character.toUpperCase(storedName.charAt(0)) + storedName.substring(1);
        item.setName(moreImpressiveName); 
        return item;
    }
}
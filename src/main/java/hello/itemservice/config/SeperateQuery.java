package hello.itemservice.config;

import hello.itemservice.repository.ItemRepository;
import hello.itemservice.repository.jpa.JpaItemRepository2;
import hello.itemservice.repository.jpa.JpaItemRepository3;
import hello.itemservice.repository.jpa.SpringDataJpaItemRepository;
import hello.itemservice.repository.seperateQuery.ItemQueryRepositoryV2;
import hello.itemservice.repository.seperateQuery.ItemRepositoryV2;
import hello.itemservice.service.ItemService;
import hello.itemservice.service.ItemServiceV1;
import hello.itemservice.service.ItemServiceV2;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;

@Configuration
@RequiredArgsConstructor
public class SeperateQuery {

    private final EntityManager em;
    private final ItemRepositoryV2 itemRepositoryV2;
    @Bean
    public ItemService itemService() {
        return new ItemServiceV2(itemRepositoryV2, new ItemQueryRepositoryV2(em));
    }

    @Bean
    public ItemQueryRepositoryV2 itemQueryRepositoryV2() {
        return new ItemQueryRepositoryV2(em);
    }

    @Bean
    public ItemRepository itemRepository() {
        return new JpaItemRepository3(em);
    }

}

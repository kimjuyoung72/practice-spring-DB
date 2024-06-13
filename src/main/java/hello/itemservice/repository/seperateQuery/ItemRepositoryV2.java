package hello.itemservice.repository.seperateQuery;

import hello.itemservice.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepositoryV2 extends JpaRepository<Item, Long> {
}

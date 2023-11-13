package de.startat.collectionmanagement

import de.startat.collectionmanagement.item.CollectionItem
import de.startat.collectionmanagement.item.CollectionItemRepository
import de.startat.collectionmanagement.list.CollectionList
import de.startat.collectionmanagement.list.CollectionListRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories

@SpringBootApplication
@EnableJdbcRepositories
class CollectionManagementApplication(
    val collectionRepository: CollectionListRepository,
    val itemRepository: CollectionItemRepository
) : CommandLineRunner {

    override fun run(vararg args: String?) {
        collectionRepository.deleteAll()
        itemRepository.deleteAll()


        val item1 = CollectionItem(name = "A first item")
        item1.addInfo("year of creation", "2023")
        item1.addInfo("Format", "Music CD")
        val persistedItem1 = itemRepository.save(item1)

        val item2 = CollectionItem(name = "A second item")
        item2.addInfo("Shop", "Amazon")
        item2.addInfo("Format", "MP3")
        val persistedItem2 = itemRepository.save(item2)

        println(itemRepository.findAll())

        val first = CollectionList(name = "My first music collection")
        first.addItem(persistedItem1)
        first.addItem(persistedItem2)
        collectionRepository.save(first)
        println(collectionRepository.findAll())

        val items = itemRepository.findAllById(first.getItemIds())
        println(items)

        val bla = itemRepository.findByAdditionalInfo("Format", "MP3")
        println(bla)

        val second = collectionRepository.save(CollectionList(name = "A second collection"))
        second.addItem(persistedItem1)
        collectionRepository.save(second)
    }
}

fun main(args: Array<String>) {
    runApplication<CollectionManagementApplication>(*args)
}

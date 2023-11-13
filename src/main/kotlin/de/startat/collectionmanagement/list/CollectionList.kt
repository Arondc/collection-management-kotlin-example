package de.startat.collectionmanagement.list


import de.startat.collectionmanagement.item.CollectionItem
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.util.*
import kotlin.collections.LinkedHashSet

data class CollectionList(
    @Id val id: UUID? = null, val name: String, private val items: MutableSet<CollectionItemRef> = LinkedHashSet()
) {

    fun addItem(item: CollectionItem) {
        items.add(CollectionItemRef(item.id!!))
    }

    fun getItemIds(): Set<UUID> = items.map { it.collectionItem }.toSet()
}

@Table("COLLECTION_LIST_ITEMS")
data class CollectionItemRef(val collectionItem: UUID)



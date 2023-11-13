package de.startat.collectionmanagement.item

import org.springframework.data.jdbc.repository.query.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param
import java.util.UUID

interface CollectionItemRepository:CrudRepository<CollectionItem, UUID>{

    @Query("SELECT * FROM COLLECTION_ITEM ci where ci.id in (" +
            "SELECT ai.COLLECTION_ITEM FROM ADDITIONAL_INFO ai where " +
            "   ai.kee = :key and ai.valuee = :value)")
    fun findByAdditionalInfo(@Param("key") key: String, @Param("value") value : String) : Set<CollectionItem>

}

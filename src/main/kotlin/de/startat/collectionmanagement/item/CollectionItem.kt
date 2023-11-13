package de.startat.collectionmanagement.item

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import java.util.*

data class CollectionItem(
    @Id val id: UUID? = null,
    val name: String,
    private val additionalInfo: MutableSet<AdditionalInfo> = LinkedHashSet()
) {

    fun addInfo(key: String, value: String): AdditionalInfo {
        val info = AdditionalInfo(null, key, value)
        additionalInfo.add(info)
        return info
    }

}

/** "KEY" and "VALUE" are reserved words in H2DB so we have to be a bit creative with the column naming */
data class AdditionalInfo(@Id val id: UUID?, @Column("KEE") val key: String, @Column("VALUEE") val value: String)




package com.astrodesing.increase.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey


@Entity(tableName = "modalidades", indices = [Index(value = ["modalidad"], unique = true)])
data class EntitiesModalidades(
    @PrimaryKey
    @ColumnInfo(
        name = "modalidad",
        defaultValue = "Quincenal"
    ) val modalidad: String
)

import java.util.*

data class DinoSpawn(val dino: Dino, val entryWeight: Double, val maxPercentage: Double, val uniqueName: String = UUID.randomUUID()
    .toString().replace("-", "_")){
    fun toEntriesString(): String {
        return "(AnEntryName=\"$uniqueName\",EntryWeight=$entryWeight,NPCsToSpawnStrings=(\"${dino.entityID}\"))"
    }

    fun toLimitsString(): String {
        return "(NPCClassString=\"${dino.entityID}\",MaxPercentageOfDesiredNumToAllow=$maxPercentage)"
    }
}
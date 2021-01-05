import java.lang.StringBuilder
import java.util.*

data class SpawnContainer(val area: SpawnArea, val spawns: List<DinoSpawn>, val prettyPrint: Boolean = false) {
    override fun toString(): String {
        val sb = StringBuilder()

        sb.append("ConfigAddNPCSpawnEntriesContainer=(")
        if (prettyPrint)
            sb.append("\n\t")
        sb.append("NPCSpawnEntriesContainerClassString=\"$area\",")
        if (prettyPrint)
            sb.append("\n\t")

        // Spawn entries
        sb.append("NPCSpawnEntries=(")
        if (prettyPrint)
            sb.append("\n\t\t")

        val sj1 = StringJoiner(if (prettyPrint) ",\n\t\t" else ",")
        for (spawn in spawns) {
            sj1.add(spawn.toEntriesString())
        }
        sb.append(sj1)
        if (prettyPrint)
            sb.append("\n\t")

        sb.append("),")

        // Spawn entries
        sb.append("NPCSpawnLimits=(")
        if (prettyPrint)
            sb.append("\n\t\t")
        val sj2 = StringJoiner(if (prettyPrint) ",\n\t\t" else ",")
        for (spawn in spawns) {
            sj2.add(spawn.toLimitsString())
        }
        sb.append(sj2)
        if (prettyPrint)
            sb.append("\n\t")

        sb.append(")")
        if (prettyPrint)
            sb.append("\n")
        sb.append(")")

        return sb.toString()
    }
}
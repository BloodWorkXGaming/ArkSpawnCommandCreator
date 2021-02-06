class ArkSpawnCreator(val pairList: MutableList<Pair<SpawnArea, DinoSpawn>> = mutableListOf()) {
    fun toContainerList(prettyPrint: Boolean = false): List<SpawnContainer> {
        val map: MutableMap<SpawnArea, MutableList<DinoSpawn>> = mutableMapOf()

        for (pair in pairList) {
            val list = map.getOrDefault(pair.first, mutableListOf())
            list.add(pair.second)

            map[pair.first] = list
        }

        return map.map {
            SpawnContainer(it.key, it.value, prettyPrint)
        }
    }

    fun printAll(prettyPrint: Boolean = false) {
        for (spawnContainer in toContainerList(prettyPrint)) {
            println(spawnContainer.toString())
        }
    }
}

fun main() {
    ArkSpawnCreator(
        mutableListOf(
            SpawnArea.SNOW_FOREST to DinoSpawn(Dino.SNOW_OWL, 0.1, 0.01),
            SpawnArea.ICE_DESERT to DinoSpawn(Dino.SNOW_OWL, 0.1, 0.01),

            SpawnArea.SNOW_FOREST to DinoSpawn(Dino.MANAGARMR, 0.01, 0.002),
            SpawnArea.ICE_DESERT to DinoSpawn(Dino.MANAGARMR, 0.01, 0.002),

            SpawnArea.SNOW_FOREST to DinoSpawn(Dino.GRIFFIN, 0.1, 0.0075),
            SpawnArea.ICE_DESERT to DinoSpawn(Dino.GRIFFIN, 0.1, 0.0075),

            SpawnArea.TUNDRA to DinoSpawn(Dino.REAPER_QUEEN, 0.1, 0.01),
            SpawnArea.CHALK_HILLS_PLAINS to DinoSpawn(Dino.THORNY_DRAGON, 0.1, 0.03),

            SpawnArea.SAVANA to DinoSpawn(Dino.GASBAG, 0.1, 0.002),
            SpawnArea.GRASSLAND to DinoSpawn(Dino.TROPEOGNATHUS, 0.1, 0.005),

            SpawnArea.SAVANA to DinoSpawn(Dino.VULTURE, 0.1, 0.005),
            SpawnArea.TUNDRA to DinoSpawn(Dino.VULTURE, 0.1, 0.005),

            SpawnArea.GRASSLAND to DinoSpawn(Dino.GACHA, 0.1, 0.001),
            SpawnArea.ATOLL to DinoSpawn(Dino.GACHA, 0.1, 0.001),
            
            SpawnArea.SNOW_FOREST to DinoSpawn(Dino.SHINEHORN, 0.1, 0.0005),
            SpawnArea.ICE_DESERT to DinoSpawn(Dino.SHINEHORN, 0.1, 0.0005),
        )
    ).printAll(false)
}


/*

ConfigAddNPCSpawnEntriesContainer=(NPCSpawnEntriesContainerClassString="DinoSpawnEntriesTundra_C",
NPCSpawnEntries=((AnEntryName="VelonaTundra",EntryWeight=0.125,NPCsToSpawnStrings=("Spindles_Character_BP_C"))),
NPCSpawnLimits=((NPCClassString="Spindles_Character_BP_C", MaxPercentageOfDesiredNumToAllow=0.075)))

ConfigAddNPCSpawnEntriesContainer=(
    NPCSpawnEntriesContainerClassString="DinoSpawnEntries_Valguero_SnowForest_C",
    NPCSpawnEntries=(
        (AnEntryName="Owl_SnowForest",EntryWeight=1.0,NPCsToSpawnStrings=("Owl_Character_BP_C")),
        (AnEntryName="Managarmr_SnowForest",EntryWeight=0.01,NPCsToSpawnStrings=("IceJumper_Character_BP_C")),
        (AnEntryName="Griffin_SnowForest",EntryWeight=0.5,NPCsToSpawnStrings=("Griffin_Character_BP_C"))
    ),
    NPCSpawnLimits=(
        (NPCClassString="Owl_Character_BP_C", MaxPercentageOfDesiredNumToAllow=0.1),
        (NPCClassString="IceJumper_Character_BP_C", MaxPercentageOfDesiredNumToAllow=0.002),
        (NPCClassString="Griffin_Character_BP_C",MaxPercentageOfDesiredNumToAllow=0.075)
    )
)
ConfigAddNPCSpawnEntriesContainer=(NPCSpawnEntriesContainerClassString="DinoSpawnEntries_Valguero_IceDesert_C",
NPCSpawnEntries=(
    (AnEntryName="Owl_IceDesert",EntryWeight=1.0,NPCsToSpawnStrings=("Owl_Character_BP_C")),
    (AnEntryName="Managarmr_IceDesert",EntryWeight=0.01,NPCsToSpawnStrings=("IceJumper_Character_BP_C")),
    (AnEntryName="Griffin_IceDesert",EntryWeight=0.5,NPCsToSpawnStrings=("Griffin_Character_BP_C"))),
NPCSpawnLimits=(
    (NPCClassString="Owl_Character_BP_C", MaxPercentageOfDesiredNumToAllow=0.1),
    (NPCClassString="IceJumper_Character_BP_C", MaxPercentageOfDesiredNumToAllow=0.002),
    (NPCClassString="Griffin_Character_BP_C",MaxPercentageOfDesiredNumToAllow=0.075)))

ConfigAddNPCSpawnEntriesContainer=(NPCSpawnEntriesContainerClassString="Val_DinoSpawnEntries_DrakeTrench_C",NPCSpawnEntries=((AnEntryName="ReaperQueen_AberrationCave",EntryWeight=0.05,NPCsToSpawnStrings=("Xenomorph_Character_BP_Female_C"))),NPCSpawnLimits=((NPCClassString="Xenomorph_Character_BP_Female_C",MaxPercentageOfDesiredNumToAllow=0.01))

ConfigAddNPCSpawnEntriesContainer=(NPCSpawnEntriesContainerClassString="DinoSpawnEntriesSavana",NPCSpawnEntries=((AnEntryName="Custom_Gasbag_Savana",EntryWeight=0.1,NPCsToSpawnStrings=("GasBags_Character_BP_C"))),NPCSpawnLimits=((NPCClassString="GasBags_Character_BP_C",MaxPercentageOfDesiredNumToAllow=0.05))
ConfigAddNPCSpawnEntriesContainer=(NPCSpawnEntriesContainerClassString="DinoSpawnEntriesGrassland",NPCSpawnEntries=((AnEntryName="Custom_Tropeognathus_Grasslands",EntryWeight=1,NPCsToSpawnStrings=("Tropeognathus_Character_BP_C"))),NPCSpawnLimits=((NPCClassString="Tropeognathus_Character_BP_C",MaxPercentageOfDesiredNumToAllow=0.1))
ConfigAddNPCSpawnEntriesContainer=(NPCSpawnEntriesContainerClassString="DinoSpawnEntriesSavana",NPCSpawnEntries=((AnEntryName="Custom_Vulture_Savana",EntryWeight=1,NPCsToSpawnStrings=("Vulture_Character_BP_C"))),NPCSpawnLimits=((NPCClassString="Vulture_Character_BP_C",MaxPercentageOfDesiredNumToAllow=0.1))
ConfigAddNPCSpawnEntriesContainer=(NPCSpawnEntriesContainerClassString="DinoSpawnEntriesTundra",NPCSpawnEntries=((AnEntryName="Custom_Vulture_Tundra",EntryWeight=1,NPCsToSpawnStrings=("Vulture_Character_BP_C"))),NPCSpawnLimits=((NPCClassString="Vulture_Character_BP_C",MaxPercentageOfDesiredNumToAllow=0.1))
ConfigAddNPCSpawnEntriesContainer=(NPCSpawnEntriesContainerClassString="DinoSpawnEntriesGrassland",NPCSpawnEntries=((AnEntryName="Custom_Gacha_Grass",EntryWeight=1,NPCsToSpawnStrings=("Gacha_Character_BP_C"))),NPCSpawnLimits=((NPCClassString="Gacha_Character_BP_C",MaxPercentageOfDesiredNumToAllow=0.1))
ConfigAddNPCSpawnEntriesContainer=(NPCSpawnEntriesContainerClassString="DinoSpawnEntriesDamiensAtoll",NPCSpawnEntries=((AnEntryName="Custom_Gacha_Atoll",EntryWeight=1,NPCsToSpawnStrings=("Gacha_Character_BP_C"))),NPCSpawnLimits=((NPCClassString="Gacha_Character_BP_C",MaxPercentageOfDesiredNumToAllow=0.1))
ConfigAddNPCSpawnEntriesContainer=(NPCSpawnEntriesContainerClassString="DinoSpawnEntries_Valguero_SnowForest_C",NPCSpawnEntries=((AnEntryName="Custom_Shinehorn_Snow",EntryWeight=1.0,NPCsToSpawnStrings=("LanternGoat_Character_BP_C"))),NPCSpawnLimits=((NPCClassString="LanternGoat_Character_BP_C",MaxPercentageOfDesiredNumToAllow=0.05))
ConfigAddNPCSpawnEntriesContainer=(NPCSpawnEntriesContainerClassString="DinoSpawnEntries_Valguero_IceDesert_C",NPCSpawnEntries=((AnEntryName="Custom_Shinehorn_Ice",EntryWeight=1.0,NPCsToSpawnStrings=("LanternGoat_Character_BP_C"))),NPCSpawnLimits=((NPCClassString="LanternGoat_Character_BP_C",MaxPercentageOfDesiredNumToAllow=0.05))

*/

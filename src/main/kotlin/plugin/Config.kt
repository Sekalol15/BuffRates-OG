// This is free and unencumbered software released into the public domain.
// Author: Sekalol15
package plugin

import org.bukkit.configuration.file.FileConfiguration
import org.bukkit.configuration.file.YamlConfiguration
import java.io.File
object Config {
    private lateinit var config: FileConfiguration
    private lateinit var file: File

    fun load() {
        file = File(BuffRatesOG.plugin.dataFolder, "config.yml")
        if (!file.exists()) {
            BuffRatesOG.plugin.saveDefaultConfig()
        }

        config = YamlConfiguration.loadConfiguration(file)

        this.save()
    }

    private fun save() {
        config.save(file)
    }


    fun getSlimeChance(): Double {
        return config.get("slimeChance") as Double
    }
}
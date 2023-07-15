// This is free and unencumbered software released into the public domain.
// Author: Sekalol15
package plugin

import org.bukkit.configuration.file.FileConfiguration
import java.io.File

//config, not fully implemented
object Config {
        private lateinit var config: FileConfiguration
        private lateinit var file: File

        fun getSlimeChance(): Float {
            return config.get("slimeChance") as Float
        }
    }


// This is free and unencumbered software released into the public domain.
// Author: Sekalol15
package plugin
import org.bukkit.configuration.file.FileConfiguration
import org.bukkit.configuration.file.YamlConfiguration
import org.bukkit.plugin.java.JavaPlugin
import java.io.File
import org.bukkit.Bukkit
import org.bukkit.attribute.Attribute
object Config {
    private lateinit var config: FileConfiguration
    private lateinit var file: File

    fun getslimeChance(): Float {
        return config.get("slimeChance") as Float
    }

// Extending this class is standard bukkit boilerplate for any plugin, or else the server software won't load the classes.
class BuffRatesOG : JavaPlugin() {
    private var ConfigFile: File? = null
    var plugin: BuffRatesOG? = null
    override fun onEnable() {
        plugin = this
        server.pluginManager.registerEvents(Listeners(), this)
        CreateConfig()
    }

    private fun CreateConfig() {
        ConfigFile = File(dataFolder, "config.yml")
        if (!ConfigFile!!.exists()) {
            plugin!!.saveDefaultConfig()
        }
    }
}}


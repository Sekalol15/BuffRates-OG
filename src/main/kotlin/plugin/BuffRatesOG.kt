// This is free and unencumbered software released into the public domain.
// Author: Sekalol15
package plugin
import org.bukkit.configuration.file.FileConfiguration
import org.bukkit.configuration.file.YamlConfiguration
import org.bukkit.plugin.java.JavaPlugin
import java.io.File
import org.bukkit.Bukkit
import org.bukkit.attribute.Attribute


// Extending this class is standard bukkit boilerplate for any plugin, or else the server software won't load the classes.
class BuffRatesOG : JavaPlugin() {
    //config, not fully implemented yet
    private var ConfigFile: File? = null
    var plugin: BuffRatesOG? = null
    override fun onEnable() {
        plugin = this
        server.pluginManager.registerEvents(Listeners(), this)
        //createConfig()

    }
    //check for existing config, not fully implemented yet
    private fun createConfig() {
        ConfigFile = File(dataFolder, "config.yml")
        if (!ConfigFile!!.exists()) {
            plugin!!.saveDefaultConfig()


        }
    }
}


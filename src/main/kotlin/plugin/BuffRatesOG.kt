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
    companion object {
        lateinit var plugin: JavaPlugin
    }


    override fun onEnable() {
        plugin = this
        server.pluginManager.registerEvents(Listeners(), this)
        Config.load()


    }

    }






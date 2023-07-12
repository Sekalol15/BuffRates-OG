// This is free and unencumbered software released into the public domain.
// Author: Sekalol15
package plugin

import org.bukkit.entity.EntityType
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.CreatureSpawnEvent
import kotlin.random.Random

class Listeners : Listener {
    @EventHandler
    fun CreatureSpawnEvent(event: CreatureSpawnEvent) {
        val slimePos = event.entity.location
        var getChance = Config.getslimeChance()
        if (event.entity.entitySpawnReason != CreatureSpawnEvent.SpawnReason.CUSTOM && Random.nextDouble() <= getChance) {
            event.entity.world.spawnEntity(slimePos, EntityType.SLIME, CreatureSpawnEvent.SpawnReason.CUSTOM)


            //}
        }
    }
}

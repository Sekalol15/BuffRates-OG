// This is free and unencumbered software released into the public domain.
// Author: Sekalol15
package plugin

import org.bukkit.entity.EntityType
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.CreatureSpawnEvent
import org.bukkit.event.raid.RaidSpawnWaveEvent
import kotlin.random.Random

class Listeners : Listener {
    @EventHandler
    fun CreatureSpawnEvent(event: CreatureSpawnEvent) {
        var SlimeChanceEnabled = Config.getSlimeChanceEnabled()
        var SlimeChance = Config.getSlimeChance()
        var raiderQuantity = Config.getRaiderQuantity()

        var entityPos = event.entity.location
        var entityType = event.getEntityType()


        //check the conditions and spawn the slime if correct
        if (event.entity.entitySpawnReason != CreatureSpawnEvent.SpawnReason.CUSTOM && Random.nextDouble() <= SlimeChance && SlimeChanceEnabled == true) {

            event.entity.world.spawnEntity(entityPos, EntityType.SLIME, CreatureSpawnEvent.SpawnReason.CUSTOM)
        }

        if (event.entity.entitySpawnReason == CreatureSpawnEvent.SpawnReason.RAID && raiderQuantity != 0) {


            for(i in 1..raiderQuantity) {
                event.entity.world.spawnEntity(entityPos, entityType, CreatureSpawnEvent.SpawnReason.CUSTOM)




            }
        }
    }



        }






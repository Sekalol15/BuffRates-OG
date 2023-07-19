// This is free and unencumbered software released into the public domain.
// Author: Sekalol15
package plugin

import org.bukkit.Material
import org.bukkit.entity.EntityType
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.CreatureSpawnEvent
import org.bukkit.event.entity.EntityDeathEvent
import org.bukkit.inventory.ItemStack

import kotlin.random.Random

class Listeners : Listener {
    @EventHandler
    fun CreatureSpawnEvent(event: CreatureSpawnEvent) {

        val SlimeChanceEnabled = Config.getSlimeChanceEnabled()
        val SlimeChance = Config.getSlimeChance()
        val raiderQuantity = Config.getRaiderQuantity()

        val entityPos = event.entity.location
        val entityType = event.getEntityType()


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
    @EventHandler
    fun EntityDeathEvent(event: EntityDeathEvent) {

        val zombieIronEnabled = Config.getZombieIronEnabled()
        val zombieIron = Config.getZombieIron()

        if (event.entityType == EntityType.ZOMBIE && Random.nextDouble() <= zombieIron && zombieIronEnabled == true) {
            val entityPos = event.entity.location
            val iron = ItemStack(Material.IRON_INGOT)
            event.entity.world.dropItemNaturally(entityPos, iron)



        }

    }
}






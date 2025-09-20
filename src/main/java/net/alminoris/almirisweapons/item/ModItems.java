package net.alminoris.almirisweapons.item;

import net.alminoris.almirisweapons.AlmirisWeapons;
import net.alminoris.almirisweapons.item.custom.*;
import net.alminoris.almirisweapons.sound.ModSounds;
import net.alminoris.almirisweapons.util.helper.WeaponHelper;
import net.alminoris.almirisweapons.util.helper.WeaponSetsHelper;
import net.minecraft.item.AxeItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.item.SwordItem;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.UseAction;

import java.util.Dictionary;
import java.util.Hashtable;

import static net.alminoris.almirisweapons.util.helper.WeaponSetsHelper.TOOL_MATERIALS;

public class ModItems
{
    public static final Dictionary<String, Item> HALBERDS = new Hashtable<>();
    public static final Dictionary<String, Item> RAPIERS = new Hashtable<>();
    public static final Dictionary<String, Item> CLAYMORES = new Hashtable<>();
    public static final Dictionary<String, Item> BATTLE_AXES = new Hashtable<>();
    public static final Dictionary<String, Item> SAI = new Hashtable<>();
    public static final Dictionary<String, Item> MACES = new Hashtable<>();

    public static final Dictionary<String, Item> SCYTHES = new Hashtable<>();
    public static final Dictionary<String, Item> KATANAS = new Hashtable<>();
    public static final Dictionary<String, Item> ODACHIS = new Hashtable<>();
    public static final Dictionary<String, Item> BATTLE_STAVES = new Hashtable<>();
    public static final Dictionary<String, Item> DAGGERS = new Hashtable<>();
    public static final Dictionary<String, Item> GLAIVES = new Hashtable<>();

    public static final Dictionary<String, Item> DANE_AXES = new Hashtable<>();
    public static final Dictionary<String, Item> BEARDED_AXES = new Hashtable<>();
    public static final Dictionary<String, Item> KATARS = new Hashtable<>();

    public static final Dictionary<String, Item> STABBING_TIPS = new Hashtable<>();
    public static final Dictionary<String, Item> MACE_TIPS = new Hashtable<>();
    public static final Dictionary<String, Item> AXE_TIPS = new Hashtable<>();
    public static final Dictionary<String, Item> DOUBLEEDGE_BLADES = new Hashtable<>();
    public static final Dictionary<String, Item> SINGLEEDGE_BLADES = new Hashtable<>();
    public static final Dictionary<String, Item> CURVED_BLADES = new Hashtable<>();

    public static final Item ARQUEBUS_BARREL = registerItem("arquebus_barrel", new Item(new Item.Settings()));
    public static final Item BLUNDERBUSS_BARREL = registerItem("blunderbuss_barrel", new Item(new Item.Settings()));
    public static final Item PISTOL_BARREL = registerItem("pistol_barrel", new Item(new Item.Settings()));
    public static final Item MATCHLOCK_MECHANISM = registerItem("matchlock_mechanism", new Item(new Item.Settings()));
    public static final Item GUN_STOCK = registerItem("gun_stock", new Item(new Item.Settings()));
    public static final Item SMALL_STICK = registerItem("small_stick", new Item(new Item.Settings()));
    public static final Item BULLET = registerItem("bullet", new BulletItem(new Item.Settings()));

    public static final Dictionary<String, Item> MATERIAL_ITEMS = new Hashtable<>();

    static
    {
        MATERIAL_ITEMS.put("iron", Items.IRON_INGOT);
        MATERIAL_ITEMS.put("diamond", Items.DIAMOND);
        MATERIAL_ITEMS.put("gold", Items.GOLD_INGOT);
        MATERIAL_ITEMS.put("netherite", Items.NETHERITE_INGOT);

        for(String name : WeaponSetsHelper.MATERIALS)
        {
            STABBING_TIPS.put(name, registerItem(name+"_stabbing_tip", new Item(new Item.Settings())));
            MACE_TIPS.put(name, registerItem(name+"_mace_tip", new Item(new Item.Settings())));
            AXE_TIPS.put(name, registerItem(name+"_axe_tip", new Item(new Item.Settings())));
            DOUBLEEDGE_BLADES.put(name, registerItem(name+"_doubleedge_blade", new Item(new Item.Settings())));
            SINGLEEDGE_BLADES.put(name, registerItem(name+"_singleedge_blade", new Item(new Item.Settings())));
            CURVED_BLADES.put(name, registerItem(name+"_curved_blade", new Item(new Item.Settings())));

            HALBERDS.put(name, registerItem(name+"_halberd", new SwordItem(TOOL_MATERIALS.get(name), new Item.Settings().maxCount(1)
                    .attributeModifiers(WeaponHelper.createAttributes(TOOL_MATERIALS.get(name), 4, -3.0D)))));
            RAPIERS.put(name, registerItem(name+"_rapier", new SwordItem(TOOL_MATERIALS.get(name), new Item.Settings().maxCount(1)
                    .attributeModifiers(WeaponHelper.createAttributes(TOOL_MATERIALS.get(name), 2, -2.0D)))));
            CLAYMORES.put(name, registerItem(name+"_claymore", new SwordItem(TOOL_MATERIALS.get(name), new Item.Settings().maxCount(1)
                    .attributeModifiers(WeaponHelper.createAttributes(TOOL_MATERIALS.get(name), 5, -3.0D)))));
            BATTLE_AXES.put(name, registerItem(name+"_battle_axe", new AxeItem(TOOL_MATERIALS.get(name), new Item.Settings().maxCount(1)
                    .attributeModifiers(WeaponHelper.createAttributes(TOOL_MATERIALS.get(name), 6, -3.1D)))));
            SAI.put(name, registerItem(name+"_sai", new SwordItem(TOOL_MATERIALS.get(name), new Item.Settings().maxCount(1)
                    .attributeModifiers(WeaponHelper.createAttributes(TOOL_MATERIALS.get(name), 1, -1.5D)))));
            MACES.put(name, registerItem(name+"_mace", new SwordItem(TOOL_MATERIALS.get(name), new Item.Settings().maxCount(1)
                    .attributeModifiers(WeaponHelper.createAttributes(TOOL_MATERIALS.get(name), 6, -3.5D)))));

            DAGGERS.put(name, registerItem(name+"_dagger", new SwordItem(TOOL_MATERIALS.get(name), new Item.Settings().maxCount(1)
                    .attributeModifiers(WeaponHelper.createAttributes(TOOL_MATERIALS.get(name), 1.5D, -1.75D)))));
            GLAIVES.put(name, registerItem(name+"_glaive", new SwordItem(TOOL_MATERIALS.get(name), new Item.Settings().maxCount(1)
                    .attributeModifiers(WeaponHelper.createAttributes(TOOL_MATERIALS.get(name), 3.5D, -2.5D)))));
            KATANAS.put(name, registerItem(name+"_katana", new SwordItem(TOOL_MATERIALS.get(name), new Item.Settings().maxCount(1)
                    .attributeModifiers(WeaponHelper.createAttributes(TOOL_MATERIALS.get(name), 4.75D, -2.25D)))));
            BATTLE_STAVES.put(name, registerItem(name+"_battle_staff", new SwordItem(TOOL_MATERIALS.get(name), new Item.Settings().maxCount(1)
                    .attributeModifiers(WeaponHelper.createAttributes(TOOL_MATERIALS.get(name), 4.5D, -2.7D)))));
            SCYTHES.put(name, registerItem(name+"_scythe", new SwordItem(TOOL_MATERIALS.get(name), new Item.Settings().maxCount(1)
                    .attributeModifiers(WeaponHelper.createAttributes(TOOL_MATERIALS.get(name), 4D, -2.6D)))));
            ODACHIS.put(name, registerItem(name+"_odachi", new SwordItem(TOOL_MATERIALS.get(name), new Item.Settings().maxCount(1)
                    .attributeModifiers(WeaponHelper.createAttributes(TOOL_MATERIALS.get(name), 5.75D, -3.25D)))));

            DANE_AXES.put(name, registerItem(name+"_dane_axe", new AxeItem(TOOL_MATERIALS.get(name), new Item.Settings().maxCount(1)
                    .attributeModifiers(WeaponHelper.createAttributes(TOOL_MATERIALS.get(name), 7, -3.2D)))));

            BEARDED_AXES.put(name, registerItem(name+"_bearded_axe", new AxeItem(TOOL_MATERIALS.get(name), new Item.Settings().maxCount(1)
                    .attributeModifiers(WeaponHelper.createAttributes(TOOL_MATERIALS.get(name), 5, -2.8D)))));

            KATARS.put(name, registerItem(name+"_katar", new SwordItem(TOOL_MATERIALS.get(name), new Item.Settings().maxCount(1)
                    .attributeModifiers(WeaponHelper.createAttributes(TOOL_MATERIALS.get(name), 2D, -2D)))));
        }
    }

    public static final Item ARQUEBUS = registerFirearm("arquebus", new ArquebusItem(new Item.Settings().maxCount(1),new FirearmConfig.Builder()
            .useAction(UseAction.BOW)
            .maxUseTime(72000)
            .minUseTicks(5)
            .reloadTicks(40)
            .ammoPerShot(1)
            .projectilesPerShot(1)
            .damage(6.0)
            .velocity(3.0f)
            .inaccuracy(1.0f)
            .spreadAngle(5f)
            .recoilStrength(0.2)
            .recoilVertical(0.1)
            .misfireChance(0.05f)
            .shootSound(ModSounds.ARQUEBUS_SHOT)
            .misfireSound(ModSounds.MISFIRE)
            .reloadSound(ModSounds.ARQUEBUS_RELOAD)
            .soundVolume(1f)
            .soundPitch(1f)
            .reloadVolume(1f)
            .reloadPitch(1f)
            .reloadParticle(ParticleTypes.SMOKE)
            .reloadParticleCount(5)
            .smokeParticle(ParticleTypes.SMOKE)
            .smokeCount(3)
            .smokeSpread(0.1)
            .smokeSpeed(0.02)
            .flameParticle(ParticleTypes.FLAME)
            .flameCount(2)
            .build()
    ));

    public static final Item BLUNDERBUSS = registerItem("blunderbuss", new BlunderbussItem(new Item.Settings().maxCount(1),new FirearmConfig.Builder()
            .useAction(UseAction.BOW)
            .maxUseTime(72000)
            .minUseTicks(7)
            .reloadTicks(50)
            .ammoPerShot(1)
            .projectilesPerShot(5)
            .damage(4.0)
            .velocity(2.5f)
            .inaccuracy(2.0f)
            .spreadAngle(15f)
            .recoilStrength(0.4)
            .recoilVertical(0.15)
            .misfireChance(0.1f)
            .shootSound(ModSounds.BLUNDERBUSS_SHOT)
            .misfireSound(ModSounds.MISFIRE)
            .reloadSound(ModSounds.BLUNDERBUSS_RELOAD)
            .soundVolume(1f)
            .soundPitch(1f)
            .reloadVolume(1f)
            .reloadPitch(1f)
            .reloadParticle(ParticleTypes.SMOKE)
            .reloadParticleCount(7)
            .smokeParticle(ParticleTypes.SMOKE)
            .smokeCount(5)
            .smokeSpread(0.2)
            .smokeSpeed(0.03)
            .flameParticle(ParticleTypes.FLAME)
            .flameCount(3)
            .build()
    ));

    public static final Item MATCHLOCK_PISTOL = registerItem("matchlock_pistol", new MatchlockPistolItem(new Item.Settings().maxCount(1), new FirearmConfig.Builder()
            .useAction(UseAction.BOW)
            .maxUseTime(72000)
            .minUseTicks(6)
            .reloadTicks(45)
            .ammoPerShot(1)
            .projectilesPerShot(1)
            .damage(5.0)
            .velocity(3.2f)
            .inaccuracy(1.5f)
            .spreadAngle(7f)
            .recoilStrength(0.25)
            .recoilVertical(0.12)
            .misfireChance(0.08f)
            .shootSound(ModSounds.MATCHLOCK_PISTOL_SHOT)
            .misfireSound(ModSounds.MISFIRE)
            .reloadSound(ModSounds.MATCHLOCK_PISTOL_RELOAD)
            .soundVolume(1f)
            .soundPitch(1f)
            .reloadVolume(1f)
            .reloadPitch(1f)
            .reloadParticle(ParticleTypes.SMOKE)
            .reloadParticleCount(6)
            .smokeParticle(ParticleTypes.SMOKE)
            .smokeCount(4)
            .smokeSpread(0.15)
            .smokeSpeed(0.025)
            .flameParticle(ParticleTypes.FLAME)
            .flameCount(2)
            .build())
    );

    private static Item registerFirearm(String name, Item firearmItem)
    {
        return Registry.register(Registries.ITEM, Identifier.of(AlmirisWeapons.MOD_ID, name), firearmItem);
    }

    private static Item registerItem(String name, Item item)
    {
        return Registry.register(Registries.ITEM, Identifier.of(AlmirisWeapons.MOD_ID, name), item);
    }

    public static void registerItems()
    {

    }
}
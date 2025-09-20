package net.alminoris.almirisweapons.sound;

import net.alminoris.almirisweapons.AlmirisWeapons;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class ModSounds {
    public static final SoundEvent ARQUEBUS_SHOT = registerSound("arquebus_shot");
    public static final SoundEvent BLUNDERBUSS_SHOT = registerSound("blunderbuss_shot");
    public static final SoundEvent MATCHLOCK_PISTOL_SHOT = registerSound("matchlock_pistol_shot");
    public static final SoundEvent MISFIRE = registerSound("misfire");
    public static final SoundEvent ARQUEBUS_RELOAD = registerSound("arquebus_reload");
    public static final SoundEvent BLUNDERBUSS_RELOAD = registerSound("blunderbuss_reload");
    public static final SoundEvent MATCHLOCK_PISTOL_RELOAD = registerSound("matchlock_pistol_reload");

    private static SoundEvent registerSound(String name) {
        Identifier id = Identifier.of(AlmirisWeapons.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }

    public static void registerSounds() {

    }
}

package net.alminoris.almirisweapons.sound;

import net.alminoris.almirisweapons.AlmirisWeapons;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModSounds {
    public static final SoundEvent ARQUEBUS_SHOT = registerSound("arquebus_shot");
    public static final SoundEvent BLUNDERBUSS_SHOT = registerSound("blunderbuss_shot");
    public static final SoundEvent MATCHLOCK_PISTOL_SHOT = registerSound("matchlock_pistol_shot");
    public static final SoundEvent MISFIRE = registerSound("misfire");
    public static final SoundEvent ARQUEBUS_RELOAD = registerSound("arquebus_reload");
    public static final SoundEvent BLUNDERBUSS_RELOAD = registerSound("blunderbuss_reload");
    public static final SoundEvent MATCHLOCK_PISTOL_RELOAD = registerSound("matchlock_pistol_reload");
    public static final SoundEvent EMPTY = registerSound("empty");

    private static SoundEvent registerSound(String name) {
        Identifier id = new Identifier(AlmirisWeapons.MOD_ID, name);
        return Registry.register(Registry.SOUND_EVENT, id, new SoundEvent(id));
    }

    public static void registerSounds() {

    }
}
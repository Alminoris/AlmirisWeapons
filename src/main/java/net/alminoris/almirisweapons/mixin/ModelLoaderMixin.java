package net.alminoris.almirisweapons.mixin;

import net.alminoris.almirisweapons.AlmirisWeapons;
import net.minecraft.client.color.block.BlockColors;
import net.minecraft.client.render.model.ModelLoader;
import net.minecraft.client.render.model.json.JsonUnbakedModel;
import net.minecraft.client.util.ModelIdentifier;
import net.minecraft.util.Identifier;
import net.minecraft.util.profiler.Profiler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;
import java.util.Map;

import static net.alminoris.almirisweapons.util.helper.WeaponSetsHelper.MATERIALS;


@Mixin(ModelLoader.class)
public abstract class ModelLoaderMixin
{
    @Shadow
    protected abstract void addModel(ModelIdentifier id);

    @Inject(method = "<init>", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/render/model/ModelLoader;addModel(Lnet/minecraft/client/util/ModelIdentifier;)V", ordinal = 3, shift = At.Shift.AFTER))
    public void addClaymore(BlockColors blockColors, Profiler profiler, Map<Identifier, JsonUnbakedModel> jsonUnbakedModels, Map<Identifier, List<ModelLoader.SourceTrackedData>> blockStates, CallbackInfo ci)
    {
        for(String name : MATERIALS)
        {
            ModelIdentifier id = new ModelIdentifier(Identifier.of(AlmirisWeapons.MOD_ID, name+"_claymore_3d"), "inventory");
            this.addModel(id);
        }
    }

    @Inject(method = "<init>", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/render/model/ModelLoader;addModel(Lnet/minecraft/client/util/ModelIdentifier;)V", ordinal = 3, shift = At.Shift.AFTER))
    public void addHalberd(BlockColors blockColors, Profiler profiler, Map<Identifier, JsonUnbakedModel> jsonUnbakedModels, Map<Identifier, List<ModelLoader.SourceTrackedData>> blockStates, CallbackInfo ci)
    {
        for(String name : MATERIALS)
        {
            ModelIdentifier id = new ModelIdentifier(Identifier.of(AlmirisWeapons.MOD_ID, name+"_halberd_3d"), "inventory");
            this.addModel(id);
        }
    }

    @Inject(method = "<init>", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/render/model/ModelLoader;addModel(Lnet/minecraft/client/util/ModelIdentifier;)V", ordinal = 1, shift = At.Shift.AFTER))
    public void addGlaive(BlockColors blockColors, Profiler profiler, Map<Identifier, JsonUnbakedModel> jsonUnbakedModels, Map<Identifier, List<ModelLoader.SourceTrackedData>> blockStates, CallbackInfo ci)
    {
        for(String name : MATERIALS)
        {
            ModelIdentifier id = new ModelIdentifier(Identifier.of(AlmirisWeapons.MOD_ID, name+"_glaive_3d"), "inventory");
            this.addModel(id);
        }
    }

    @Inject(method = "<init>", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/render/model/ModelLoader;addModel(Lnet/minecraft/client/util/ModelIdentifier;)V", ordinal = 1, shift = At.Shift.AFTER))
    public void addBattleStaff(BlockColors blockColors, Profiler profiler, Map<Identifier, JsonUnbakedModel> jsonUnbakedModels, Map<Identifier, List<ModelLoader.SourceTrackedData>> blockStates, CallbackInfo ci)
    {
        for(String name : MATERIALS)
        {
            ModelIdentifier id = new ModelIdentifier(Identifier.of(AlmirisWeapons.MOD_ID, name+"_battle_staff_3d"), "inventory");
            this.addModel(id);
        }
    }

    @Inject(method = "<init>", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/render/model/ModelLoader;addModel(Lnet/minecraft/client/util/ModelIdentifier;)V", ordinal = 1, shift = At.Shift.AFTER))
    public void addScythe(BlockColors blockColors, Profiler profiler, Map<Identifier, JsonUnbakedModel> jsonUnbakedModels, Map<Identifier, List<ModelLoader.SourceTrackedData>> blockStates, CallbackInfo ci)
    {
        for(String name : MATERIALS)
        {
            ModelIdentifier id = new ModelIdentifier(Identifier.of(AlmirisWeapons.MOD_ID, name+"_scythe_3d"), "inventory");
            this.addModel(id);
        }
    }

    @Inject(method = "<init>", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/render/model/ModelLoader;addModel(Lnet/minecraft/client/util/ModelIdentifier;)V", ordinal = 1, shift = At.Shift.AFTER))
    public void addKatana(BlockColors blockColors, Profiler profiler, Map<Identifier, JsonUnbakedModel> jsonUnbakedModels, Map<Identifier, List<ModelLoader.SourceTrackedData>> blockStates, CallbackInfo ci)
    {
        for(String name : MATERIALS)
        {
            ModelIdentifier id = new ModelIdentifier(Identifier.of(AlmirisWeapons.MOD_ID, name+"_katana_3d"), "inventory");
            this.addModel(id);
        }
    }

    @Inject(method = "<init>", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/render/model/ModelLoader;addModel(Lnet/minecraft/client/util/ModelIdentifier;)V", ordinal = 1, shift = At.Shift.AFTER))
    public void addOdachi(BlockColors blockColors, Profiler profiler, Map<Identifier, JsonUnbakedModel> jsonUnbakedModels, Map<Identifier, List<ModelLoader.SourceTrackedData>> blockStates, CallbackInfo ci)
    {
        for(String name : MATERIALS)
        {
            ModelIdentifier id = new ModelIdentifier(Identifier.of(AlmirisWeapons.MOD_ID, name+"_odachi_3d"), "inventory");
            this.addModel(id);
        }
    }

    @Inject(method = "<init>", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/render/model/ModelLoader;addModel(Lnet/minecraft/client/util/ModelIdentifier;)V", ordinal = 1, shift = At.Shift.AFTER))
    public void addDaneAxe(BlockColors blockColors, Profiler profiler, Map<Identifier, JsonUnbakedModel> jsonUnbakedModels, Map<Identifier, List<ModelLoader.SourceTrackedData>> blockStates, CallbackInfo ci)
    {
        for(String name : MATERIALS)
        {
            ModelIdentifier id = new ModelIdentifier(Identifier.of(AlmirisWeapons.MOD_ID, name+"_dane_axe_3d"), "inventory");
            this.addModel(id);
        }
    }

    @Inject(method = "<init>", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/render/model/ModelLoader;addModel(Lnet/minecraft/client/util/ModelIdentifier;)V", ordinal = 1, shift = At.Shift.AFTER))
    public void addKatar(BlockColors blockColors, Profiler profiler, Map<Identifier, JsonUnbakedModel> jsonUnbakedModels, Map<Identifier, List<ModelLoader.SourceTrackedData>> blockStates, CallbackInfo ci)
    {
        for(String name : MATERIALS)
        {
            ModelIdentifier id = new ModelIdentifier(Identifier.of(AlmirisWeapons.MOD_ID, name+"_katar_3d"), "inventory");
            this.addModel(id);
        }
    }

    @Inject(method = "<init>", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/render/model/ModelLoader;addModel(Lnet/minecraft/client/util/ModelIdentifier;)V", ordinal = 1, shift = At.Shift.AFTER))
    public void addArquebus(BlockColors blockColors, Profiler profiler, Map<Identifier, JsonUnbakedModel> jsonUnbakedModels, Map<Identifier, List<ModelLoader.SourceTrackedData>> blockStates, CallbackInfo ci)
    {
        ModelIdentifier id = new ModelIdentifier(Identifier.of(AlmirisWeapons.MOD_ID, "arquebus_3d"), "inventory");
        this.addModel(id);
    }

    @Inject(method = "<init>", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/render/model/ModelLoader;addModel(Lnet/minecraft/client/util/ModelIdentifier;)V", ordinal = 1, shift = At.Shift.AFTER))
    public void addBlunderbuss(BlockColors blockColors, Profiler profiler, Map<Identifier, JsonUnbakedModel> jsonUnbakedModels, Map<Identifier, List<ModelLoader.SourceTrackedData>> blockStates, CallbackInfo ci)
    {
        ModelIdentifier id = new ModelIdentifier(Identifier.of(AlmirisWeapons.MOD_ID, "blunderbuss_3d"), "inventory");
        this.addModel(id);
    }

    @Inject(method = "<init>", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/render/model/ModelLoader;addModel(Lnet/minecraft/client/util/ModelIdentifier;)V", ordinal = 1, shift = At.Shift.AFTER))
    public void addMatchlockPistol(BlockColors blockColors, Profiler profiler, Map<Identifier, JsonUnbakedModel> jsonUnbakedModels, Map<Identifier, List<ModelLoader.SourceTrackedData>> blockStates, CallbackInfo ci)
    {
        ModelIdentifier id = new ModelIdentifier(Identifier.of(AlmirisWeapons.MOD_ID, "matchlock_pistol_3d"), "inventory");
        this.addModel(id);
    }
}
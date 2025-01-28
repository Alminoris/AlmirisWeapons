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
    protected abstract void loadItemModel(ModelIdentifier id);

    @Inject(method = "<init>", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/render/model/ModelLoader;loadItemModel(Lnet/minecraft/client/util/ModelIdentifier;)V", ordinal = 1, shift = At.Shift.AFTER))
    public void addClaymore(BlockColors blockColors, Profiler profiler, Map<Identifier, JsonUnbakedModel> jsonUnbakedModels, Map<Identifier, List<ModelLoader.SpriteGetter>> blockStates, CallbackInfo ci)
    {
        for(String name : MATERIALS)
        {
            ModelIdentifier id = new ModelIdentifier(Identifier.of(AlmirisWeapons.MOD_ID, name+"_claymore_3d"), "inventory");
            this.loadItemModel(id);
        }
    }

    @Inject(method = "<init>", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/render/model/ModelLoader;loadItemModel(Lnet/minecraft/client/util/ModelIdentifier;)V", ordinal = 1, shift = At.Shift.AFTER))
    public void addHalberd(BlockColors blockColors, Profiler profiler, Map<Identifier, JsonUnbakedModel> jsonUnbakedModels, Map<Identifier, List<ModelLoader.SpriteGetter>> blockStates, CallbackInfo ci)
    {
        for(String name : MATERIALS)
        {
            ModelIdentifier id = new ModelIdentifier(Identifier.of(AlmirisWeapons.MOD_ID, name+"_halberd_3d"), "inventory");
            this.loadItemModel(id);
        }
    }
}

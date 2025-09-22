package net.alminoris.almirisweapons.mixin;

import net.alminoris.almirisweapons.AlmirisWeapons;
import net.alminoris.almirisweapons.item.ModItems;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.render.model.json.ModelTransformation;
import net.minecraft.client.render.model.json.ModelTransformation.Mode;
import net.minecraft.client.util.ModelIdentifier;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

import static net.alminoris.almirisweapons.item.ModItems.*;
import static net.alminoris.almirisweapons.util.helper.WeaponSetsHelper.MATERIALS;

@Mixin(ItemRenderer.class)
public abstract class ItemRendererMixin
{
    @ModifyVariable(method = "renderItem", at = @At(value = "HEAD"), argsOnly = true)
    public BakedModel useClaymoreModel(BakedModel value, ItemStack stack, ModelTransformation.Mode renderMode, boolean leftHanded, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay)
    {
        for(String name : MATERIALS)
        {
            if (stack.isOf(CLAYMORES.get(name)) && renderMode != ModelTransformation.Mode.GUI)
            {
                return ((ItemRendererAccessor) this).mccourse$getModels().getModelManager().getModel(new ModelIdentifier(new Identifier(AlmirisWeapons.MOD_ID, name+"_claymore_3d"), "inventory"));
            }
        }

        return value;
    }

    @ModifyVariable(method = "renderItem", at = @At(value = "HEAD"), argsOnly = true)
    public BakedModel useHalberdModel(BakedModel value, ItemStack stack, ModelTransformation.Mode renderMode, boolean leftHanded, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay)
    {
        for(String name : MATERIALS)
        {
            if (stack.isOf(HALBERDS.get(name)) && renderMode != ModelTransformation.Mode.GUI)
            {
                return ((ItemRendererAccessor) this).mccourse$getModels().getModelManager().getModel(new ModelIdentifier(new Identifier(AlmirisWeapons.MOD_ID, name+"_halberd_3d"), "inventory"));
            }
        }

        return value;
    }

    @ModifyVariable(method = "renderItem", at = @At(value = "HEAD"), argsOnly = true)
    public BakedModel useGlaiveModel(BakedModel value, ItemStack stack, ModelTransformation.Mode renderMode, boolean leftHanded, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay)
    {
        for(String name : MATERIALS)
        {
            if (stack.isOf(GLAIVES.get(name)) && renderMode != ModelTransformation.Mode.GUI)
            {
                return ((ItemRendererAccessor) this).mccourse$getModels().getModelManager().getModel(new ModelIdentifier(new Identifier(AlmirisWeapons.MOD_ID, name+"_glaive_3d"), "inventory"));
            }
        }

        return value;
    }

    @ModifyVariable(method = "renderItem", at = @At(value = "HEAD"), argsOnly = true)
    public BakedModel useBattleStaffModel(BakedModel value, ItemStack stack, ModelTransformation.Mode renderMode, boolean leftHanded, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay)
    {
        for(String name : MATERIALS)
        {
            if (stack.isOf(BATTLE_STAVES.get(name)) && renderMode != ModelTransformation.Mode.GUI)
            {
                return ((ItemRendererAccessor) this).mccourse$getModels().getModelManager().getModel(new ModelIdentifier(new Identifier(AlmirisWeapons.MOD_ID, name+"_battle_staff_3d"), "inventory"));
            }
        }

        return value;
    }

    @ModifyVariable(method = "renderItem", at = @At(value = "HEAD"), argsOnly = true)
    public BakedModel useScytheModel(BakedModel value, ItemStack stack, ModelTransformation.Mode renderMode, boolean leftHanded, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay)
    {
        for(String name : MATERIALS)
        {
            if (stack.isOf(SCYTHES.get(name)) && renderMode != ModelTransformation.Mode.GUI)
            {
                return ((ItemRendererAccessor) this).mccourse$getModels().getModelManager().getModel(new ModelIdentifier(new Identifier(AlmirisWeapons.MOD_ID, name+"_scythe_3d"), "inventory"));
            }
        }

        return value;
    }

    @ModifyVariable(method = "renderItem", at = @At(value = "HEAD"), argsOnly = true)
    public BakedModel useKatanaModel(BakedModel value, ItemStack stack, ModelTransformation.Mode renderMode, boolean leftHanded, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay)
    {
        for(String name : MATERIALS)
        {
            if (stack.isOf(KATANAS.get(name)) && renderMode != ModelTransformation.Mode.GUI)
            {
                return ((ItemRendererAccessor) this).mccourse$getModels().getModelManager().getModel(new ModelIdentifier(new Identifier(AlmirisWeapons.MOD_ID, name+"_katana_3d"), "inventory"));
            }
        }

        return value;
    }

    @ModifyVariable(method = "renderItem", at = @At(value = "HEAD"), argsOnly = true)
    public BakedModel useOdachiModel(BakedModel value, ItemStack stack, ModelTransformation.Mode renderMode, boolean leftHanded, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay)
    {
        for(String name : MATERIALS)
        {
            if (stack.isOf(ODACHIS.get(name)) && renderMode != ModelTransformation.Mode.GUI)
            {
                return ((ItemRendererAccessor) this).mccourse$getModels().getModelManager().getModel(new ModelIdentifier(new Identifier(AlmirisWeapons.MOD_ID, name+"_odachi_3d"), "inventory"));
            }
        }

        return value;
    }

    @ModifyVariable(method = "renderItem", at = @At(value = "HEAD"), argsOnly = true)
    public BakedModel useDaneAxeModel(BakedModel value, ItemStack stack, ModelTransformation.Mode renderMode, boolean leftHanded, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay)
    {
        for(String name : MATERIALS)
        {
            if (stack.isOf(DANE_AXES.get(name)) && renderMode != ModelTransformation.Mode.GUI)
            {
                return ((ItemRendererAccessor) this).mccourse$getModels().getModelManager().getModel(new ModelIdentifier(new Identifier(AlmirisWeapons.MOD_ID, name+"_dane_axe_3d"), "inventory"));
            }
        }

        return value;
    }

    @ModifyVariable(method = "renderItem", at = @At(value = "HEAD"), argsOnly = true)
    public BakedModel useKatarModel(BakedModel value, ItemStack stack, ModelTransformation.Mode renderMode, boolean leftHanded, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay)
    {
        for(String name : MATERIALS)
        {
            if (stack.isOf(KATARS.get(name)) && renderMode != ModelTransformation.Mode.GUI)
            {
                return ((ItemRendererAccessor) this).mccourse$getModels().getModelManager().getModel(new ModelIdentifier(new Identifier(AlmirisWeapons.MOD_ID, name+"_katar_3d"), "inventory"));
            }
        }

        return value;
    }

    @ModifyVariable(method = "renderItem", at = @At(value = "HEAD"), argsOnly = true)
    public BakedModel useArquebusModel(BakedModel value, ItemStack stack, ModelTransformation.Mode renderMode, boolean leftHanded, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay)
    {
        if (stack.isOf(ARQUEBUS) && renderMode != ModelTransformation.Mode.GUI)
        {
            return ((ItemRendererAccessor) this).mccourse$getModels().getModelManager().getModel(new ModelIdentifier(new Identifier(AlmirisWeapons.MOD_ID, "arquebus_3d"), "inventory"));
        }

        return value;
    }

    @ModifyVariable(method = "renderItem", at = @At(value = "HEAD"), argsOnly = true)
    public BakedModel useBlunderbussModel(BakedModel value, ItemStack stack, ModelTransformation.Mode renderMode, boolean leftHanded, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay)
    {
        if (stack.isOf(BLUNDERBUSS) && renderMode != ModelTransformation.Mode.GUI)
        {
            return ((ItemRendererAccessor) this).mccourse$getModels().getModelManager().getModel(new ModelIdentifier(new Identifier(AlmirisWeapons.MOD_ID, "blunderbuss_3d"), "inventory"));
        }

        return value;
    }

    @ModifyVariable(method = "renderItem", at = @At(value = "HEAD"), argsOnly = true)
    public BakedModel useMatchlockPistolModel(BakedModel value, ItemStack stack, ModelTransformation.Mode renderMode, boolean leftHanded, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay)
    {
        if (stack.isOf(MATCHLOCK_PISTOL) && renderMode != ModelTransformation.Mode.GUI)
        {
            return ((ItemRendererAccessor) this).mccourse$getModels().getModelManager().getModel(new ModelIdentifier(new Identifier(AlmirisWeapons.MOD_ID, "matchlock_pistol_3d"), "inventory"));
        }

        return value;
    }
}
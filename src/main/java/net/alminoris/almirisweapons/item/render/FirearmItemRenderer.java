package net.alminoris.almirisweapons.item.render;

import net.alminoris.almirisweapons.item.custom.AbstractFirearmItem;
import net.fabricmc.fabric.api.client.rendering.v1.BuiltinItemRenderer;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.model.json.ModelTransformation;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.math.Vec3f;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

public class FirearmItemRenderer implements BuiltinItemRenderer
{

    private static final Map<UUID, Map<Hand, Float>> recoilMap = new HashMap<>();
    private static final Map<UUID, Map<Hand, Integer>> reloadMap = new HashMap<>();
    private static final Random random = new Random();

    public static void triggerRecoil(UUID player, Hand hand, double strength)
    {
        recoilMap.computeIfAbsent(player, k -> new HashMap<>()).put(hand, (float) strength);
    }

    public static void startReload(UUID player, Hand hand, int ticks)
    {
        reloadMap.computeIfAbsent(player, k -> new HashMap<>()).put(hand, ticks);
    }

    @Override
    public void render(ItemStack stack, MatrixStack matrices,
                       VertexConsumerProvider vertexConsumers, int light, int overlay)
    {
        MinecraftClient client = MinecraftClient.getInstance();
        if (client.player == null) return;

        UUID playerId = client.player.getUuid();
        Hand hand = client.player.getMainHandStack() == stack ? Hand.MAIN_HAND : Hand.OFF_HAND;

        float recoilOffset = recoilMap.getOrDefault(playerId, Map.of()).getOrDefault(hand, 0f);
        int reloadTicks = reloadMap.getOrDefault(playerId, Map.of()).getOrDefault(hand, 0);
        int maxReloadTicks = reloadTicks;

        if (recoilOffset > 0)
        {
            if (stack.getItem() instanceof AbstractFirearmItem firearm)
            {
                String id = firearm.getTranslationKey();

                if (id.contains("arquebus"))
                {
                    matrices.translate(0, 0, -recoilOffset * 1.2f);
                    matrices.multiply(Vec3f.POSITIVE_X.getDegreesQuaternion(-recoilOffset * 15f));
                }
                else if (id.contains("blunderbuss"))
                {
                    matrices.translate((random.nextFloat() - 0.5f) * 0.05f, 0, -recoilOffset * 1.5f);
                    matrices.multiply(Vec3f.POSITIVE_X.getDegreesQuaternion(-recoilOffset * 20f));
                }
                else if (id.contains("pistol"))
                {
                    matrices.translate(0, 0, -recoilOffset * 0.6f);
                    matrices.multiply(Vec3f.POSITIVE_X.getDegreesQuaternion(-recoilOffset * 5f));
                }
            }

            recoilOffset *= 0.75f;
            if (recoilOffset < 0.01f) recoilOffset = 0f;
            recoilMap.computeIfAbsent(playerId, k -> new HashMap<>()).put(hand, recoilOffset);
        }

        if (reloadTicks > 0)
        {
            float progress = 1.0f - (reloadTicks / (float) maxReloadTicks);
            matrices.translate(0, progress * -0.4f, progress * 0.2f);
            matrices.multiply(Vec3f.POSITIVE_X.getDegreesQuaternion(progress * 25.0f));
            reloadTicks--;
            reloadMap.computeIfAbsent(playerId, k -> new HashMap<>()).put(hand, reloadTicks);
        }

        ModelTransformation.Mode mode = client.options.getPerspective().isFirstPerson()
                ? ModelTransformation.Mode.FIRST_PERSON_RIGHT_HAND
                : ModelTransformation.Mode.THIRD_PERSON_RIGHT_HAND;

        client.getItemRenderer().renderItem(stack, mode, light, overlay, matrices, vertexConsumers, 0);
    }
}
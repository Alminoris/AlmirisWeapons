package net.alminoris.almirisweapons.datagen;

import net.alminoris.almirisweapons.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.registry.tag.TagKey;

import java.util.concurrent.CompletableFuture;

import static net.alminoris.almirisweapons.util.helper.WeaponSetsHelper.MATERIALS;

public class ModRecipeProvider extends FabricRecipeProvider
{
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture)
    {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter recipeExporter)
    {
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.BATTLE_STAVES.get("wood"), 1)
                .pattern("  #")
                .pattern(" / ")
                .pattern("#  ")
                .input('#', ItemTags.PLANKS)
                .input('/', Items.STICK)
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.BATTLE_STAVES.get("stone"), 1)
                .pattern("  #")
                .pattern(" / ")
                .pattern("#  ")
                .input('#', ItemTags.STONE_TOOL_MATERIALS)
                .input('/', Items.STICK)
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.BATTLE_STAVES.get("iron"), 1)
                .pattern("  #")
                .pattern(" / ")
                .pattern("#  ")
                .input('#', Items.IRON_INGOT)
                .input('/', Items.STICK)
                .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.BATTLE_STAVES.get("gold"), 1)
                .pattern("  #")
                .pattern(" / ")
                .pattern("#  ")
                .input('#', Items.GOLD_INGOT)
                .input('/', Items.STICK)
                .criterion(hasItem(Items.GOLD_INGOT), conditionsFromItem(Items.GOLD_INGOT))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.BATTLE_STAVES.get("diamond"), 1)
                .pattern("  #")
                .pattern(" / ")
                .pattern("#  ")
                .input('#', Items.DIAMOND)
                .input('/', Items.STICK)
                .criterion(hasItem(Items.DIAMOND), conditionsFromItem(Items.DIAMOND))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.BATTLE_STAVES.get("netherite"), 1)
                .pattern("  #")
                .pattern(" / ")
                .pattern("#  ")
                .input('#', Items.NETHERITE_INGOT)
                .input('/', Items.STICK)
                .criterion(hasItem(Items.NETHERITE_INGOT), conditionsFromItem(Items.NETHERITE_INGOT))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(recipeExporter);

        offerShapelessRecipe(recipeExporter, ModItems.SMALL_STICK, Items.STICK, "small_stick", 2);

        Item woodStabbingTip = ModItems.STABBING_TIPS.get("wood");
        if (woodStabbingTip == null) {
            throw new IllegalStateException("wood_stabbing_tip is not registered properly!");
        }

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.STABBING_TIPS.get("wood"), 3)
                .pattern("/")
                .pattern("/")
                .pattern("/")
                .input('/', ItemTags.PLANKS)
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.AXE_TIPS.get("wood"), 3)
                .pattern("/  ")
                .pattern("///")
                .pattern("/  ")
                .input('/', ItemTags.PLANKS)
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.MACE_TIPS.get("wood"), 3)
                .pattern(" / ")
                .pattern("///")
                .pattern(" / ")
                .input('/', ItemTags.PLANKS)
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.SINGLEEDGE_BLADES.get("wood"), 3)
                .pattern("  /")
                .pattern(" / ")
                .pattern("/  ")
                .input('/', ItemTags.PLANKS)
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.CURVED_BLADES.get("wood"), 3)
                .pattern(" /")
                .pattern("/ ")
                .pattern(" /")
                .input('/', ItemTags.PLANKS)
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.STABBING_TIPS.get("stone"), 3)
                .pattern("/")
                .pattern("/")
                .pattern("/")
                .input('/', ItemTags.STONE_TOOL_MATERIALS)
                .criterion(hasItem(Items.COBBLESTONE), conditionsFromItem(Items.COBBLESTONE))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.AXE_TIPS.get("stone"), 3)
                .pattern("/  ")
                .pattern("///")
                .pattern("/  ")
                .input('/', ItemTags.STONE_TOOL_MATERIALS)
                .criterion(hasItem(Items.COBBLESTONE), conditionsFromItem(Items.COBBLESTONE))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.MACE_TIPS.get("stone"), 3)
                .pattern(" / ")
                .pattern("///")
                .pattern(" / ")
                .input('/', ItemTags.STONE_TOOL_MATERIALS)
                .criterion(hasItem(Items.COBBLESTONE), conditionsFromItem(Items.COBBLESTONE))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.SINGLEEDGE_BLADES.get("stone"), 3)
                .pattern("  /")
                .pattern(" / ")
                .pattern("/  ")
                .input('/', ItemTags.STONE_TOOL_MATERIALS)
                .criterion(hasItem(Items.COBBLESTONE), conditionsFromItem(Items.COBBLESTONE))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.CURVED_BLADES.get("stone"), 3)
                .pattern(" /")
                .pattern("/ ")
                .pattern(" /")
                .input('/', ItemTags.STONE_TOOL_MATERIALS)
                .criterion(hasItem(Items.COBBLESTONE), conditionsFromItem(Items.COBBLESTONE))
                .offerTo(recipeExporter);

        for (String name : MATERIALS)
        {
            if (!name.equals("wood") && !name.equals("stone"))
            {
                ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.STABBING_TIPS.get(name), 3)
                        .pattern("/")
                        .pattern("/")
                        .pattern("/")
                        .input('/', ModItems.MATERIAL_ITEMS.get(name))
                        .criterion(hasItem(ModItems.MATERIAL_ITEMS.get(name)), conditionsFromItem(ModItems.MATERIAL_ITEMS.get(name)))
                        .offerTo(recipeExporter);

                ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.AXE_TIPS.get(name), 3)
                        .pattern("/  ")
                        .pattern("///")
                        .pattern("/  ")
                        .input('/', ModItems.MATERIAL_ITEMS.get(name))
                        .criterion(hasItem(ModItems.MATERIAL_ITEMS.get(name)), conditionsFromItem(ModItems.MATERIAL_ITEMS.get(name)))
                        .offerTo(recipeExporter);

                ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.MACE_TIPS.get(name), 3)
                        .pattern(" / ")
                        .pattern("///")
                        .pattern(" / ")
                        .input('/', ModItems.MATERIAL_ITEMS.get(name))
                        .criterion(hasItem(ModItems.MATERIAL_ITEMS.get(name)), conditionsFromItem(ModItems.MATERIAL_ITEMS.get(name)))
                        .offerTo(recipeExporter);

                ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.SINGLEEDGE_BLADES.get(name), 3)
                        .pattern("  /")
                        .pattern(" / ")
                        .pattern("/  ")
                        .input('/', ModItems.MATERIAL_ITEMS.get(name))
                        .criterion(hasItem(ModItems.MATERIAL_ITEMS.get(name)), conditionsFromItem(ModItems.MATERIAL_ITEMS.get(name)))
                        .offerTo(recipeExporter);

                ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.CURVED_BLADES.get(name), 3)
                        .pattern(" /")
                        .pattern("/ ")
                        .pattern(" /")
                        .input('/', ModItems.MATERIAL_ITEMS.get(name))
                        .criterion(hasItem(ModItems.MATERIAL_ITEMS.get(name)), conditionsFromItem(ModItems.MATERIAL_ITEMS.get(name)))
                        .offerTo(recipeExporter);
            }

            ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.DOUBLEEDGE_BLADES.get(name), 1)
                    .pattern("//")
                    .input('/', ModItems.SINGLEEDGE_BLADES.get(name))
                    .criterion(hasItem(ModItems.SINGLEEDGE_BLADES.get(name)), conditionsFromItem(ModItems.SINGLEEDGE_BLADES.get(name)))
                    .offerTo(recipeExporter);

            ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.HALBERDS.get(name), 1)
                    .pattern(" #*")
                    .pattern(" / ")
                    .pattern("/  ")
                    .input('*', ModItems.STABBING_TIPS.get(name))
                    .input('#', ModItems.AXE_TIPS.get(name))
                    .input('/', Items.STICK)
                    .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                    .criterion(hasItem(ModItems.STABBING_TIPS.get(name)), conditionsFromItem(ModItems.STABBING_TIPS.get(name)))
                    .criterion(hasItem(ModItems.AXE_TIPS.get(name)), conditionsFromItem(ModItems.AXE_TIPS.get(name)))
                    .offerTo(recipeExporter);

            ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.GLAIVES.get(name), 1)
                    .pattern("  #")
                    .pattern(" / ")
                    .pattern("/  ")
                    .input('#', ModItems.SINGLEEDGE_BLADES.get(name))
                    .input('/', Items.STICK)
                    .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                    .criterion(hasItem(ModItems.SINGLEEDGE_BLADES.get(name)), conditionsFromItem(ModItems.SINGLEEDGE_BLADES.get(name)))
                    .offerTo(recipeExporter);

            ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.SCYTHES.get(name), 1)
                    .pattern("###")
                    .pattern(" / ")
                    .pattern("/  ")
                    .input('#', ModItems.CURVED_BLADES.get(name))
                    .input('/', Items.STICK)
                    .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                    .criterion(hasItem(ModItems.CURVED_BLADES.get(name)), conditionsFromItem(ModItems.CURVED_BLADES.get(name)))
                    .offerTo(recipeExporter);

            ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.RAPIERS.get(name), 1)
                    .pattern("  #")
                    .pattern(" # ")
                    .pattern("/  ")
                    .input('#', ModItems.STABBING_TIPS.get(name))
                    .input('/', ModItems.SMALL_STICK)
                    .criterion(hasItem(ModItems.STABBING_TIPS.get(name)), conditionsFromItem(ModItems.STABBING_TIPS.get(name)))
                    .criterion(hasItem(ModItems.SMALL_STICK), conditionsFromItem(ModItems.SMALL_STICK))
                    .offerTo(recipeExporter);

            ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.KATANAS.get(name), 1)
                    .pattern("#  ")
                    .pattern(" # ")
                    .pattern("  /")
                    .input('#', ModItems.SINGLEEDGE_BLADES.get(name))
                    .input('/', ModItems.SMALL_STICK)
                    .criterion(hasItem(ModItems.SINGLEEDGE_BLADES.get(name)), conditionsFromItem(ModItems.SINGLEEDGE_BLADES.get(name)))
                    .criterion(hasItem(ModItems.SMALL_STICK), conditionsFromItem(ModItems.SMALL_STICK))
                    .offerTo(recipeExporter);

            ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.BATTLE_AXES.get(name), 1)
                    .pattern("#/#")
                    .pattern(" / ")
                    .input('#', ModItems.AXE_TIPS.get(name))
                    .input('/', ModItems.SMALL_STICK)
                    .criterion(hasItem(ModItems.AXE_TIPS.get(name)), conditionsFromItem(ModItems.AXE_TIPS.get(name)))
                    .criterion(hasItem(ModItems.SMALL_STICK), conditionsFromItem(ModItems.SMALL_STICK))
                    .offerTo(recipeExporter);

            ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.SAI.get(name), 1)
                    .pattern("##")
                    .pattern("/#")
                    .input('#', ModItems.STABBING_TIPS.get(name))
                    .input('/', ModItems.SMALL_STICK)
                    .criterion(hasItem(ModItems.STABBING_TIPS.get(name)), conditionsFromItem(ModItems.STABBING_TIPS.get(name)))
                    .criterion(hasItem(ModItems.SMALL_STICK), conditionsFromItem(ModItems.SMALL_STICK))
                    .offerTo(recipeExporter);

            ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.DAGGERS.get(name), 1)
                    .pattern(" #")
                    .pattern("/ ")
                    .input('#', ModItems.CURVED_BLADES.get(name))
                    .input('/', ModItems.SMALL_STICK)
                    .criterion(hasItem(ModItems.CURVED_BLADES.get(name)), conditionsFromItem(ModItems.CURVED_BLADES.get(name)))
                    .criterion(hasItem(ModItems.SMALL_STICK), conditionsFromItem(ModItems.SMALL_STICK))
                    .offerTo(recipeExporter);

            ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.ODACHIS.get(name), 1)
                    .pattern("*  ")
                    .pattern(" # ")
                    .pattern("  /")
                    .input('*', ModItems.SINGLEEDGE_BLADES.get(name))
                    .input('#', ModItems.KATANAS.get(name))
                    .input('/', ModItems.SMALL_STICK)
                    .criterion(hasItem(ModItems.SINGLEEDGE_BLADES.get(name)), conditionsFromItem(ModItems.SINGLEEDGE_BLADES.get(name)))
                    .criterion(hasItem(ModItems.KATANAS.get(name)), conditionsFromItem(ModItems.KATANAS.get(name)))
                    .criterion(hasItem(ModItems.SMALL_STICK), conditionsFromItem(ModItems.SMALL_STICK))
                    .offerTo(recipeExporter);

            ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.MACES.get(name), 1)
                    .pattern(" #")
                    .pattern("/ ")
                    .input('#', ModItems.MACE_TIPS.get(name))
                    .input('/', Items.STICK)
                    .criterion(hasItem(ModItems.MACE_TIPS.get(name)), conditionsFromItem(ModItems.MACE_TIPS.get(name)))
                    .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                    .offerTo(recipeExporter);
        }

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.CLAYMORES.get("wood"), 1)
                .pattern(" # ")
                .pattern("/  ")
                .input('/', Items.WOODEN_SWORD)
                .input('#', ModItems.DOUBLEEDGE_BLADES.get("wood"))
                .criterion(hasItem(Items.WOODEN_SWORD), conditionsFromItem(Items.WOODEN_SWORD))
                .criterion(hasItem(ModItems.DOUBLEEDGE_BLADES.get("wood")), conditionsFromItem(ModItems.DOUBLEEDGE_BLADES.get("wood")))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.CLAYMORES.get("stone"), 1)
                .pattern(" #")
                .pattern("/ ")
                .input('/', Items.STONE_SWORD)
                .input('#', ModItems.DOUBLEEDGE_BLADES.get("stone"))
                .criterion(hasItem(Items.STONE_SWORD), conditionsFromItem(Items.STONE_SWORD))
                .criterion(hasItem(ModItems.DOUBLEEDGE_BLADES.get("stone")), conditionsFromItem(ModItems.DOUBLEEDGE_BLADES.get("stone")))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.CLAYMORES.get("iron"), 1)
                .pattern(" #")
                .pattern("/ ")
                .input('/', Items.IRON_SWORD)
                .input('#', ModItems.DOUBLEEDGE_BLADES.get("iron"))
                .criterion(hasItem(Items.IRON_SWORD), conditionsFromItem(Items.IRON_SWORD))
                .criterion(hasItem(ModItems.DOUBLEEDGE_BLADES.get("iron")), conditionsFromItem(ModItems.DOUBLEEDGE_BLADES.get("iron")))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.CLAYMORES.get("gold"), 1)
                .pattern(" #")
                .pattern("/ ")
                .input('/', Items.GOLDEN_SWORD)
                .input('#', ModItems.DOUBLEEDGE_BLADES.get("gold"))
                .criterion(hasItem(Items.GOLDEN_SWORD), conditionsFromItem(Items.GOLDEN_SWORD))
                .criterion(hasItem(ModItems.DOUBLEEDGE_BLADES.get("gold")), conditionsFromItem(ModItems.DOUBLEEDGE_BLADES.get("gold")))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.CLAYMORES.get("diamond"), 1)
                .pattern(" #")
                .pattern("/ ")
                .input('/', Items.DIAMOND_SWORD)
                .input('#', ModItems.DOUBLEEDGE_BLADES.get("diamond"))
                .criterion(hasItem(Items.DIAMOND_SWORD), conditionsFromItem(Items.DIAMOND_SWORD))
                .criterion(hasItem(ModItems.DOUBLEEDGE_BLADES.get("diamond")), conditionsFromItem(ModItems.DOUBLEEDGE_BLADES.get("diamond")))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.CLAYMORES.get("netherite"), 1)
                .pattern(" #")
                .pattern("/ ")
                .input('/', Items.NETHERITE_SWORD)
                .input('#', ModItems.DOUBLEEDGE_BLADES.get("netherite"))
                .criterion(hasItem(Items.NETHERITE_SWORD), conditionsFromItem(Items.NETHERITE_SWORD))
                .criterion(hasItem(ModItems.DOUBLEEDGE_BLADES.get("netherite")), conditionsFromItem(ModItems.DOUBLEEDGE_BLADES.get("netherite")))
                .offerTo(recipeExporter);
    }
}

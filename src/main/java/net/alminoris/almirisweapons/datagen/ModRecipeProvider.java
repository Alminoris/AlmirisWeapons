package net.alminoris.almirisweapons.datagen;

import net.alminoris.almirisweapons.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.tag.ItemTags;

import java.util.function.Consumer;

public class ModRecipeProvider extends FabricRecipeProvider
{
    public ModRecipeProvider(FabricDataGenerator dataGenerator) 
    {
        super(dataGenerator);
    }

    @Override
    public void generateRecipes(Consumer<RecipeJsonProvider> recipeExporter)
    {
        ShapedRecipeJsonBuilder.create(ModItems.HALBERDS.get("wood"), 1)
                .pattern("  #")
                .pattern(" /#")
                .pattern("/  ")
                .input('#', ItemTags.PLANKS)
                .input('/', Items.STICK)
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(ModItems.HALBERDS.get("stone"), 1)
                .pattern("  #")
                .pattern(" /#")
                .pattern("/  ")
                .input('#', ItemTags.STONE_TOOL_MATERIALS)
                .input('/', Items.STICK)
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(ModItems.HALBERDS.get("iron"), 1)
                .pattern("  #")
                .pattern(" /#")
                .pattern("/  ")
                .input('#', Items.IRON_INGOT)
                .input('/', Items.STICK)
                .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(ModItems.HALBERDS.get("gold"), 1)
                .pattern("  #")
                .pattern(" /#")
                .pattern("/  ")
                .input('#', Items.GOLD_INGOT)
                .input('/', Items.STICK)
                .criterion(hasItem(Items.GOLD_INGOT), conditionsFromItem(Items.GOLD_INGOT))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(ModItems.HALBERDS.get("diamond"), 1)
                .pattern("  #")
                .pattern(" /#")
                .pattern("/  ")
                .input('#', Items.DIAMOND)
                .input('/', Items.STICK)
                .criterion(hasItem(Items.DIAMOND), conditionsFromItem(Items.DIAMOND))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(ModItems.HALBERDS.get("netherite"), 1)
                .pattern("  #")
                .pattern(" /#")
                .pattern("/  ")
                .input('#', Items.NETHERITE_INGOT)
                .input('/', Items.STICK)
                .criterion(hasItem(Items.NETHERITE_INGOT), conditionsFromItem(Items.NETHERITE_INGOT))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(ModItems.RAPIERS.get("wood"), 1)
                .pattern("  #")
                .pattern(" # ")
                .pattern("/  ")
                .input('#', ItemTags.PLANKS)
                .input('/', Items.STICK)
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(ModItems.RAPIERS.get("stone"), 1)
                .pattern("  #")
                .pattern(" # ")
                .pattern("/  ")
                .input('#', ItemTags.STONE_TOOL_MATERIALS)
                .input('/', Items.STICK)
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(ModItems.RAPIERS.get("iron"), 1)
                .pattern("  #")
                .pattern(" # ")
                .pattern("/  ")
                .input('#', Items.IRON_INGOT)
                .input('/', Items.STICK)
                .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(ModItems.RAPIERS.get("gold"), 1)
                .pattern("  #")
                .pattern(" # ")
                .pattern("/  ")
                .input('#', Items.GOLD_INGOT)
                .input('/', Items.STICK)
                .criterion(hasItem(Items.GOLD_INGOT), conditionsFromItem(Items.GOLD_INGOT))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(ModItems.RAPIERS.get("diamond"), 1)
                .pattern("  #")
                .pattern(" # ")
                .pattern("/  ")
                .input('#', Items.DIAMOND)
                .input('/', Items.STICK)
                .criterion(hasItem(Items.DIAMOND), conditionsFromItem(Items.DIAMOND))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(ModItems.RAPIERS.get("netherite"), 1)
                .pattern("  #")
                .pattern(" # ")
                .pattern("/  ")
                .input('#', Items.NETHERITE_INGOT)
                .input('/', Items.STICK)
                .criterion(hasItem(Items.NETHERITE_INGOT), conditionsFromItem(Items.NETHERITE_INGOT))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(ModItems.CLAYMORES.get("wood"), 1)
                .pattern(" # ")
                .pattern("/  ")
                .input('#', Items.WOODEN_SWORD)
                .input('/', Items.STICK)
                .criterion(hasItem(Items.WOODEN_SWORD), conditionsFromItem(Items.WOODEN_SWORD))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(ModItems.CLAYMORES.get("stone"), 1)
                .pattern(" # ")
                .pattern("/  ")
                .input('#', Items.STONE_SWORD)
                .input('/', Items.STICK)
                .criterion(hasItem(Items.STONE_SWORD), conditionsFromItem(Items.STONE_SWORD))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(ModItems.CLAYMORES.get("iron"), 1)
                .pattern(" # ")
                .pattern("/  ")
                .input('#', Items.IRON_SWORD)
                .input('/', Items.STICK)
                .criterion(hasItem(Items.IRON_SWORD), conditionsFromItem(Items.IRON_SWORD))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(ModItems.CLAYMORES.get("gold"), 1)
                .pattern(" # ")
                .pattern("/  ")
                .input('#', Items.GOLDEN_SWORD)
                .input('/', Items.STICK)
                .criterion(hasItem(Items.GOLDEN_SWORD), conditionsFromItem(Items.GOLDEN_SWORD))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(ModItems.CLAYMORES.get("diamond"), 1)
                .pattern(" # ")
                .pattern("/  ")
                .input('#', Items.DIAMOND_SWORD)
                .input('/', Items.STICK)
                .criterion(hasItem(Items.DIAMOND_SWORD), conditionsFromItem(Items.DIAMOND_SWORD))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(ModItems.CLAYMORES.get("netherite"), 1)
                .pattern(" # ")
                .pattern("/  ")
                .input('#', Items.NETHERITE_SWORD)
                .input('/', Items.STICK)
                .criterion(hasItem(Items.NETHERITE_SWORD), conditionsFromItem(Items.NETHERITE_SWORD))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(ModItems.BATTLE_AXES.get("wood"), 1)
                .pattern(" # ")
                .pattern("#/#")
                .pattern(" / ")
                .input('#', ItemTags.PLANKS)
                .input('/', Items.STICK)
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(ModItems.BATTLE_AXES.get("stone"), 1)
                .pattern(" # ")
                .pattern("#/#")
                .pattern(" / ")
                .input('#', ItemTags.STONE_TOOL_MATERIALS)
                .input('/', Items.STICK)
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(ModItems.BATTLE_AXES.get("iron"), 1)
                .pattern(" # ")
                .pattern("#/#")
                .pattern(" / ")
                .input('#', Items.IRON_INGOT)
                .input('/', Items.STICK)
                .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(ModItems.BATTLE_AXES.get("gold"), 1)
                .pattern(" # ")
                .pattern("#/#")
                .pattern(" / ")
                .input('#', Items.GOLD_INGOT)
                .input('/', Items.STICK)
                .criterion(hasItem(Items.GOLD_INGOT), conditionsFromItem(Items.GOLD_INGOT))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(ModItems.BATTLE_AXES.get("diamond"), 1)
                .pattern(" # ")
                .pattern("#/#")
                .pattern(" / ")
                .input('#', Items.DIAMOND)
                .input('/', Items.STICK)
                .criterion(hasItem(Items.DIAMOND), conditionsFromItem(Items.DIAMOND))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(ModItems.BATTLE_AXES.get("netherite"), 1)
                .pattern(" # ")
                .pattern("#/#")
                .pattern(" / ")
                .input('#', Items.NETHERITE_INGOT)
                .input('/', Items.STICK)
                .criterion(hasItem(Items.NETHERITE_INGOT), conditionsFromItem(Items.NETHERITE_INGOT))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(ModItems.SAI.get("wood"), 1)
                .pattern("  #")
                .pattern("## ")
                .pattern("/# ")
                .input('#', ItemTags.PLANKS)
                .input('/', Items.STICK)
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(ModItems.SAI.get("stone"), 1)
                .pattern("  #")
                .pattern("## ")
                .pattern("/# ")
                .input('#', ItemTags.STONE_TOOL_MATERIALS)
                .input('/', Items.STICK)
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(ModItems.SAI.get("iron"), 1)
                .pattern("  #")
                .pattern("## ")
                .pattern("/# ")
                .input('#', Items.IRON_INGOT)
                .input('/', Items.STICK)
                .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(ModItems.SAI.get("gold"), 1)
                .pattern("  #")
                .pattern("## ")
                .pattern("/# ")
                .input('#', Items.GOLD_INGOT)
                .input('/', Items.STICK)
                .criterion(hasItem(Items.GOLD_INGOT), conditionsFromItem(Items.GOLD_INGOT))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(ModItems.SAI.get("diamond"), 1)
                .pattern("  #")
                .pattern("## ")
                .pattern("/# ")
                .input('#', Items.DIAMOND)
                .input('/', Items.STICK)
                .criterion(hasItem(Items.DIAMOND), conditionsFromItem(Items.DIAMOND))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(ModItems.SAI.get("netherite"), 1)
                .pattern("  #")
                .pattern("## ")
                .pattern("/# ")
                .input('#', Items.NETHERITE_INGOT)
                .input('/', Items.STICK)
                .criterion(hasItem(Items.NETHERITE_INGOT), conditionsFromItem(Items.NETHERITE_INGOT))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(ModItems.MACES.get("wood"), 1)
                .pattern(" ##")
                .pattern(" ##")
                .pattern("/  ")
                .input('#', ItemTags.PLANKS)
                .input('/', Items.STICK)
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(ModItems.MACES.get("stone"), 1)
                .pattern(" ##")
                .pattern(" ##")
                .pattern("/  ")
                .input('#', ItemTags.STONE_TOOL_MATERIALS)
                .input('/', Items.STICK)
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(ModItems.MACES.get("iron"), 1)
                .pattern(" ##")
                .pattern(" ##")
                .pattern("/  ")
                .input('#', Items.IRON_INGOT)
                .input('/', Items.STICK)
                .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(ModItems.MACES.get("gold"), 1)
                .pattern(" ##")
                .pattern(" ##")
                .pattern("/  ")
                .input('#', Items.GOLD_INGOT)
                .input('/', Items.STICK)
                .criterion(hasItem(Items.GOLD_INGOT), conditionsFromItem(Items.GOLD_INGOT))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(ModItems.MACES.get("diamond"), 1)
                .pattern(" ##")
                .pattern(" ##")
                .pattern("/  ")
                .input('#', Items.DIAMOND)
                .input('/', Items.STICK)
                .criterion(hasItem(Items.DIAMOND), conditionsFromItem(Items.DIAMOND))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(ModItems.MACES.get("netherite"), 1)
                .pattern(" ##")
                .pattern(" ##")
                .pattern("/  ")
                .input('#', Items.NETHERITE_INGOT)
                .input('/', Items.STICK)
                .criterion(hasItem(Items.NETHERITE_INGOT), conditionsFromItem(Items.NETHERITE_INGOT))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(recipeExporter);
    }
}

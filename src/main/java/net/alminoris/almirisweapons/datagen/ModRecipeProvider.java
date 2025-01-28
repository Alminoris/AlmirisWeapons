package net.alminoris.almirisweapons.datagen;

import net.alminoris.almirisweapons.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider
{
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture)
    {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter recipeExporter)
    {
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.HALBERDS.get("wood"), 1)
                .pattern("  #")
                .pattern(" /#")
                .pattern("/  ")
                .input('#', ItemTags.PLANKS)
                .input('/', Items.STICK)
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.HALBERDS.get("stone"), 1)
                .pattern("  #")
                .pattern(" /#")
                .pattern("/  ")
                .input('#', ItemTags.STONE_TOOL_MATERIALS)
                .input('/', Items.STICK)
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.HALBERDS.get("iron"), 1)
                .pattern("  #")
                .pattern(" /#")
                .pattern("/  ")
                .input('#', Items.IRON_INGOT)
                .input('/', Items.STICK)
                .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.HALBERDS.get("gold"), 1)
                .pattern("  #")
                .pattern(" /#")
                .pattern("/  ")
                .input('#', Items.GOLD_INGOT)
                .input('/', Items.STICK)
                .criterion(hasItem(Items.GOLD_INGOT), conditionsFromItem(Items.GOLD_INGOT))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.HALBERDS.get("diamond"), 1)
                .pattern("  #")
                .pattern(" /#")
                .pattern("/  ")
                .input('#', Items.DIAMOND)
                .input('/', Items.STICK)
                .criterion(hasItem(Items.DIAMOND), conditionsFromItem(Items.DIAMOND))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.HALBERDS.get("netherite"), 1)
                .pattern("  #")
                .pattern(" /#")
                .pattern("/  ")
                .input('#', Items.NETHERITE_INGOT)
                .input('/', Items.STICK)
                .criterion(hasItem(Items.NETHERITE_INGOT), conditionsFromItem(Items.NETHERITE_INGOT))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.RAPIERS.get("wood"), 1)
                .pattern("  #")
                .pattern(" # ")
                .pattern("/  ")
                .input('#', ItemTags.PLANKS)
                .input('/', Items.STICK)
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.RAPIERS.get("stone"), 1)
                .pattern("  #")
                .pattern(" # ")
                .pattern("/  ")
                .input('#', ItemTags.STONE_TOOL_MATERIALS)
                .input('/', Items.STICK)
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.RAPIERS.get("iron"), 1)
                .pattern("  #")
                .pattern(" # ")
                .pattern("/  ")
                .input('#', Items.IRON_INGOT)
                .input('/', Items.STICK)
                .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.RAPIERS.get("gold"), 1)
                .pattern("  #")
                .pattern(" # ")
                .pattern("/  ")
                .input('#', Items.GOLD_INGOT)
                .input('/', Items.STICK)
                .criterion(hasItem(Items.GOLD_INGOT), conditionsFromItem(Items.GOLD_INGOT))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.RAPIERS.get("diamond"), 1)
                .pattern("  #")
                .pattern(" # ")
                .pattern("/  ")
                .input('#', Items.DIAMOND)
                .input('/', Items.STICK)
                .criterion(hasItem(Items.DIAMOND), conditionsFromItem(Items.DIAMOND))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.RAPIERS.get("netherite"), 1)
                .pattern("  #")
                .pattern(" # ")
                .pattern("/  ")
                .input('#', Items.NETHERITE_INGOT)
                .input('/', Items.STICK)
                .criterion(hasItem(Items.NETHERITE_INGOT), conditionsFromItem(Items.NETHERITE_INGOT))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.CLAYMORES.get("wood"), 1)
                .pattern(" # ")
                .pattern("/  ")
                .input('#', Items.WOODEN_SWORD)
                .input('/', Items.STICK)
                .criterion(hasItem(Items.WOODEN_SWORD), conditionsFromItem(Items.WOODEN_SWORD))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.CLAYMORES.get("stone"), 1)
                .pattern(" # ")
                .pattern("/  ")
                .input('#', Items.STONE_SWORD)
                .input('/', Items.STICK)
                .criterion(hasItem(Items.STONE_SWORD), conditionsFromItem(Items.STONE_SWORD))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.CLAYMORES.get("iron"), 1)
                .pattern(" # ")
                .pattern("/  ")
                .input('#', Items.IRON_SWORD)
                .input('/', Items.STICK)
                .criterion(hasItem(Items.IRON_SWORD), conditionsFromItem(Items.IRON_SWORD))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.CLAYMORES.get("gold"), 1)
                .pattern(" # ")
                .pattern("/  ")
                .input('#', Items.GOLDEN_SWORD)
                .input('/', Items.STICK)
                .criterion(hasItem(Items.GOLDEN_SWORD), conditionsFromItem(Items.GOLDEN_SWORD))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.CLAYMORES.get("diamond"), 1)
                .pattern(" # ")
                .pattern("/  ")
                .input('#', Items.DIAMOND_SWORD)
                .input('/', Items.STICK)
                .criterion(hasItem(Items.DIAMOND_SWORD), conditionsFromItem(Items.DIAMOND_SWORD))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.CLAYMORES.get("netherite"), 1)
                .pattern(" # ")
                .pattern("/  ")
                .input('#', Items.NETHERITE_SWORD)
                .input('/', Items.STICK)
                .criterion(hasItem(Items.NETHERITE_SWORD), conditionsFromItem(Items.NETHERITE_SWORD))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.BATTLE_AXES.get("wood"), 1)
                .pattern(" # ")
                .pattern("#/#")
                .pattern(" / ")
                .input('#', ItemTags.PLANKS)
                .input('/', Items.STICK)
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.BATTLE_AXES.get("stone"), 1)
                .pattern(" # ")
                .pattern("#/#")
                .pattern(" / ")
                .input('#', ItemTags.STONE_TOOL_MATERIALS)
                .input('/', Items.STICK)
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.BATTLE_AXES.get("iron"), 1)
                .pattern(" # ")
                .pattern("#/#")
                .pattern(" / ")
                .input('#', Items.IRON_INGOT)
                .input('/', Items.STICK)
                .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.BATTLE_AXES.get("gold"), 1)
                .pattern(" # ")
                .pattern("#/#")
                .pattern(" / ")
                .input('#', Items.GOLD_INGOT)
                .input('/', Items.STICK)
                .criterion(hasItem(Items.GOLD_INGOT), conditionsFromItem(Items.GOLD_INGOT))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.BATTLE_AXES.get("diamond"), 1)
                .pattern(" # ")
                .pattern("#/#")
                .pattern(" / ")
                .input('#', Items.DIAMOND)
                .input('/', Items.STICK)
                .criterion(hasItem(Items.DIAMOND), conditionsFromItem(Items.DIAMOND))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.BATTLE_AXES.get("netherite"), 1)
                .pattern(" # ")
                .pattern("#/#")
                .pattern(" / ")
                .input('#', Items.NETHERITE_INGOT)
                .input('/', Items.STICK)
                .criterion(hasItem(Items.NETHERITE_INGOT), conditionsFromItem(Items.NETHERITE_INGOT))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.SAI.get("wood"), 1)
                .pattern("  #")
                .pattern("## ")
                .pattern("/# ")
                .input('#', ItemTags.PLANKS)
                .input('/', Items.STICK)
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.SAI.get("stone"), 1)
                .pattern("  #")
                .pattern("## ")
                .pattern("/# ")
                .input('#', ItemTags.STONE_TOOL_MATERIALS)
                .input('/', Items.STICK)
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.SAI.get("iron"), 1)
                .pattern("  #")
                .pattern("## ")
                .pattern("/# ")
                .input('#', Items.IRON_INGOT)
                .input('/', Items.STICK)
                .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.SAI.get("gold"), 1)
                .pattern("  #")
                .pattern("## ")
                .pattern("/# ")
                .input('#', Items.GOLD_INGOT)
                .input('/', Items.STICK)
                .criterion(hasItem(Items.GOLD_INGOT), conditionsFromItem(Items.GOLD_INGOT))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.SAI.get("diamond"), 1)
                .pattern("  #")
                .pattern("## ")
                .pattern("/# ")
                .input('#', Items.DIAMOND)
                .input('/', Items.STICK)
                .criterion(hasItem(Items.DIAMOND), conditionsFromItem(Items.DIAMOND))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.SAI.get("netherite"), 1)
                .pattern("  #")
                .pattern("## ")
                .pattern("/# ")
                .input('#', Items.NETHERITE_INGOT)
                .input('/', Items.STICK)
                .criterion(hasItem(Items.NETHERITE_INGOT), conditionsFromItem(Items.NETHERITE_INGOT))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.MACES.get("wood"), 1)
                .pattern(" ##")
                .pattern(" ##")
                .pattern("/  ")
                .input('#', ItemTags.PLANKS)
                .input('/', Items.STICK)
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.MACES.get("stone"), 1)
                .pattern(" ##")
                .pattern(" ##")
                .pattern("/  ")
                .input('#', ItemTags.STONE_TOOL_MATERIALS)
                .input('/', Items.STICK)
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.MACES.get("iron"), 1)
                .pattern(" ##")
                .pattern(" ##")
                .pattern("/  ")
                .input('#', Items.IRON_INGOT)
                .input('/', Items.STICK)
                .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.MACES.get("gold"), 1)
                .pattern(" ##")
                .pattern(" ##")
                .pattern("/  ")
                .input('#', Items.GOLD_INGOT)
                .input('/', Items.STICK)
                .criterion(hasItem(Items.GOLD_INGOT), conditionsFromItem(Items.GOLD_INGOT))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.MACES.get("diamond"), 1)
                .pattern(" ##")
                .pattern(" ##")
                .pattern("/  ")
                .input('#', Items.DIAMOND)
                .input('/', Items.STICK)
                .criterion(hasItem(Items.DIAMOND), conditionsFromItem(Items.DIAMOND))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.MACES.get("netherite"), 1)
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

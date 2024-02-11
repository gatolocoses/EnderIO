package com.enderio.base.common.init;

import com.enderio.EnderIO;
import com.enderio.base.client.renderer.PaintedBlockColor;
import com.enderio.base.common.block.ColdFireBlock;
import com.enderio.base.common.block.DarkSteelLadderBlock;
import com.enderio.base.common.block.EIOPressurePlateBlock;
import com.enderio.base.common.block.EnderSkullBlock;
import com.enderio.base.common.block.IndustrialInsulationBlock;
import com.enderio.base.common.block.ReinforcedObsidianBlock;
import com.enderio.base.common.block.ResettingLeverBlock;
import com.enderio.base.common.block.SilentPressurePlateBlock;
import com.enderio.base.common.block.SilentWeightedPressurePlateBlock;
import com.enderio.base.common.block.WallEnderSkullBlock;
import com.enderio.base.common.block.glass.GlassBlocks;
import com.enderio.base.common.block.glass.GlassCollisionPredicate;
import com.enderio.base.common.block.glass.GlassIdentifier;
import com.enderio.base.common.block.glass.GlassLighting;
import com.enderio.base.common.block.light.Light;
import com.enderio.base.common.block.light.LightNode;
import com.enderio.base.common.block.light.PoweredLight;
import com.enderio.base.common.block.painted.PaintedCraftingTableBlock;
import com.enderio.base.common.block.painted.PaintedFenceBlock;
import com.enderio.base.common.block.painted.PaintedFenceGateBlock;
import com.enderio.base.common.block.painted.PaintedRedstoneBlock;
import com.enderio.base.common.block.painted.PaintedSandBlock;
import com.enderio.base.common.block.painted.PaintedSlabBlock;
import com.enderio.base.common.block.painted.PaintedStairBlock;
import com.enderio.base.common.block.painted.PaintedTrapDoorBlock;
import com.enderio.base.common.block.painted.PaintedWoodenPressurePlateBlock;
import com.enderio.base.common.block.painted.SinglePaintedBlock;
import com.enderio.base.common.item.PaintedBlockItem;
import com.enderio.base.common.item.PaintedSlabBlockItem;
import com.enderio.base.common.item.misc.EnderSkullBlockItem;
import com.enderio.base.common.tag.EIOTags;
import com.enderio.base.data.loot.DecorLootTable;
import com.enderio.base.data.model.block.EIOBlockState;
import com.enderio.regilite.holder.RegiliteBlock;
import com.enderio.regilite.registry.BlockRegistry;
import com.enderio.regilite.registry.ItemRegistry;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ChainBlock;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.IronBarsBlock;
import net.minecraft.world.level.block.LeverBlock;
import net.minecraft.world.level.block.PressurePlateBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.block.WeightedPressurePlateBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.AttachFace;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.neoforged.neoforge.client.model.generators.BlockModelProvider;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.client.model.generators.VariantBlockStateBuilder;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.Function;

@SuppressWarnings("unused")
public class EIOBlocks {
    private static final BlockRegistry BLOCK_REGISTRY = BlockRegistry.createRegistry(EnderIO.MODID);
    private static final ItemRegistry ITEM_REGISTRY = ItemRegistry.createRegistry(EnderIO.MODID);

    // region Alloy Blocks

    public static final RegiliteBlock<Block> COPPER_ALLOY_BLOCK = metalBlock("copper_alloy_block", EIOTags.Blocks.BLOCKS_COPPER_ALLOY,
        EIOTags.Items.BLOCKS_COPPER_ALLOY);
    public static final RegiliteBlock<Block> ENERGETIC_ALLOY_BLOCK = metalBlock("energetic_alloy_block", EIOTags.Blocks.BLOCKS_ENERGETIC_ALLOY,
        EIOTags.Items.BLOCKS_ENERGETIC_ALLOY);
    public static final RegiliteBlock<Block> VIBRANT_ALLOY_BLOCK = metalBlock("vibrant_alloy_block", EIOTags.Blocks.BLOCKS_VIBRANT_ALLOY,
        EIOTags.Items.BLOCKS_VIBRANT_ALLOY);
    public static final RegiliteBlock<Block> REDSTONE_ALLOY_BLOCK = metalBlock("redstone_alloy_block", EIOTags.Blocks.BLOCKS_REDSTONE_ALLOY,
        EIOTags.Items.BLOCKS_REDSTONE_ALLOY);
    public static final RegiliteBlock<Block> CONDUCTIVE_ALLOY_BLOCK = metalBlock("conductive_alloy_block", EIOTags.Blocks.BLOCKS_CONDUCTIVE_ALLOY,
        EIOTags.Items.BLOCKS_CONDUCTIVE_ALLOY);
    public static final RegiliteBlock<Block> PULSATING_ALLOY_BLOCK = metalBlock("pulsating_alloy_block", EIOTags.Blocks.BLOCKS_PULSATING_ALLOY,
        EIOTags.Items.BLOCKS_PULSATING_ALLOY);
    public static final RegiliteBlock<Block> DARK_STEEL_BLOCK = metalBlock("dark_steel_block", EIOTags.Blocks.BLOCKS_DARK_STEEL,
        EIOTags.Items.BLOCKS_DARK_STEEL);
    public static final RegiliteBlock<Block> SOULARIUM_BLOCK = metalBlock("soularium_block", EIOTags.Blocks.BLOCKS_SOULARIUM,
        EIOTags.Items.BLOCKS_SOULARIUM);
    public static final RegiliteBlock<Block> END_STEEL_BLOCK = metalBlock("end_steel_block", EIOTags.Blocks.BLOCKS_END_STEEL,
        EIOTags.Items.BLOCKS_END_STEEL);

    // endregion

    // region Chassis

    // Iron tier
    public static final RegiliteBlock<Block> VOID_CHASSIS = chassisBlock("void_chassis");

    // Void chassis + some kind of dragons breath derrived process
    //    public static final RegiliteBlock<Block> REKINDLED_VOID_CHASSIS = chassisBlock("rekindled_void_chassis").register();

    // Soularium + soul/nether
    public static final RegiliteBlock<Block> ENSOULED_CHASSIS = chassisBlock("ensouled_chassis");

    // Ensnared + Some kind of other material
    // This is for machines that require a bound soul
    //    public static final RegiliteBlock<Block> TRAPPED_CHASSIS = chassisBlock("trapped_chassis").register();

    // Dark steel + sculk
    //    public static final RegiliteBlock<Block> SCULK_CHASSIS = chassisBlock("sculk_chassis").register();

    // endregion

    // endregion

    // region Dark Steel Building Blocks

    public static final RegiliteBlock<DarkSteelLadderBlock> DARK_STEEL_LADDER = REGISTRATE
        .block("dark_steel_ladder", DarkSteelLadderBlock::new)
        .properties(props -> props.strength(0.4f).requiresCorrectToolForDrops().sound(SoundType.METAL).mapColor(MapColor.METAL).noOcclusion())
        .blockstate((ctx, prov) -> prov.horizontalBlock(ctx.get(), prov
            .models()
            .withExistingParent(ctx.getName(), prov.mcLoc("block/ladder"))
            .renderType(prov.mcLoc("cutout_mipped"))
            .texture("particle", prov.blockTexture(ctx.get()))
            .texture("texture", prov.blockTexture(ctx.get()))))
        .tag(BlockTags.CLIMBABLE, BlockTags.NEEDS_IRON_TOOL, BlockTags.MINEABLE_WITH_PICKAXE)
        .item()
        .model((ctx, prov) -> prov.generated(ctx, prov.modLoc("block/dark_steel_ladder")))
        .tab(EIOCreativeTabs.BLOCKS)
        .build()
        .register();

    public static final RegiliteBlock<IronBarsBlock> DARK_STEEL_BARS = REGISTRATE
        .block("dark_steel_bars", IronBarsBlock::new)
        .properties(props -> props.strength(5.0f, 1000.0f).requiresCorrectToolForDrops().sound(SoundType.METAL).noOcclusion())
        .blockstate(EIOBlockState::paneBlock)
        .tag(BlockTags.NEEDS_IRON_TOOL)
        .tag(BlockTags.MINEABLE_WITH_PICKAXE)
        .item()
        .tab(EIOCreativeTabs.BLOCKS)
        .model((ctx, prov) -> prov.generated(ctx, prov.modLoc("block/dark_steel_bars")))
        .build()
        .register();

    public static final RegiliteBlock<DoorBlock> DARK_STEEL_DOOR = REGISTRATE
        .block("dark_steel_door", props -> new DoorBlock(props, BlockSetType.IRON))
        .properties(props -> props.strength(5.0f, 2000.0f).sound(SoundType.METAL).mapColor(MapColor.METAL).noOcclusion())
        .loot((registrateBlockLootTables, doorBlock) -> registrateBlockLootTables.add(doorBlock, registrateBlockLootTables.createDoorTable(doorBlock)))
        .blockstate(
            (ctx, prov) -> prov.doorBlockWithRenderType(ctx.get(), prov.modLoc("block/dark_steel_door_bottom"), prov.modLoc("block/dark_steel_door_top"),
                prov.mcLoc("cutout")))
        .tag(BlockTags.MINEABLE_WITH_PICKAXE, BlockTags.NEEDS_IRON_TOOL, BlockTags.DOORS)
        .item()
        .model((ctx, prov) -> prov.generated(ctx))
        .tab(EIOCreativeTabs.BLOCKS)
        .build()
        .register();

    public static final RegiliteBlock<TrapDoorBlock> DARK_STEEL_TRAPDOOR = REGISTRATE
        .block("dark_steel_trapdoor", props -> new TrapDoorBlock(props, BlockSetType.IRON))
        .properties(props -> props.strength(5.0f, 2000.0f).sound(SoundType.METAL).mapColor(MapColor.METAL).noOcclusion())
        .blockstate((ctx, prov) -> prov.trapdoorBlockWithRenderType(ctx.get(), prov.modLoc("block/dark_steel_trapdoor"), true, prov.mcLoc("cutout")))
        .tag(BlockTags.MINEABLE_WITH_PICKAXE, BlockTags.NEEDS_IRON_TOOL, BlockTags.TRAPDOORS)
        .item()
        .model((ctx, prov) -> prov.withExistingParent(ctx.getName(), prov.modLoc("block/dark_steel_trapdoor_bottom")))
        .tab(EIOCreativeTabs.BLOCKS)
        .build()
        .register();

    public static final RegiliteBlock<IronBarsBlock> END_STEEL_BARS = REGISTRATE
        .block("end_steel_bars", IronBarsBlock::new)
        .blockstate(EIOBlockState::paneBlock)
        .properties(props -> props.strength(5.0f, 1000.0f).requiresCorrectToolForDrops().sound(SoundType.METAL).noOcclusion())
        .tag(BlockTags.NEEDS_IRON_TOOL)
        .tag(BlockTags.MINEABLE_WITH_PICKAXE)
        .item()
        .tab(EIOCreativeTabs.BLOCKS)
        .model((ctx, prov) -> prov.generated(ctx, prov.modLoc("block/end_steel_bars")))
        .build()
        .register();

    public static final RegiliteBlock<ReinforcedObsidianBlock> REINFORCED_OBSIDIAN = REGISTRATE
        .block("reinforced_obsidian_block", ReinforcedObsidianBlock::new)
        .properties(props -> props
            .sound(SoundType.STONE)
            .strength(50, 2000)
            .requiresCorrectToolForDrops()
            .mapColor(MapColor.COLOR_BLACK)
            .instrument(NoteBlockInstrument.BASEDRUM))
        .tag(BlockTags.WITHER_IMMUNE)
        .tag(BlockTags.NEEDS_DIAMOND_TOOL)
        .tag(BlockTags.MINEABLE_WITH_PICKAXE)
        .item()
        .tab(EIOCreativeTabs.BLOCKS)
        .build()
        .register();

    // endregion

    // region Fused Quartz/Glass

    public static final Map<GlassIdentifier, GlassBlocks> GLASS_BLOCKS = fillGlassMap();

    private static Map<GlassIdentifier, GlassBlocks> fillGlassMap() {
        Map<GlassIdentifier, GlassBlocks> map = new HashMap<>();
        for (GlassLighting lighting : GlassLighting.values()) {
            for (GlassCollisionPredicate collisionPredicate : GlassCollisionPredicate.values()) {
                for (Boolean isFused : new boolean[] { false, true }) {
                    GlassIdentifier identifier = new GlassIdentifier(lighting, collisionPredicate, isFused);
                    map.put(identifier, new GlassBlocks(REGISTRATE, identifier));
                }
            }
        }
        return map;
    }

    // endregion

    // region Miscellaneous

    public static final RegiliteBlock<ChainBlock> SOUL_CHAIN = REGISTRATE
        .block("soul_chain", ChainBlock::new)
        .properties(props -> props
            .requiresCorrectToolForDrops()
            .strength(5.0F, 6.0F)
            .sound(SoundType.CHAIN)
            .noOcclusion()
            .sound(SoundType.METAL)
            .mapColor(MapColor.NONE))
        .tag(BlockTags.NEEDS_IRON_TOOL)
        .tag(BlockTags.MINEABLE_WITH_PICKAXE)
        .blockstate((ctx, prov) -> {
            var model = prov
                .models()
                .withExistingParent(ctx.getName(), prov.mcLoc("block/chain"))
                .renderType(prov.mcLoc("cutout_mipped"))
                .texture("particle", prov.blockTexture(ctx.get()))
                .texture("all", prov.blockTexture(ctx.get()));

            prov.axisBlock(ctx.get(), model, model);
        })
        .item()
        .model((ctx, prov) -> prov.generated(ctx, prov.modLoc("item/soul_chain")))
        .tab(EIOCreativeTabs.BLOCKS)
        .build()
        .register();

    public static final RegiliteBlock<ColdFireBlock> COLD_FIRE = REGISTRATE
        .block("cold_fire", ColdFireBlock::new)
        .properties(props -> BlockBehaviour.Properties.copy(Blocks.FIRE).noLootTable())
        .blockstate((ctx, prov) -> {
            // This generates the models used for the blockstate in our resources.
            // One day we may bother to datagen that file.
            String[] toCopy = { "fire_floor0", "fire_floor1", "fire_side0", "fire_side1", "fire_side_alt0", "fire_side_alt1", "fire_up0", "fire_up1",
                "fire_up_alt0", "fire_up_alt1" };

            for (String name : toCopy) {
                prov.models().withExistingParent(name, prov.mcLoc(name)).renderType("cutout");
            }
        })
        .register();

    // endregion

    // region Pressure Plates

    public static final RegiliteBlock<EIOPressurePlateBlock> DARK_STEEL_PRESSURE_PLATE = pressurePlateBlock("dark_steel_pressure_plate",
        EnderIO.loc("block/dark_steel_pressure_plate"), EIOPressurePlateBlock.PLAYER, false);

    public static final RegiliteBlock<EIOPressurePlateBlock> SILENT_DARK_STEEL_PRESSURE_PLATE = pressurePlateBlock("silent_dark_steel_pressure_plate",
        EnderIO.loc("block/dark_steel_pressure_plate"), EIOPressurePlateBlock.PLAYER, true);

    public static final RegiliteBlock<EIOPressurePlateBlock> SOULARIUM_PRESSURE_PLATE = pressurePlateBlock("soularium_pressure_plate",
        EnderIO.loc("block/soularium_pressure_plate"), EIOPressurePlateBlock.HOSTILE_MOB, false);

    public static final RegiliteBlock<EIOPressurePlateBlock> SILENT_SOULARIUM_PRESSURE_PLATE = pressurePlateBlock("silent_soularium_pressure_plate",
        EnderIO.loc("block/soularium_pressure_plate"), EIOPressurePlateBlock.HOSTILE_MOB, true);

    public static final RegiliteBlock<SilentPressurePlateBlock> SILENT_OAK_PRESSURE_PLATE = silentPressurePlateBlock(
        (PressurePlateBlock) Blocks.OAK_PRESSURE_PLATE);

    public static final RegiliteBlock<SilentPressurePlateBlock> SILENT_ACACIA_PRESSURE_PLATE = silentPressurePlateBlock(
        (PressurePlateBlock) Blocks.ACACIA_PRESSURE_PLATE);

    public static final RegiliteBlock<SilentPressurePlateBlock> SILENT_DARK_OAK_PRESSURE_PLATE = silentPressurePlateBlock(
        (PressurePlateBlock) Blocks.DARK_OAK_PRESSURE_PLATE);

    public static final RegiliteBlock<SilentPressurePlateBlock> SILENT_SPRUCE_PRESSURE_PLATE = silentPressurePlateBlock(
        (PressurePlateBlock) Blocks.SPRUCE_PRESSURE_PLATE);

    public static final RegiliteBlock<SilentPressurePlateBlock> SILENT_BIRCH_PRESSURE_PLATE = silentPressurePlateBlock(
        (PressurePlateBlock) Blocks.BIRCH_PRESSURE_PLATE);

    public static final RegiliteBlock<SilentPressurePlateBlock> SILENT_JUNGLE_PRESSURE_PLATE = silentPressurePlateBlock(
        (PressurePlateBlock) Blocks.JUNGLE_PRESSURE_PLATE);

    public static final RegiliteBlock<SilentPressurePlateBlock> SILENT_CRIMSON_PRESSURE_PLATE = silentPressurePlateBlock(
        (PressurePlateBlock) Blocks.CRIMSON_PRESSURE_PLATE);

    public static final RegiliteBlock<SilentPressurePlateBlock> SILENT_WARPED_PRESSURE_PLATE = silentPressurePlateBlock(
        (PressurePlateBlock) Blocks.WARPED_PRESSURE_PLATE);

    public static final RegiliteBlock<SilentPressurePlateBlock> SILENT_STONE_PRESSURE_PLATE = silentPressurePlateBlock(
        (PressurePlateBlock) Blocks.STONE_PRESSURE_PLATE);

    public static final RegiliteBlock<SilentPressurePlateBlock> SILENT_POLISHED_BLACKSTONE_PRESSURE_PLATE = silentPressurePlateBlock(
        (PressurePlateBlock) Blocks.POLISHED_BLACKSTONE_PRESSURE_PLATE);

    public static final RegiliteBlock<SilentWeightedPressurePlateBlock> SILENT_HEAVY_WEIGHTED_PRESSURE_PLATE = silentWeightedPressurePlateBlock(
        (WeightedPressurePlateBlock) Blocks.HEAVY_WEIGHTED_PRESSURE_PLATE);

    public static final RegiliteBlock<SilentWeightedPressurePlateBlock> SILENT_LIGHT_WEIGHTED_PRESSURE_PLATE = silentWeightedPressurePlateBlock(
        (WeightedPressurePlateBlock) Blocks.LIGHT_WEIGHTED_PRESSURE_PLATE);

    // endregion

    // region resetting levers

    public static final RegiliteBlock<ResettingLeverBlock> RESETTING_LEVER_FIVE = resettingLeverBlock("resetting_lever_five", 5, false);

    public static final RegiliteBlock<ResettingLeverBlock> RESETTING_LEVER_FIVE_INV = resettingLeverBlock("resetting_lever_five_inv", 5, true);

    public static final RegiliteBlock<ResettingLeverBlock> RESETTING_LEVER_TEN = resettingLeverBlock("resetting_lever_ten", 10, false);

    public static final RegiliteBlock<ResettingLeverBlock> RESETTING_LEVER_TEN_INV = resettingLeverBlock("resetting_lever_ten_inv", 10, true);

    public static final RegiliteBlock<ResettingLeverBlock> RESETTING_LEVER_THIRTY = resettingLeverBlock("resetting_lever_thirty", 30, false);

    public static final RegiliteBlock<ResettingLeverBlock> RESETTING_LEVER_THIRTY_INV = resettingLeverBlock("resetting_lever_thirty_inv", 30, true);

    public static final RegiliteBlock<ResettingLeverBlock> RESETTING_LEVER_SIXTY = resettingLeverBlock("resetting_lever_sixty", 60, false);

    public static final RegiliteBlock<ResettingLeverBlock> RESETTING_LEVER_SIXTY_INV = resettingLeverBlock("resetting_lever_sixty_inv", 60, true);

    public static final RegiliteBlock<ResettingLeverBlock> RESETTING_LEVER_THREE_HUNDRED = resettingLeverBlock("resetting_lever_three_hundred", 300, false);

    public static final RegiliteBlock<ResettingLeverBlock> RESETTING_LEVER_THREE_HUNDRED_INV = resettingLeverBlock("resetting_lever_three_hundred_inv", 300, true);

    // endregion

    private static final List<NonNullSupplier<? extends Block>> PAINTED = new ArrayList<>();

    public static final RegiliteBlock<PaintedFenceBlock> PAINTED_FENCE = paintedBlock("painted_fence", PaintedFenceBlock::new, Blocks.OAK_FENCE,
        BlockTags.WOODEN_FENCES, BlockTags.MINEABLE_WITH_AXE).register();

    public static final RegiliteBlock<PaintedFenceGateBlock> PAINTED_FENCE_GATE = paintedBlock("painted_fence_gate", PaintedFenceGateBlock::new,
        Blocks.OAK_FENCE_GATE, BlockTags.FENCE_GATES, BlockTags.MINEABLE_WITH_AXE).register();

    public static final RegiliteBlock<PaintedSandBlock> PAINTED_SAND = paintedBlock("painted_sand", PaintedSandBlock::new, Blocks.SAND, BlockTags.SAND,
        BlockTags.MINEABLE_WITH_SHOVEL).register();

    public static final RegiliteBlock<PaintedStairBlock> PAINTED_STAIRS = paintedBlock("painted_stairs", PaintedStairBlock::new, Blocks.OAK_STAIRS, Direction.WEST,
        BlockTags.WOODEN_STAIRS, BlockTags.MINEABLE_WITH_AXE).register();

    public static final RegiliteBlock<PaintedCraftingTableBlock> PAINTED_CRAFTING_TABLE = paintedBlock("painted_crafting_table", PaintedCraftingTableBlock::new,
        Blocks.CRAFTING_TABLE, BlockTags.MINEABLE_WITH_AXE).register();

    public static final RegiliteBlock<PaintedRedstoneBlock> PAINTED_REDSTONE_BLOCK = paintedBlock("painted_redstone_block", PaintedRedstoneBlock::new,
        Blocks.REDSTONE_BLOCK, BlockTags.MINEABLE_WITH_PICKAXE).register();

    public static final RegiliteBlock<PaintedTrapDoorBlock> PAINTED_TRAPDOOR = paintedBlock("painted_trapdoor", PaintedTrapDoorBlock::new, Blocks.OAK_TRAPDOOR,
        BlockTags.WOODEN_TRAPDOORS, BlockTags.MINEABLE_WITH_AXE).register();

    public static final RegiliteBlock<PaintedWoodenPressurePlateBlock> PAINTED_WOODEN_PRESSURE_PLATE = paintedBlock("painted_wooden_pressure_plate",
        PaintedWoodenPressurePlateBlock::new, Blocks.OAK_PRESSURE_PLATE, BlockTags.WOODEN_PRESSURE_PLATES, BlockTags.MINEABLE_WITH_AXE).register();

    public static final RegiliteBlock<PaintedSlabBlock> PAINTED_SLAB = paintedBlock("painted_slab", PaintedSlabBlock::new, PaintedSlabBlockItem::new,
        Blocks.OAK_SLAB, BlockTags.WOODEN_SLABS, BlockTags.MINEABLE_WITH_AXE).loot(DecorLootTable::paintedSlab).register();

    public static final RegiliteBlock<SinglePaintedBlock> PAINTED_GLOWSTONE = paintedBlock("painted_glowstone", SinglePaintedBlock::new,
        Blocks.GLOWSTONE).register();

    // endregion

    // region Light

    public static final RegiliteBlock<Light> LIGHT = lightBlock("light", s -> new Light(s, false));
    public static final RegiliteBlock<Light> LIGHT_INVERTED = lightBlock("light_inverted", s -> new Light(s, true));
    public static final RegiliteBlock<PoweredLight> POWERED_LIGHT = lightBlock("powered_light", s -> new PoweredLight(s, false, false));
    public static final RegiliteBlock<PoweredLight> POWERED_LIGHT_INVERTED = lightBlock("powered_light_inverted", s -> new PoweredLight(s, true, false));
    public static final RegiliteBlock<PoweredLight> POWERED_LIGHT_WIRELESS = lightBlock("powered_light_wireless", s -> new PoweredLight(s, false, true));
    public static final RegiliteBlock<PoweredLight> POWERED_LIGHT_INVERTED_WIRELESS = lightBlock("powered_light_inverted_wireless",
        s -> new PoweredLight(s, true, true));

    public static final RegiliteBlock<LightNode> LIGHT_NODE = REGISTRATE
        .block("light_node", LightNode::new)
        .blockstate((ctx, prov) -> prov.simpleBlock(ctx.get(), prov.models().withExistingParent("light_node", "block/air")))
        .initialProperties(() -> Blocks.AIR)
        .properties(p -> p.lightLevel(l -> 15).noLootTable().noCollission().noOcclusion())
        .register();

    public static final RegiliteBlock<EnderSkullBlock> ENDERMAN_HEAD = REGISTRATE
        .block("enderman_head", EnderSkullBlock::new)
        .properties(properties -> properties.instrument(NoteBlockInstrument.SKELETON).strength(1.0F).pushReaction(PushReaction.DESTROY))
        .blockstate((ctx, prov) -> prov.simpleBlock(ctx.get(), prov.models().getExistingFile(prov.mcLoc("block/skull"))))
        .item((enderSkullBlock, properties) -> new EnderSkullBlockItem(enderSkullBlock, properties, Direction.DOWN))
        .tab(EIOCreativeTabs.MAIN)
        .model((ctx, prov) -> prov.withExistingParent(ctx.getName(), "item/template_skull"))
        .build()
        .register();

    public static final RegiliteBlock<WallEnderSkullBlock> WALL_ENDERMAN_HEAD = REGISTRATE
        .block("wall_enderman_head", WallEnderSkullBlock::new)
        .properties(properties -> properties.strength(1.0F).lootFrom(ENDERMAN_HEAD).pushReaction(PushReaction.DESTROY))
        .blockstate((ctx, prov) -> prov.simpleBlock(ctx.get(), prov.models().getExistingFile(prov.mcLoc("block/skull"))))
        .setData(LANG, noop())
        .register();

    private static RegiliteBlock<Block> metalBlock(String name, TagKey<Block> blockTag, TagKey<Item> itemTag) {
        return BLOCK_REGISTRY
            .registerBlock(name, Block::new, BlockBehaviour.Properties.of().sound(SoundType.METAL).mapColor(MapColor.METAL).strength(5, 6).requiresCorrectToolForDrops())
            .addBlockTags(
                BlockTags.NEEDS_STONE_TOOL,
                BlockTags.MINEABLE_WITH_PICKAXE,
                blockTag
            )
            .createBlockItem(ITEM_REGISTRY)
            .setTab(EIOCreativeTabs.BLOCKS)
            .addBlockItemTags(itemTag)
            .finishBlockItem();
    }

    private static RegiliteBlock<Block> chassisBlock(String name) {
        return BLOCK_REGISTRY
            .registerBlock(name, Block::new, BlockBehaviour.Properties.of().noOcclusion().sound(SoundType.METAL).mapColor(MapColor.METAL).strength(5, 6))
            .setBlockStateProvider((prov, ctx) -> prov.simpleBlock(ctx,
                prov.models().cubeAll(name, prov.blockTexture(ctx)).renderType(prov.mcLoc("translucent"))))
            .addBlockTags(
                BlockTags.NEEDS_STONE_TOOL,
                BlockTags.MINEABLE_WITH_PICKAXE
            )
            .createBlockItem(ITEM_REGISTRY)
            .setTab(EIOCreativeTabs.BLOCKS)
            .finishBlockItem();
    }

    private static RegiliteBlock<EIOPressurePlateBlock> pressurePlateBlock(String name, ResourceLocation texture, EIOPressurePlateBlock.Detector type,
        boolean silent) {

        return BLOCK_REGISTRY
            .registerBlock(name, props -> new EIOPressurePlateBlock(props, type, silent),
                BlockBehaviour.Properties.of().strength(5, 6).mapColor(MapColor.METAL))
            .setBlockStateProvider((prov, ctx) -> {
                BlockModelProvider modProv = prov.models();
                ModelFile dm = modProv.withExistingParent(name + "_down", prov.mcLoc("block/pressure_plate_down")).texture("texture", texture);
                ModelFile um = modProv.withExistingParent(name, prov.mcLoc("block/pressure_plate_up")).texture("texture", texture);

                VariantBlockStateBuilder vb = prov.getVariantBuilder(ctx);
                vb.partialState().with(PressurePlateBlock.POWERED, true).addModels(new ConfiguredModel(dm));
                vb.partialState().with(PressurePlateBlock.POWERED, false).addModels(new ConfiguredModel(um));
            })
            .addBlockTags(BlockTags.NEEDS_STONE_TOOL, BlockTags.MINEABLE_WITH_PICKAXE, BlockTags.PRESSURE_PLATES)
            .createBlockItem(ITEM_REGISTRY)
            .setTab(EIOCreativeTabs.BLOCKS)
            .finishBlockItem();
    }

    private static RegiliteBlock<SilentPressurePlateBlock> silentPressurePlateBlock(final PressurePlateBlock block) {
        ResourceLocation upModelLoc = Objects.requireNonNull(BuiltInRegistries.BLOCK.getKey(block));
        ResourceLocation downModelLoc = new ResourceLocation(upModelLoc.getNamespace(), upModelLoc.getPath() + "_down");

        BlockBuilder<SilentPressurePlateBlock, Registrate> bb = REGISTRATE.block("silent_" + upModelLoc.getPath(),
            props -> new SilentPressurePlateBlock(block));
        bb.tag(BlockTags.MINEABLE_WITH_PICKAXE, BlockTags.PRESSURE_PLATES);

        bb.blockstate((ctx, prov) -> {
            VariantBlockStateBuilder vb = prov.getVariantBuilder(ctx.get());
            vb.partialState().with(PressurePlateBlock.POWERED, true).addModels(new ConfiguredModel(prov.models().getExistingFile(downModelLoc)));
            vb.partialState().with(PressurePlateBlock.POWERED, false).addModels(new ConfiguredModel(prov.models().getExistingFile(upModelLoc)));
        });

        var itemBuilder = bb.item();
        itemBuilder.model((ctx, prov) -> prov.withExistingParent(ctx.getName(), upModelLoc));
        itemBuilder.tab(EIOCreativeTabs.BLOCKS);
        bb = itemBuilder.build();

        return bb.register();
    }

    private static RegiliteBlock<SilentWeightedPressurePlateBlock> silentWeightedPressurePlateBlock(WeightedPressurePlateBlock block) {
        ResourceLocation upModelLoc = Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(block));
        ResourceLocation downModelLoc = new ResourceLocation(upModelLoc.getNamespace(), upModelLoc.getPath() + "_down");

        BlockBuilder<SilentWeightedPressurePlateBlock, Registrate> bb = REGISTRATE.block("silent_" + upModelLoc.getPath(),
            props -> new SilentWeightedPressurePlateBlock(block));

        bb.blockstate((ctx, prov) -> prov.getVariantBuilder(ctx.get()).forAllStates(blockState -> {
            if (blockState.getValue(WeightedPressurePlateBlock.POWER) == 0) {
                return new ConfiguredModel[] { new ConfiguredModel(prov.models().getExistingFile(upModelLoc)) };
            }
            return new ConfiguredModel[] { new ConfiguredModel(prov.models().getExistingFile(downModelLoc)) };
        }));
        bb.tag(BlockTags.MINEABLE_WITH_PICKAXE, BlockTags.PRESSURE_PLATES);

        var itemBuilder = bb.item();
        itemBuilder.model((ctx, prov) -> prov.withExistingParent(ctx.getName(), upModelLoc));
        itemBuilder.tab(EIOCreativeTabs.BLOCKS);
        bb = itemBuilder.build();

        return bb.register();
    }

    private static RegiliteBlock<ResettingLeverBlock> resettingLeverBlock(String name, int duration, boolean inverted) {

        BlockBuilder<ResettingLeverBlock, Registrate> bb = REGISTRATE.block(name, props -> new ResettingLeverBlock(duration, inverted));
        String durLab = "(" + (duration >= 60 ? duration / 60 : duration) + " " + (duration == 60 ? "minute" : duration > 60 ? "minutes" : "seconds") + ")";
        bb.lang("Resetting Lever " + (inverted ? "Inverted " : "") + durLab);

        bb.blockstate((ctx, prov) -> {

            BlockModelProvider modProv = prov.models();
            ModelFile.ExistingModelFile baseModel = modProv.getExistingFile(prov.mcLoc("block/lever"));
            ModelFile.ExistingModelFile onModel = modProv.getExistingFile(prov.mcLoc("block/lever_on"));

            VariantBlockStateBuilder vb = prov.getVariantBuilder(ctx.get());

            vb.forAllStates(blockState -> {
                ModelFile.ExistingModelFile model = blockState.getValue(ResettingLeverBlock.POWERED) ? onModel : baseModel;
                int rotationX =
                    blockState.getValue(LeverBlock.FACE) == AttachFace.CEILING ? 180 : blockState.getValue(LeverBlock.FACE) == AttachFace.WALL ? 90 : 0;
                Direction f = blockState.getValue(LeverBlock.FACING);
                int rotationY = f.get2DDataValue() * 90;
                if (blockState.getValue(LeverBlock.FACE) != AttachFace.CEILING) {
                    rotationY = (rotationY + 180) % 360;
                }
                return new ConfiguredModel[] { new ConfiguredModel(model, rotationX, rotationY, false) };
            });
        });

        var ib = bb.item().tab(EIOCreativeTabs.BLOCKS);
        ib.model((ctx, prov) -> prov.withExistingParent(ctx.getName(), prov.mcLoc("item/lever")));
        bb = ib.build();
        return bb.register();
    }

    public static final RegiliteBlock<IndustrialInsulationBlock> INDUSTRIAL_INSULATION = REGISTRATE
        .block("industrial_insulation_block", IndustrialInsulationBlock::new)
        .initialProperties(() -> Blocks.SPONGE)
        .lang("Industrial Insulation")
        .item()
        .tab(EIOCreativeTabs.BLOCKS)
        .build()
        .register();

    @SafeVarargs
    private static <T extends Block> RegiliteBlock<T> paintedBlock(String name, Function<BlockBehaviour.Properties, T> blockFactory,
        Block copyFrom, TagKey<Block>... tags) {
        return paintedBlock(name, blockFactory, copyFrom, null, tags);
    }

    @SafeVarargs
    private static <T extends Block> RegiliteBlock<T> paintedBlock(String name, Function<BlockBehaviour.Properties, T> blockFactory,
        Block copyFrom, @Nullable Direction itemTextureRotation, TagKey<Block>... tags) {
        return paintedBlock(name, blockFactory, PaintedBlockItem::new, copyFrom, itemTextureRotation, tags);
    }

    @SafeVarargs
    private static <T extends Block> RegiliteBlock<T> paintedBlock(String name, Function<BlockBehaviour.Properties, T> blockFactory,
        BiFunction<? super T, Item.Properties, ? extends BlockItem> itemFactory, Block copyFrom, TagKey<Block>... tags) {
        return paintedBlock(name, blockFactory, itemFactory, copyFrom, null, tags);
    }

    @SafeVarargs
    private static <T extends Block> RegiliteBlock<T> paintedBlock(String name, Function<BlockBehaviour.Properties, T> blockFactory,
        BiFunction<? super T, Item.Properties, ? extends BlockItem> itemFactory, Block copyFrom, @Nullable Direction itemTextureRotation,
        TagKey<Block>... tags) {

        var block = BLOCK_REGISTRY
            .registerBlock(name, blockFactory, BlockBehaviour.Properties.copy(copyFrom).noCollission())
            .setBlockStateProvider((prov, ctx) -> EIOBlockState.paintedBlock(name, prov, ctx, copyFrom, itemTextureRotation))
            .setColorSupplier(PaintedBlockColor.INSTANCE)
            .setLootTable(DecorLootTable::withPaint)
            .addBlockTags(tags);

        // TODO: Create block item with props.
        /*ITEM_REGISTRY.createBlockItem(itemFactory)
            .color(() -> PaintedBlockColor::new)
            .build()*/

        return block;
    }

    public static <T extends Block> RegiliteBlock<T> lightBlock(String name, Function<BlockBehaviour.Properties, T> blockFactory) {
        return BLOCK_REGISTRY
            .registerBlock(name, blockFactory, BlockBehaviour.Properties.of().sound(SoundType.METAL).mapColor(MapColor.METAL).lightLevel(l -> {
                if (l.getValue(Light.ENABLED)) {
                    return 15;
                }
                return 0;
            }))
            .setBlockStateProvider(EIOBlockState::lightBlock)
            .createBlockItem(ITEM_REGISTRY)
            .setModelProvider((prov, ctx) -> prov.withExistingParent(name, "block/button_inventory"))
            .setTab(EIOCreativeTabs.BLOCKS)
            .finishBlockItem();
    }

    public static void register() {}

}

package net.dyzygy.dizzyalloys.item;

import net.dyzygy.dizzyalloys.DizzyAlloys;
import net.dyzygy.dizzyalloys.block.ModBlock;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, DizzyAlloys.MODID);

    public static final Supplier<CreativeModeTab> DIZZY_ALLOYS_TAB = CREATIVE_MODE_TAB.register("dizzyalloys_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.RAW_TIN.get()))
                    .title(Component.translatable("creativetab.dizzyalloys.dizzy_alloys_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.RAW_TIN);
                        output.accept(ModItems.TIN_INGOT);
                        output.accept(ModBlock.TIN_BLOCK);
                        output.accept(ModBlock.DEEPSLATE_TIN_ORE);
                        output.accept(ModBlock.TIN_ORE);
                        output.accept(ModItems.RAW_NICKEL);
                        output.accept(ModItems.NICKEL_INGOT);
                        output.accept(ModBlock.NICKEL_BLOCK);
                        output.accept(ModBlock.DEEPSLATE_NICKEL_ORE);
                        output.accept(ModBlock.NICKEL_ORE);
                        output.accept(ModItems.BAUXITE_DUST);
                        output.accept(ModItems.ALUMINUM_INGOT);
                        output.accept(ModBlock.ALUMINUM_BLOCK);
                        output.accept(ModBlock.NETHERRACK_BAUXITE_ORE);
                        output.accept(ModBlock.DEEPSLATE_BAUXITE_ORE);
                        output.accept(ModBlock.BAUXITE_ORE);
                        output.accept(ModItems.RAW_COBALT);
                        output.accept(ModItems.COBALT_INGOT);
                        output.accept(ModBlock.COBALT_BLOCK);
                        output.accept(ModBlock.DEEPSLATE_COBALT_ORE);
                        output.accept(ModBlock.COBALT_ORE);
                        output.accept(ModItems.RAW_SILVER);
                        output.accept(ModItems.SILVER_INGOT);
                        output.accept(ModBlock.SILVER_BLOCK);
                        output.accept(ModBlock.DEEPSLATE_SILVER_ORE);
                        output.accept(ModItems.RAW_ZINC);
                        output.accept(ModItems.ZINC_INGOT);
                        output.accept(ModBlock.ZINC_BLOCK);
                        output.accept(ModBlock.ZINC_ORE);
                        output.accept(ModBlock.DEEPSLATE_ZINC_ORE);


                        output.accept(ModItems.CHISEL);
                        output.accept(ModBlock.DYMALLOY_ALTAR);

                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }

}

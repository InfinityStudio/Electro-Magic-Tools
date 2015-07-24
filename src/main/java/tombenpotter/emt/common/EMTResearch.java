/*******************************************************************************
 * Copyright (c) 2014 Tombenpotter.
 * All rights reserved. 
 *
 * This program and the accompanying materials are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at http://www.gnu.org/licenses/gpl.html
 *
 * This class was made by Tombenpotter and is distributed as a part of the Electro-Magic Tools mod.
 * Electro-Magic Tools is a derivative work on Thaumcraft 4 (c) Azanor 2012.
 * http://www.minecraftforum.net/topic/1585216-
 ******************************************************************************/

package tombenpotter.emt.common;

import ic2.api.item.IC2Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.research.ResearchCategories;
import thaumcraft.api.research.ResearchItem;
import thaumcraft.api.research.ResearchPage;
import tombenpotter.emt.common.RecipeRegistry;
import tombenpotter.emt.common.blocks.BlockRegistry;
import tombenpotter.emt.common.items.ItemRegistry;
import tombenpotter.emt.common.util.ConfigHandler;
import tombenpotter.emt.common.util.EMTResearchItem;
import tombenpotter.emt.common.util.ResearchAspects;

public class EMTResearch {

	public static void addResearchTab(){
        ResourceLocation background = new ResourceLocation("thaumcraft", "textures/gui/gui_researchback.png");
        ResearchCategories.registerCategory("EMT", new ResourceLocation("electromagictools:textures/misc/emt.png"), background);
    }

    public static void addResearch() {
        ResearchItem research;
        String text;

        /** Research that can't be disabled **/
        text = "1";
        research = new EMTResearchItem("Electric Magic Tools", "EMT", new AspectList(), 0, 0, 0, new ResourceLocation("electromagictools:textures/misc/emt.png")).setRound().setAutoUnlock().registerResearchItem();
        research.setPages(new ResearchPage(text));

        text = "1";
        research = new EMTResearchItem("Diamond Chainsaw", "EMT", new AspectList(), 5, -6, 0, new ItemStack(ItemRegistry.diamondChainsaw)).setRound().setAutoUnlock().registerResearchItem();
        research.setPages(new ResearchPage(text), new ResearchPage(RecipeRegistry.diamondChainsaw));

        text = "1";
        research = new EMTResearchItem("Thaumium Plate", "EMT", new AspectList(), 6, -6, 0, new ItemStack(ItemRegistry.itemEMTItems, 1, 5)).setRound().setAutoUnlock().registerResearchItem();
        research.setPages(new ResearchPage(text), new ResearchPage(RecipeRegistry.thaumiumPlate));

        text = "1";
        research = new EMTResearchItem("Macerating Native Ore Clusters", "EMT", new AspectList(), 5, -7, 0, IC2Items.getItem("smallGoldDust")).setRound().setAutoUnlock().registerResearchItem();
        research.setPages(new ResearchPage(text));

        text = "1";
        research = new EMTResearchItem("The Legend", "EMT", new AspectList(), 5, -5, 0, new ItemStack(ItemRegistry.taintedThorHammer)).setRound().setAutoUnlock().registerResearchItem();
        research.setPages(new ResearchPage(text));

        text = "1";
        research = new EMTResearchItem("Lightning Summoner", "EMT", new AspectList(), 6, -5, 0, new ItemStack(ItemRegistry.itemEMTItems, 1, 6)).setRound().setAutoUnlock().registerResearchItem();
        research.setPages(new ResearchPage(text));

        text = "1";
        research = new EMTResearchItem("The One Ring", "EMT", new AspectList(), 6, -7, 0, new ItemStack(ItemRegistry.onering)).setRound().setAutoUnlock().registerResearchItem();
        research.setPages(new ResearchPage(text));

        text = "1";
        research = new EMTResearchItem("Feather Wings", "EMT", new AspectList(), 0, 2, 0, new ItemStack(ItemRegistry.featherWing)).setRound().setAutoUnlock().registerResearchItem();
        research.setPages(new ResearchPage(text), new ResearchPage(RecipeRegistry.rubberBall), new ResearchPage(RecipeRegistry.ductTape), new ResearchPage(RecipeRegistry.featherMesh), new ResearchPage(RecipeRegistry.cardboard), new ResearchPage(RecipeRegistry.featherWing), new ResearchPage(RecipeRegistry.featherWings));

        /** Research that can be disabled **/
        if (ConfigHandler.thaumiumDrillResearch == false) {
            text = "1";
            research = new EMTResearchItem("Thaumium Drill", "EMT", ResearchAspects.thaumiumDrillResearch, -1, -2, 1, new ItemStack(ItemRegistry.thaumiumDrill)).setSecondary().setParents("Electric Magic Tools").setConcealed().registerResearchItem();
            research.setPages(new ResearchPage(text), new ResearchPage(RecipeRegistry.thaumiumDrill));
        }

        if (ConfigHandler.thaumiumChainsawResearch == false) {
            text = "1";
            research = new EMTResearchItem("Thaumium Chainsaw", "EMT", ResearchAspects.thaumiumChainsawResearch, -2, -2, 1, new ItemStack(ItemRegistry.thaumiumChainsaw)).setSecondary().setParents("Electric Magic Tools").setConcealed().registerResearchItem();
            research.setPages(new ResearchPage(text), new ResearchPage(RecipeRegistry.thaumiumChainsaw));
        }

        if (ConfigHandler.electricGooglesResearch == false) {
            text = "1";
            research = new EMTResearchItem("Electric Goggles", "EMT", ResearchAspects.electricGogglesResearch, 1, -2, 1, new ItemStack(ItemRegistry.electricGoggles)).setSecondary().setParents("Electric Magic Tools").setConcealed().registerResearchItem();
            research.setPages(new ResearchPage(text), new ResearchPage(RecipeRegistry.electricGoggles));
        }

        if (ConfigHandler.electricGooglesResearch == false) {
            if (ConfigHandler.nanoGooglesResearch == false) {
                text = "1";
                research = new EMTResearchItem("Nanosuit Goggles of Revealing", "EMT", ResearchAspects.thaumicNanoHelmet, 2, -2, 2, new ItemStack(ItemRegistry.nanoThaumicHelmet)).setParents("Electric Goggles").setConcealed().registerResearchItem();
                research.setPages(new ResearchPage(text), new ResearchPage(RecipeRegistry.thaumicNanoHelmet));
            }
        }

        if (ConfigHandler.electricGooglesResearch == false) {
            if (ConfigHandler.nanoGooglesResearch == false) {
                if (ConfigHandler.quantumGooglesResearch == false) {
                    text = "1";
                    research = new EMTResearchItem("Quantum Goggles of Revealing", "EMT", ResearchAspects.thaumicQuantumHelmet, 3, -2, 3, new ItemStack(ItemRegistry.quantumThaumicHelmet)).setParents("Nanosuit Goggles of Revealing").setConcealed().registerResearchItem();
                    research.setPages(new ResearchPage(text), new ResearchPage(RecipeRegistry.thaumicQuantumHelmet));
                }
            }
        }

        if (ConfigHandler.ironOmnitoolResearch == false) {
            text = "1";
            research = new EMTResearchItem("Iron Omnitool", "EMT", new AspectList(), -2, 0, 0, new ItemStack(ItemRegistry.ironOmnitool)).setParents("Electric Magic Tools").setRound().setAutoUnlock().registerResearchItem();
            research.setPages(new ResearchPage(text), new ResearchPage(RecipeRegistry.ironOmnitool));
        }

        if (ConfigHandler.ironOmnitoolResearch == false) {
            if (ConfigHandler.diamondOmnitoolResearch == false) {
                text = "1";
                research = new EMTResearchItem("Diamond Omnitool", "EMT", ResearchAspects.diamondOmnitoolResearch, -4, 0, 1, new ItemStack(ItemRegistry.diamondOmnitool)).setSecondary().setParents("Electric Magic Tools").setConcealed().registerResearchItem();
                research.setPages(new ResearchPage(text), new ResearchPage(RecipeRegistry.diamondOmnitool), new ResearchPage(RecipeRegistry.ironOmnitoolToDiamond));
            }
        }

        if (ConfigHandler.thaumiumDrillResearch == false && ConfigHandler.thaumiumChainsawResearch == false) {
            if (ConfigHandler.thaumiumOmnitoolResearch == false) {
                text = "1";
                research = new EMTResearchItem("Thaumium Omnitool", "EMT", ResearchAspects.thaumiumOmnitoolResearch, -6, 0, 2, new ItemStack(ItemRegistry.thaumiumOmnitool)).setParentsHidden("Thaumium Drill", "Thaumium Chainsaw").setParents("Diamond Omnitool").setConcealed().registerResearchItem();
                research.setPages(new ResearchPage(text), new ResearchPage(RecipeRegistry.thaumiumOmnitool), new ResearchPage(RecipeRegistry.diamondOmnitoolToThaumium));
            }
        }

        if (ConfigHandler.explosionFocusResearch == false) {
            text = "1";
            research = new EMTResearchItem("Explosion Focus", "EMT", ResearchAspects.laserFocusResearch, 2, 3, 2, new ItemStack(ItemRegistry.explosionFocus)).setParents("Electric Magic Tools").setConcealed().registerResearchItem();
            research.setPages(new ResearchPage(text), new ResearchPage(RecipeRegistry.explosionFocus));
        }

        if (ConfigHandler.christmasFocusResearch == false) {
            text = "1";
            research = new EMTResearchItem("Kris-tmas Focus", "EMT", ResearchAspects.christmasFocusResearch, 3, 3, 1, new ItemStack(ItemRegistry.christmasFocus)).setSecondary().setParents("Electric Magic Tools").setConcealed().registerResearchItem();
            research.setPages(new ResearchPage(text), new ResearchPage(RecipeRegistry.christmasFocus));
        }

        if (ConfigHandler.shieldFocusResearch == false) {
            text = "1";
            research = new EMTResearchItem("Shield Focus", "EMT", ResearchAspects.shieldFocusResearch, 4, 3, 2, new ItemStack(ItemRegistry.shieldFocus)).setParents("Electric Magic Tools").setConcealed().registerResearchItem();
            research.setPages(new ResearchPage(text), new ResearchPage(RecipeRegistry.shieldFocus));
        }

        if (ConfigHandler.shieldFocusResearch == false) {
            if (ConfigHandler.shieldBlockResearch == false) {
                text = "1";
                research = new EMTResearchItem("Shield Block", "EMT", ResearchAspects.shieldBlockResearch, 4, 5, 1, new ItemStack(BlockRegistry.shield)).setSecondary().setParents("Shield Focus").setConcealed().registerResearchItem();
                research.setPages(new ResearchPage(text), new ResearchPage(RecipeRegistry.shieldBlock));
            }
        }

        if (ConfigHandler.potentiaGeneratorResearch == false) {
            text = "1";
            research = new EMTResearchItem("Potentia Generator", "EMT", ResearchAspects.potentiaGeneratorResearch, -2, 3, 3, new ItemStack(BlockRegistry.essentiaGens, 1, 0)).setParents("Electric Magic Tools").setConcealed().registerResearchItem();
            research.setPages(new ResearchPage(text), new ResearchPage(RecipeRegistry.potentiaGenerator));
        }

        if (ConfigHandler.potentiaGeneratorResearch == false) {
            if (ConfigHandler.ignisGeneratorResearch == false) {
                text = "1";
                research = new EMTResearchItem("Ignis Generator", "EMT", ResearchAspects.ignisGeneratorResearch, -3, 4, 1, new ItemStack(BlockRegistry.essentiaGens, 1, 1)).setSecondary().setParents("Potentia Generator").setConcealed().registerResearchItem();
                research.setPages(new ResearchPage(text), new ResearchPage(RecipeRegistry.ignisGenerator));
            }
        }

        if (ConfigHandler.potentiaGeneratorResearch == false) {
            if (ConfigHandler.auramGeneratorResearch == false) {
                text = "1";
                research = new EMTResearchItem("Auram Generator", "EMT", ResearchAspects.auramGeneratorResearch, -1, 4, 1, new ItemStack(BlockRegistry.essentiaGens, 1, 2)).setSecondary().setParents("Potentia Generator").setConcealed().registerResearchItem();
                research.setPages(new ResearchPage(text), new ResearchPage(RecipeRegistry.auramGenerator));
            }
        }

        if (ConfigHandler.potentiaGeneratorResearch == false) {
            if (ConfigHandler.arborGeneratorResearch == false) {
                text = "1";
                research = new EMTResearchItem("Arbor Generator", "EMT", ResearchAspects.arborGeneratorResearch, -2, 5, 1, new ItemStack(BlockRegistry.essentiaGens, 1, 3)).setSecondary().setParents("Potentia Generator").setConcealed().registerResearchItem();
                research.setPages(new ResearchPage(text), new ResearchPage(RecipeRegistry.arborGenerator));
            }
        }

        if (ConfigHandler.potentiaGeneratorResearch == false) {
            if (ConfigHandler.aerGeneratorResearch == false) {
                text = "1";
                research = new EMTResearchItem("Aer Generator", "EMT", ResearchAspects.aerGenerator, -2, 6, 1, new ItemStack(BlockRegistry.essentiaGens, 1, 4)).setSecondary().setParents("Potentia Generator").setConcealed().registerResearchItem();
                research.setPages(new ResearchPage(text), new ResearchPage(RecipeRegistry.aerGenerator));
            }
        }

        if (ConfigHandler.potentiaGeneratorResearch == false) {
            if (ConfigHandler.wandChargingSationResearch == false) {
                text = "1";
                research = new EMTResearchItem("Industrial Wand Charging Station", "EMT", ResearchAspects.wandCharger, -4, 2, 3, new ItemStack(BlockRegistry.emtMachines, 1, 0)).setParents("Potentia Generator").registerResearchItem();
                research.setPages(new ResearchPage(text), new ResearchPage(RecipeRegistry.wandRecharger));
            }
        }

        if (ConfigHandler.thaumiumChainsawResearch == false) {
            if (ConfigHandler.streamChainsawResearch == false) {
                text = "1";
                research = new EMTResearchItem("Chainsaw of the Stream", "EMT", ResearchAspects.streamChainsawResearch, -3, -4, 3, new ItemStack(ItemRegistry.streamChainsaw)).setParents("Thaumium Chainsaw").registerResearchItem();
                research.setPages(new ResearchPage(text), new ResearchPage(RecipeRegistry.streamChainsaw));
            }
        }

        if (ConfigHandler.thaumiumDrillResearch == false) {
            if (ConfigHandler.rockbreakerDrillResearch == false) {
                text = "1";
                research = new EMTResearchItem("Drill of the Rockbreaker", "EMT", ResearchAspects.rockbreakerDrillResearch, 0, -4, 3, new ItemStack(ItemRegistry.rockbreakerDrill)).setParents("Thaumium Drill").registerResearchItem();
                research.setPages(new ResearchPage(text), new ResearchPage(RecipeRegistry.rockbreakerDrill));
            }
        }

        if (ConfigHandler.tinyUraniumResearch == false) {
            text = "1";
            research = new EMTResearchItem("Tiny Uranium", "EMT", ResearchAspects.tinyUraniumResearch, -5, -5, 1, IC2Items.getItem("Uran238")).setSecondary().setParentsHidden("Electric Magic Tools").setConcealed().registerResearchItem();
            research.setPages(new ResearchPage(text), new ResearchPage(RecipeRegistry.tinyUranium));
        }

        if (ConfigHandler.thorHammerResearch == false) {
            text = "1";
            research = new EMTResearchItem("Mjolnir", "EMT", ResearchAspects.thorHammerResearch, -5, 5, 3, new ItemStack(ItemRegistry.thorHammer)).setParentsHidden("Electric Magic Tools").setConcealed().registerResearchItem();
            research.setPages(new ResearchPage(text), new ResearchPage(RecipeRegistry.thorHammer));
        }

        if (ConfigHandler.thorHammerResearch == false) {
            if (ConfigHandler.superchargedThorHammerResearch == false) {
                text = "1";
                research = new EMTResearchItem("Supercharged Mjolnir", "EMT", ResearchAspects.superchargedThorHammerResearch, -6, 6, 3, new ItemStack(ItemRegistry.electricThorHammer)).setParents("Mjolnir").registerResearchItem();
                research.setPages(new ResearchPage(text), new ResearchPage(RecipeRegistry.superchargedThorHammer));
            }
        }

        if (ConfigHandler.compressedSolarsResearch == false) {
            text = "1";
            research = new EMTResearchItem("Compressed Solars", "EMT", ResearchAspects.compressedSolars, -4, -5, 2, new ItemStack(BlockRegistry.emtSolars)).setParentsHidden("Potentia Generator").setConcealed().registerResearchItem();
            research.setPages(new ResearchPage(text), new ResearchPage(RecipeRegistry.compressedSolar), new ResearchPage(RecipeRegistry.doubleCompressedSolar), new ResearchPage(RecipeRegistry.tripleCompressedSolar));
        }

        if (ConfigHandler.compressedSolarsResearch == false) {
            if (ConfigHandler.solarHelmetResearch == false) {
                text = "1";
                research = new EMTResearchItem("Solar Helmet of Revealing", "EMT", ResearchAspects.solarHelmetRevealing, -2, -5, 1, new ItemStack(ItemRegistry.solarHelmetRevealing)).setSecondary().setParents("Compressed Solars").setParentsHidden("Quantum Goggles of Revealing").registerResearchItem();
                research.setPages(new ResearchPage(text), new ResearchPage(RecipeRegistry.solarHelmetRevealing));
            }
        }

        if (ConfigHandler.electricBootsResearch == false) {
            text = "1";
            research = new EMTResearchItem("Electric Boots of the Traveller", "EMT", ResearchAspects.electricBootsTravel, 2, 0, 1, new ItemStack(ItemRegistry.electricBootsTraveller)).setSecondary().setParents("Electric Magic Tools").setConcealed().registerResearchItem();
            research.setPages(new ResearchPage(text), new ResearchPage(RecipeRegistry.electricBootsTravel));
        }

        if (ConfigHandler.electricBootsResearch == false) {
            if (ConfigHandler.nanoBootsResearch == false) {
                text = "1";
                research = new EMTResearchItem("Nano Boots of the Traveller", "EMT", ResearchAspects.nanoBootsTravel, 4, 0, 2, new ItemStack(ItemRegistry.nanoBootsTraveller)).setParents("Electric Boots of the Traveller").setConcealed().registerResearchItem();
                research.setPages(new ResearchPage(text), new ResearchPage(RecipeRegistry.nanoBootsTravel));
            }
        }

        if (ConfigHandler.electricBootsResearch == false) {
            if (ConfigHandler.nanoBootsResearch == false) {
                if (ConfigHandler.quantumBootsResearch == false) {
                    text = "1";
                    research = new EMTResearchItem("Quantum Boots of the Traveller", "EMT", ResearchAspects.quantumBootsTravel, 6, 0, 3, new ItemStack(ItemRegistry.quantumBootsTraveller)).setParents("Nano Boots of the Traveller").setConcealed().registerResearchItem();
                    research.setPages(new ResearchPage(text), new ResearchPage(RecipeRegistry.quantumBootsTravel));
                }
            }
        }

        if (ConfigHandler.electricScribingToolsResearch == false) {
            text = "1";
            research = new EMTResearchItem("Electric Scribing Tools", "EMT", ResearchAspects.electricScribingTools, -6, -5, 1, new ItemStack(ItemRegistry.electricScribingTools)).setSecondary().setParentsHidden("Electric Magic Tools").setConcealed().registerResearchItem();
            research.setPages(new ResearchPage(text), new ResearchPage(RecipeRegistry.electricScribingTools));
        }

        if (ConfigHandler.etherealProcessorResearch == false) {
            text = "1";
            research = new EMTResearchItem("Etheral Processor", "EMT", ResearchAspects.etherealProcessor, -1, 2, 2, new ItemStack(BlockRegistry.emtMachines, 1, 1)).setParents("Electric Magic Tools").setConcealed().registerResearchItem();
            research.setPages(new ResearchPage(text), new ResearchPage(RecipeRegistry.etheralProcessor));
        }

        if (ConfigHandler.compressedSolarsResearch == false) {
            if (ConfigHandler.waterSolarsResearch == false) {
                text = "1";
                research = new EMTResearchItem("Water Infused Solar Panels", "EMT", ResearchAspects.waterSolars, -7, -7, 1, new ItemStack(BlockRegistry.emtSolars, 1, 3)).setSecondary().setParents("Compressed Solars").registerResearchItem();
                research.setPages(new ResearchPage(text), new ResearchPage(RecipeRegistry.waterSolar), new ResearchPage(RecipeRegistry.doubleWaterSolar), new ResearchPage(RecipeRegistry.tripleWaterSolar));
            }
        }

        if (ConfigHandler.compressedSolarsResearch == false) {
            if (ConfigHandler.darkSolarsResearch == false) {
                text = "1";
                research = new EMTResearchItem("Entropy Infused Solar Panels", "EMT", ResearchAspects.darkSolars, -8, -6, 1, new ItemStack(BlockRegistry.emtSolars, 1, 6)).setSecondary().setParents("Compressed Solars").registerResearchItem();
                research.setPages(new ResearchPage(text), new ResearchPage(RecipeRegistry.darkSolar), new ResearchPage(RecipeRegistry.doubleDarkSolar), new ResearchPage(RecipeRegistry.tripleDarkSolar));
            }
        }

        if (ConfigHandler.compressedSolarsResearch == false) {
            if (ConfigHandler.orderSolarsResearch == false) {
                text = "1";
                research = new EMTResearchItem("Order Infused Solar Panels", "EMT", ResearchAspects.orderSolars, -6, -8, 1, new ItemStack(BlockRegistry.emtSolars, 1, 9)).setSecondary().setParents("Compressed Solars").registerResearchItem();
                research.setPages(new ResearchPage(text), new ResearchPage(RecipeRegistry.orderSolar), new ResearchPage(RecipeRegistry.doubleOrderSolar), new ResearchPage(RecipeRegistry.tripleOrderSolar));
            }
        }

        if (ConfigHandler.compressedSolarsResearch == false) {
            if (ConfigHandler.fireSolarsResearch == false) {
                text = "1";
                research = new EMTResearchItem("Fire Infused Solar Panels", "EMT", ResearchAspects.fireSolars, -5, -7, 1, new ItemStack(BlockRegistry.emtSolars, 1, 12)).setSecondary().setParents("Compressed Solars").registerResearchItem();
                research.setPages(new ResearchPage(text), new ResearchPage(RecipeRegistry.fireSolar), new ResearchPage(RecipeRegistry.doubleFireSolar), new ResearchPage(RecipeRegistry.tripleFireSolar));
            }
        }

        if (ConfigHandler.compressedSolarsResearch == false) {
            if (ConfigHandler.airSolarsResearch == false) {
                text = "1";
                research = new EMTResearchItem("Air Infused Solar Panels", "EMT", ResearchAspects.airSolars, -4, -6, 1, new ItemStack(BlockRegistry.emtSolars, 1, 15)).setSecondary().setParents("Compressed Solars").registerResearchItem();
                research.setPages(new ResearchPage(text), new ResearchPage(RecipeRegistry.airSolar), new ResearchPage(RecipeRegistry.doubleAirSolar), new ResearchPage(RecipeRegistry.tripleAirSolar));
            }
        }

        if (ConfigHandler.compressedSolarsResearch == false) {
            if (ConfigHandler.earthSolarsResearch == false) {
                text = "1";
                research = new EMTResearchItem("Earth Infused Solar Panels", "EMT", ResearchAspects.earthSolars, -6, -7, 1, new ItemStack(BlockRegistry.emtSolars2, 1, 2)).setSecondary().setParents("Compressed Solars").registerResearchItem();
                research.setPages(new ResearchPage(text), new ResearchPage(RecipeRegistry.earthSolar), new ResearchPage(RecipeRegistry.doubleEarthSolar), new ResearchPage(RecipeRegistry.tripleEarthSolar));
            }
        }

        if (ConfigHandler.uuMInfusionResearch == false) {
            text = "1";
            research = new EMTResearchItem("UU-Matter Infusion", "EMT", ResearchAspects.uuMInfusion, 5, 5, 3, new ItemStack(ItemRegistry.itemEMTItems, 1, 15)).setParentsHidden("Electric Magic Tools").setConcealed().registerResearchItem();
            research.setPages(new ResearchPage(text), new ResearchPage(RecipeRegistry.charcoalToCoal), new ResearchPage(RecipeRegistry.glowstoneDustToBlock), new ResearchPage(RecipeRegistry.stoneBricksToIronOre), new ResearchPage(RecipeRegistry.arcaneStoneToCopperOre), new ResearchPage(RecipeRegistry.arcaneStoneBricksToTinOre), new ResearchPage(RecipeRegistry.amberBlockToLeadOre), new ResearchPage(RecipeRegistry.amberBricksToUraniumOre), new ResearchPage(RecipeRegistry.shardToResin), new ResearchPage(RecipeRegistry.shardToRedstone), new ResearchPage(RecipeRegistry.shardToLapis), new ResearchPage(RecipeRegistry.ironToGold), new ResearchPage(RecipeRegistry.goldToDiamond), new ResearchPage(RecipeRegistry.diamondToUranium), new ResearchPage(RecipeRegistry.uraniumToIridium));
        }

        if (ConfigHandler.portableNodeResarch == false) {
            text = "1";
            research = new EMTResearchItem("Portable Node", "EMT", ResearchAspects.portableNode, 2, 5, 3, new ItemStack(BlockRegistry.portableNode)).setParents("Electric Magic Tools").setConcealed().registerResearchItem();
            research.setPages(new ResearchPage(text), new ResearchPage(RecipeRegistry.portableNode));
        }

        if (ConfigHandler.electricHoeGrowthResearch == false) {
            text = "1";
            research = new EMTResearchItem("Electric Hoe of Growth", "EMT", ResearchAspects.electricHoeGrowth, -1, -4, 2, new ItemStack(ItemRegistry.electricHoeGrowth)).setParents("Electric Magic Tools").setConcealed().registerResearchItem();
            research.setPages(new ResearchPage(text), new ResearchPage(RecipeRegistry.electricHoeGrowth));
        }

        if (ConfigHandler.chargeFocusResearch == false) {
            text = "1";
            research = new EMTResearchItem("Wand Focus: Charging", "EMT", ResearchAspects.chargeFocus, 5, 3, 2, new ItemStack(ItemRegistry.chargeFocus)).setParents("Electric Magic Tools").setConcealed().registerResearchItem();
            research.setPages(new ResearchPage(text), new ResearchPage(RecipeRegistry.chargeFocus));
        }

        if (ConfigHandler.wandChargeFocusResearch == false) {
            text = "1";
            research = new EMTResearchItem("Wand Focus: Wand Charging", "EMT", ResearchAspects.wandChargeFocus, 7, 3, 3, new ItemStack(ItemRegistry.wandChargeFocus)).setParents("Wand Focus: Charging").setConcealed().registerResearchItem();
            research.setPages(new ResearchPage(text), new ResearchPage(RecipeRegistry.wandChargeFocus));
        }

        if (ConfigHandler.inventoryChargingRing == false) {
            text = "1";
            research = new EMTResearchItem("Inventory Charging Ring", "EMT", ResearchAspects.inventoryChargingRing, 0, -5, 3, new ItemStack(ItemRegistry.emtBauble, 1, 1)).setParentsHidden("Electric Magic Tools").setConcealed().registerResearchItem();
            research.setPages(new ResearchPage(text), new ResearchPage(RecipeRegistry.inventoryChargingRing));
        }

        if (ConfigHandler.armorChargingRing == false) {
            text = "1";
            research = new EMTResearchItem("Armor Charging Ring", "EMT", ResearchAspects.armorChargingRing, 0, -7, 3, new ItemStack(ItemRegistry.emtBauble, 1, 0)).setSecondary().setParents("Inventory Charging Ring").setConcealed().registerResearchItem();
            research.setPages(new ResearchPage(text), new ResearchPage(RecipeRegistry.armorChargingRing));
        }

        if (ConfigHandler.thaumiumWingResearch == false) {
            text = "1";
            research = new EMTResearchItem("Thaumium Reinforced Wings", "EMT", ResearchAspects.thaumiumWing, 0, 4, 0, new ItemStack(ItemRegistry.thaumiumWing)).setSecondary().setParents("Feather Wings").setConcealed().registerResearchItem();
            research.setPages(new ResearchPage(text), new ResearchPage(RecipeRegistry.thaumiumWing), new ResearchPage(RecipeRegistry.thaumiumWings));
        }

        if (ConfigHandler.nanoWingResearch == false) {
            text = "1";
            research = new EMTResearchItem("Nanosuit Wings", "EMT", ResearchAspects.nanoWing, 0, 6, 2, new ItemStack(ItemRegistry.nanoWing)).setParents("Thaumium Reinforced Wings").setConcealed().registerResearchItem();
            research.setPages(new ResearchPage(text), new ResearchPage(RecipeRegistry.nanoWings));
        }

        if (ConfigHandler.quantumWingsResearch == false) {
            text = "1";
            research = new EMTResearchItem("Quantum Wings", "EMT", ResearchAspects.quantumWing, 0, 8, 3, new ItemStack(ItemRegistry.quantumWing)).setParents("Nanosuit Wings").setConcealed().registerResearchItem();
            research.setPages(new ResearchPage(text), new ResearchPage(RecipeRegistry.quantumWings));
        }
        
        text = "1";
        research = new EMTResearchItem("InfusedQuantumArmor", "EMT", ResearchAspects.quantumWing, 0, 10, 4, new ItemStack(ItemRegistry.quantumArmor)).setParents("Quantum Wings").setConcealed().registerResearchItem();
        research.setPages(new ResearchPage(text), new ResearchPage(RecipeRegistry.infusedQuantumArmor));
    }
}
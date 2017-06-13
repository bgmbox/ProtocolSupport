package protocolsupport.protocol.legacyremapper.pe;

import java.util.EnumMap;

import protocolsupport.protocol.typeremapper.id.RemappingTable.ArrayBasedIdRemappingTable;
import protocolsupport.protocol.utils.types.NetworkEntityType;

public class PEDataValues {

	private static final EnumMap<NetworkEntityType, Integer> livingEntityType = new EnumMap<>(NetworkEntityType.class);
	static {
		livingEntityType.put(NetworkEntityType.WITHER_SKELETON, 48);
		livingEntityType.put(NetworkEntityType.WOLF, 14);
		livingEntityType.put(NetworkEntityType.RABBIT, 18);
		livingEntityType.put(NetworkEntityType.CHICKEN, 10);
		livingEntityType.put(NetworkEntityType.COW, 11);
		livingEntityType.put(NetworkEntityType.SHEEP, 13);
		livingEntityType.put(NetworkEntityType.PIG, 12);
		livingEntityType.put(NetworkEntityType.MUSHROOM_COW, 16);
		livingEntityType.put(NetworkEntityType.SHULKER, 54);
		livingEntityType.put(NetworkEntityType.GUARDIAN, 49);
		livingEntityType.put(NetworkEntityType.ENDERMITE, 55);
		livingEntityType.put(NetworkEntityType.WITCH, 45);
		livingEntityType.put(NetworkEntityType.BAT, 19);
		livingEntityType.put(NetworkEntityType.WITHER, 52);
		livingEntityType.put(NetworkEntityType.ENDER_DRAGON, 53);
		livingEntityType.put(NetworkEntityType.MAGMA_CUBE, 42);
		livingEntityType.put(NetworkEntityType.BLAZE, 43);
		livingEntityType.put(NetworkEntityType.SILVERFISH, 39);
		livingEntityType.put(NetworkEntityType.CAVE_SPIDER, 40);
		livingEntityType.put(NetworkEntityType.ENDERMAN, 38);
		livingEntityType.put(NetworkEntityType.ZOMBIE_PIGMAN, 36);
		livingEntityType.put(NetworkEntityType.GHAST, 41);
		livingEntityType.put(NetworkEntityType.SLIME, 37);
		livingEntityType.put(NetworkEntityType.ZOMBIE, 32);
		livingEntityType.put(NetworkEntityType.SPIDER, 35);
		livingEntityType.put(NetworkEntityType.SKELETON, 34);
		livingEntityType.put(NetworkEntityType.CREEPER, 33);
		livingEntityType.put(NetworkEntityType.VILLAGER, 15);
		livingEntityType.put(NetworkEntityType.MULE, 25);
		livingEntityType.put(NetworkEntityType.DONKEY, 24);
		livingEntityType.put(NetworkEntityType.ZOMBIE_HORSE, 27);
		livingEntityType.put(NetworkEntityType.SKELETON_HORSE, 26);
		livingEntityType.put(NetworkEntityType.ZOMBIE_VILLAGER, 44);
		livingEntityType.put(NetworkEntityType.HUSK, 47);
		livingEntityType.put(NetworkEntityType.SQUID, 17);
		livingEntityType.put(NetworkEntityType.STRAY, 46);
		livingEntityType.put(NetworkEntityType.POLAR_BEAR, 28);
		livingEntityType.put(NetworkEntityType.ELDER_GUARDIAN, 50);
		livingEntityType.put(NetworkEntityType.COMMON_HORSE, 23);
		livingEntityType.put(NetworkEntityType.IRON_GOLEM, 20);
		livingEntityType.put(NetworkEntityType.OCELOT, 22);
		livingEntityType.put(NetworkEntityType.SNOWMAN, 21);
	}

	public static int getLivingEntityTypeId(NetworkEntityType type) {
		return livingEntityType.get(type);
	}

	public static final ArrayBasedIdRemappingTable BLOCK_ID = new ArrayBasedIdRemappingTable(4096 * 16);
	private static void registerBlockRemap(int from, int to) {
		for (int i = 0; i < 16; i++) {
			BLOCK_ID.setRemap((from << 4) | i, (to << 4) | i);
		}
	}
	static {
		// Concrete
		registerBlockRemap(251, 236);
		// Concrete Powder
		registerBlockRemap(252, 237);
		// Chrous Plant
		registerBlockRemap(240, 199);
		// Observer
		registerBlockRemap(218, 251);
		// Stained Glass - The block ID already exists in PE but the block apperence isn't implemented yet (1.1.1?)
		registerBlockRemap(95, 241);
		// ...Glazed Terracota
		// Purple
		registerBlockRemap(245, 219);
		// White
		registerBlockRemap(235, 220);
		// Orange
		registerBlockRemap(236, 221);
		// Magenta
		registerBlockRemap(237, 222);
		// Light Blue
		registerBlockRemap(238, 223);
		// Yellow
		registerBlockRemap(239, 224);
		// Lime
		registerBlockRemap(240, 225);
		// Pink
		registerBlockRemap(241, 226);
		// Gray
		registerBlockRemap(242, 227);
		// Light Gray
		registerBlockRemap(243, 228);
		// Cyan
		registerBlockRemap(244, 229);
		// Blue
		registerBlockRemap(245, 231);
		// Brown
		registerBlockRemap(247, 232);
		// Green
		registerBlockRemap(248, 233);
		// Red
		registerBlockRemap(249, 234);
		// Black
		registerBlockRemap(250, 235);
		// Shulker Box
		registerBlockRemap(229, 218);
		// End Rod
		registerBlockRemap(198, 208);
		// Frosted Ice
		registerBlockRemap(212, 207);
		// Grass Path
		registerBlockRemap(208, 198);
		// Chain Command Block
		registerBlockRemap(211, 189);
		// Repeating Command Block
		registerBlockRemap(210, 188);
		// Activator Rail
		registerBlockRemap(157, 126);
		// Double Wooden Slab
		registerBlockRemap(43, 157);
		// Dropper
		registerBlockRemap(158, 125);
	}

}
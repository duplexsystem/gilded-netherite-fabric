package me.scaldings.gildednetherite.render.shield;

import me.scaldings.gildednetherite.GildedNetherite;
import net.fabricmc.fabric.api.event.client.ClientSpriteRegistryCallback;
import net.minecraft.client.texture.SpriteAtlasTexture;
import net.minecraft.client.util.SpriteIdentifier;
import net.minecraft.util.Identifier;

public class ItemTextures {
    public static final SpriteIdentifier GILDED_SHIELD_BASE = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier(GildedNetherite.MOD_ID, "entity/gilded_shield_base"));
    public static final SpriteIdentifier GILDED_SHIELD_BASE_NO_PATTERN = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier(GildedNetherite.MOD_ID, "entity/gilded_shield_base_nopattern"));

    public static void register() {
        ClientSpriteRegistryCallback.event(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE).register(ItemTextures::registerShieldTextures);
    }

    public static void registerShieldTextures(SpriteAtlasTexture atlas, ClientSpriteRegistryCallback.Registry registry) {
        registry.register(GILDED_SHIELD_BASE.getTextureId());
        registry.register(GILDED_SHIELD_BASE_NO_PATTERN.getTextureId());
    }
}

package dk.nelind.avail;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.fabricmc.api.ClientModInitializer;

@Environment(EnvType.CLIENT)
public class Avail implements ClientModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("avail");

	@Override
	public void onInitializeClient() {
		LOGGER.info("Initializing Avail");
	}
}

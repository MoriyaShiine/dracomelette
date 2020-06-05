package moriyashiine.dracomelette.mixin.connector;

import org.spongepowered.asm.mixin.Mixins;
import org.spongepowered.asm.mixin.connect.IMixinConnector;

public class DCMixinConnector implements IMixinConnector {
	@Override
	public void connect() {
		Mixins.addConfiguration("assets/dracomelette/dracomelette.mixins.json");
	}
}
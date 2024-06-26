package mont.bettersneaking.mixin;

import net.minecraft.client.render.Camera;
import net.minecraft.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Camera.class)
public class CameraMixin {
	@Shadow
	private float cameraY;
	@Shadow
	private Entity focusedEntity;

	@Inject(method = "updateEyeHeight", at = @At("HEAD"))
	public void updateEyeHeight(CallbackInfo ci) {
		if (this.focusedEntity != null) {
			this.cameraY = this.focusedEntity.getStandingEyeHeight();
		}
	}
}
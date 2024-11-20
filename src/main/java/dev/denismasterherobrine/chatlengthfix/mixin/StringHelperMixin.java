package dev.denismasterherobrine.chatlengthfix.mixin;

import net.minecraft.util.StringUtil;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(StringUtil.class)
public class StringHelperMixin {
    @Inject(method = "truncateStringIfNecessary(Ljava/lang/String;IZ)Ljava/lang/String;", at = @At(value = "HEAD"), cancellable = true)
    private static void truncateStringIfNecessary(String text, int maxLength, boolean addEllipsis, CallbackInfoReturnable<String> cir) {
        if (text.startsWith("/")) {
            cir.setReturnValue(text);
        }
    }
}

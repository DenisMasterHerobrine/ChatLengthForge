package dev.denismasterherobrine.chatlengthfix.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.util.StringUtil;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(StringUtil.class)
public class StringHelperMixin {
    @WrapOperation(method = "Lnet/minecraft/util/StringUtil;truncateStringIfNecessary(Ljava/lang/String;IZ)Ljava/lang/String;",  at={@org.spongepowered.asm.mixin.injection.At(value="HEAD", target="Lnet/minecraft/util/StringUtil;truncateStringIfNecessary(Ljava/lang/String;IZ)Ljava/lang/String;")})
    private static String truncateStringIfNecessary(String text, int maxLength, boolean addEllipsis, Operation<String> original) {
        if (text.startsWith("/")) {
            return text;
        }

        return original.call(text, maxLength, addEllipsis);
    }
}

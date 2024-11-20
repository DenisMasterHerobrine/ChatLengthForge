package dev.denismasterherobrine.chatlengthfix.mixin;

import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.screens.ChatScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ChatScreen.class)
public class ChatScreenMixin {
    @Shadow protected EditBox input;

    @Inject(method = "onEdited(Ljava/lang/String;)V", at = @org.spongepowered.asm.mixin.injection.At(value = "HEAD"))
    private void modifyChatLengthIfCommand(String chatText, CallbackInfo ci) {
        if (this.input.getValue().startsWith("/")) {
            this.input.setMaxLength(Integer.MAX_VALUE);
        } else {
            this.input.setMaxLength(256);
        }
    }
}

package net.silthus.template;

import co.aikar.commands.Locales;
import co.aikar.commands.MessageType;
import co.aikar.commands.PaperCommandManager;
import lombok.Getter;
import lombok.experimental.Accessors;
import net.silthus.template.config.Configuration;
import org.bukkit.ChatColor;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;
import java.util.Locale;

public class Main extends JavaPlugin {

    @Getter
    @Accessors(fluent = true)
    private static Main instance;
    @Getter
    private static PaperCommandManager commandManager;
    @Getter
    private static Configuration configuration;

    @Override
    public void onEnable() {
        instance = this;
        configuration = new Configuration();
        setupCommands();
    }

    private void setupCommands() {
        commandManager = new PaperCommandManager(this);
        commandManager.enableUnstableAPI("help");

        commandManager.setFormat(MessageType.HELP, ChatColor.DARK_AQUA, ChatColor.AQUA, ChatColor.GRAY, ChatColor.DARK_GRAY);
    }

    // see https://github.com/aikar/commands/wiki/Locales
    private void loadCommandLocales(PaperCommandManager commandManager) {
        try {
            saveResource("lang_en.yml", true);
            saveResource("lang_es.yml", true);
            commandManager.getLocales().setDefaultLocale(Locale.ENGLISH);
            commandManager.getLocales().loadYamlLanguageFile("lang_en.yml", Locale.ENGLISH);
            commandManager.getLocales().loadYamlLanguageFile("lang_es.yml", Locales.SPANISH);
            // this will detect the client locale and use it where possible
            commandManager.usePerIssuerLocale(true);
        } catch (IOException | InvalidConfigurationException e) {
            getLogger().severe("Failed to load language config 'lang_en.yml': " + e.getMessage());
            e.printStackTrace();
        }
    }
}

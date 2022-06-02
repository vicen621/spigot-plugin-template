package net.silthus.template.config;

import de.exlll.configlib.configs.yaml.BukkitYamlConfiguration;
import de.exlll.configlib.format.FieldNameFormatters;
import net.silthus.template.Main;

import java.io.File;

public class Configuration extends BukkitYamlConfiguration {

    public Configuration() {
        super(
                new File(Main.instance().getDataFolder(), "config.yml").toPath(),
                BukkitYamlProperties.builder().setFormatter(FieldNameFormatters.LOWER_UNDERSCORE).build()
        );
    }
}

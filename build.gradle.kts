import org.spongepowered.gradle.plugin.config.PluginLoaders
import org.spongepowered.plugin.metadata.model.PluginDependency

plugins {
    `java-library`
    id("org.spongepowered.gradle.plugin") version "2.2.0"
}

repositories {
    mavenCentral()
}

sponge {
    apiVersion("11.0.0")
    license("MIT")
    loader {
        name(PluginLoaders.JAVA_PLAIN)
        version("1.0")
    }
    plugin("example") {
        entrypoint("com.example.ExamplePlugin")
        description("This is an example plugin")
        dependency("spongeapi") {
            loadOrder(PluginDependency.LoadOrder.AFTER)
            optional(false)
        }
    }
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

configurations.spongeRuntime {
    resolutionStrategy {
        eachDependency {
            if (target.name == "spongevanilla") {
                useVersion("1.20.6-11.0.0")
            }
        }
    }
}

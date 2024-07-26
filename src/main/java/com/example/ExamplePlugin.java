package com.example;

import com.google.inject.Inject;
import org.apache.logging.log4j.Logger;
import org.spongepowered.api.Server;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.lifecycle.StartedEngineEvent;
import org.spongepowered.plugin.builtin.jvm.Plugin;

@Plugin("example")
public class ExamplePlugin {
    @Inject
    private Logger logger;

    @Listener
    public void onServerStart(StartedEngineEvent<Server> event) {
        logger.info("Hello from example plugin!");
    }
}

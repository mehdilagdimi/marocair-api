package com.mehdilagdimi.marocair_api.base;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.ext.ContextResolver;
import jakarta.ws.rs.ext.Provider;
import jakarta.ws.rs.ext.Providers;
import org.glassfish.hk2.api.Factory;

//@Singleton
public class ObjectMapperFactory implements Factory<ObjectMapper> {

    @Context
    private final Providers providers;
    final ObjectMapper mapper = new ObjectMapper();

    @Inject
    public ObjectMapperFactory(@Context Providers providers) {
        this.providers = providers;
    }

    @Override
    public ObjectMapper provide() {
        ContextResolver<ObjectMapper> resolver = providers.getContextResolver(
                ObjectMapper.class, MediaType.APPLICATION_JSON_TYPE);
        if (resolver == null) { return mapper; }

        return resolver.getContext(null);
    }

    @Override
    public void dispose(ObjectMapper t) {}
}
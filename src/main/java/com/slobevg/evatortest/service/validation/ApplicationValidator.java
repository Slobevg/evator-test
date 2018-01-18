package com.slobevg.evatortest.service.validation;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.slobevg.evatortest.model.application.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.script.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

@Service
public class ApplicationValidator {

    private final ResourceLoader resourceLoader;
    private final ObjectMapper om;

    private ScriptEngine engine;

    @Autowired
    public ApplicationValidator(ResourceLoader resourceLoader, ObjectMapper om) {
        this.resourceLoader = resourceLoader;
        this.om = om;
    }

    @PostConstruct
    public void init() {
        om.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        engine = new ScriptEngineManager().getEngineByName("nashorn");
    }

    public Boolean validate(Application application) {
        Resource resource = resourceLoader.getResource("classpath:application-validation.js");
        try (InputStream is = resource.getInputStream();
            Reader reader = new InputStreamReader(is)) {
            engine.eval(reader);
            Invocable invocable = (Invocable) engine;
            String app = om.writeValueAsString(application);
            return (Boolean) invocable.invokeFunction("validate", app);
        } catch (ScriptException | IOException | NoSuchMethodException se) {
            se.printStackTrace();
        }
        return false;
    }
}

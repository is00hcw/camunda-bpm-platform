package org.camunda.bpm.engine.rest.util;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import org.camunda.bpm.engine.rest.impl.ProcessDefinitionServiceImpl;
import org.camunda.bpm.engine.rest.impl.ProcessInstanceServiceImpl;
import org.camunda.bpm.engine.rest.mapper.EngineQueryDtoReader;

public class TestWebApplication extends Application {

  @Override
  public Set<Class<?>> getClasses() {
    Set<Class<?>> classes = new HashSet<Class<?>>();
    classes.add(ProcessDefinitionServiceImpl.class);
    classes.add(ProcessInstanceServiceImpl.class);
    classes.add(EngineQueryDtoReader.class);
    return classes;
  }
}
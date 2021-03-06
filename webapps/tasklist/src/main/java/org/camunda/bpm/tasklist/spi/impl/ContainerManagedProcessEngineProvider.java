/* Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.camunda.bpm.tasklist.spi.impl;

import java.util.Set;

import org.camunda.bpm.BpmPlatform;
import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.rest.spi.ProcessEngineProvider;
import org.camunda.bpm.tasklist.spi.TasklistProcessEngineProvider;

public class ContainerManagedProcessEngineProvider implements ProcessEngineProvider, TasklistProcessEngineProvider {

  public ProcessEngine getDefaultProcessEngine() {
    return BpmPlatform.getDefaultProcessEngine();
  }

  public ProcessEngine getProcessEngine(String name) {
    return BpmPlatform.getProcessEngineService().getProcessEngine(name);
  }

  public Set<String> getProcessEngineNames() {
    return BpmPlatform.getProcessEngineService().getProcessEngineNames();
  }

}

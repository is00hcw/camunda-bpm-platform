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
package org.camunda.bpm.engine.rest.dto.runtime;

import java.net.URI;

import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import org.camunda.bpm.engine.rest.ProcessInstanceRestService;
import org.camunda.bpm.engine.rest.dto.AtomLink;
import org.camunda.bpm.engine.rest.dto.LinkableDto;
import org.camunda.bpm.engine.runtime.ProcessInstance;

public class ProcessInstanceDto extends LinkableDto {
  
  private String id;  
  private String definitionId;
  private String businessKey;
  private boolean ended;
  private boolean suspended;

  public String getId() {
    return id;
  }
  
  public String getDefinitionId() {
    return definitionId;
  }
  
  public String getBusinessKey() {
    return businessKey;
  }
  
  public boolean isEnded() {
    return ended;
  }
  
  public boolean isSuspended() {
    return suspended;
  }
  
  public static ProcessInstanceDto fromProcessInstance(ProcessInstance instance) {
    ProcessInstanceDto result = new ProcessInstanceDto();
    result.id = instance.getId();
    result.definitionId = instance.getProcessDefinitionId();
    result.businessKey = instance.getBusinessKey();
    result.ended = instance.isEnded();
    result.suspended = instance.isSuspended();
    return result;
  }

  @Override
  public AtomLink generateLink(UriInfo context, String action, String relation) {
    URI baseUri = context.getBaseUri();
    UriBuilder builder = UriBuilder.fromUri(baseUri).path(ProcessInstanceRestService.class).path("{id}");
    if (action != null) {
      builder.path(action);
    }
    
    URI linkUri = builder.build(id);
    AtomLink link = new AtomLink(relation, linkUri.toString());
    return link;
  }
}

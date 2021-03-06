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

package org.camunda.bpm.engine.impl.persistence;

import org.camunda.bpm.engine.impl.context.Context;
import org.camunda.bpm.engine.impl.db.DbSqlSession;
import org.camunda.bpm.engine.impl.db.PersistentObject;
import org.camunda.bpm.engine.impl.interceptor.Session;
import org.camunda.bpm.engine.impl.persistence.entity.AttachmentManager;
import org.camunda.bpm.engine.impl.persistence.entity.ByteArrayManager;
import org.camunda.bpm.engine.impl.persistence.entity.DeploymentManager;
import org.camunda.bpm.engine.impl.persistence.entity.ExecutionManager;
import org.camunda.bpm.engine.impl.persistence.entity.GroupManager;
import org.camunda.bpm.engine.impl.persistence.entity.HistoricActivityInstanceManager;
import org.camunda.bpm.engine.impl.persistence.entity.HistoricDetailManager;
import org.camunda.bpm.engine.impl.persistence.entity.HistoricProcessInstanceManager;
import org.camunda.bpm.engine.impl.persistence.entity.HistoricTaskInstanceManager;
import org.camunda.bpm.engine.impl.persistence.entity.HistoricVariableInstanceManager;
import org.camunda.bpm.engine.impl.persistence.entity.IdentityInfoManager;
import org.camunda.bpm.engine.impl.persistence.entity.IdentityLinkManager;
import org.camunda.bpm.engine.impl.persistence.entity.MembershipManager;
import org.camunda.bpm.engine.impl.persistence.entity.ProcessDefinitionManager;
import org.camunda.bpm.engine.impl.persistence.entity.ResourceManager;
import org.camunda.bpm.engine.impl.persistence.entity.TaskManager;
import org.camunda.bpm.engine.impl.persistence.entity.UserManager;
import org.camunda.bpm.engine.impl.persistence.entity.VariableInstanceManager;


/**
 * @author Tom Baeyens
 */
public abstract class AbstractManager implements Session {
  
  public void insert(PersistentObject persistentObject) {
    getDbSqlSession().insert(persistentObject);
  }

  public void delete(PersistentObject persistentObject) {
    getDbSqlSession().delete(persistentObject);
  }

  protected DbSqlSession getDbSqlSession() {
    return getSession(DbSqlSession.class);
  }

  protected <T> T getSession(Class<T> sessionClass) {
    return Context.getCommandContext().getSession(sessionClass);
  }

  protected DeploymentManager getDeploymentManager() {
    return getSession(DeploymentManager.class);
  }

  protected ResourceManager getResourceManager() {
    return getSession(ResourceManager.class);
  }
  
  protected ByteArrayManager getByteArrayManager() {
    return getSession(ByteArrayManager.class);
  }
  
  protected ProcessDefinitionManager getProcessDefinitionManager() {
    return getSession(ProcessDefinitionManager.class);
  }

  protected ExecutionManager getProcessInstanceManager() {
    return getSession(ExecutionManager.class);
  }

  protected TaskManager getTaskManager() {
    return getSession(TaskManager.class);
  }

  protected IdentityLinkManager getIdentityLinkManager() {
    return getSession(IdentityLinkManager.class);
  }

  protected VariableInstanceManager getVariableInstanceManager() {
    return getSession(VariableInstanceManager.class);
  }

  protected HistoricProcessInstanceManager getHistoricProcessInstanceManager() {
    return getSession(HistoricProcessInstanceManager.class);
  }

  protected HistoricDetailManager getHistoricDetailManager() {
    return getSession(HistoricDetailManager.class);
  }

  protected HistoricActivityInstanceManager getHistoricActivityInstanceManager() {
    return getSession(HistoricActivityInstanceManager.class);
  }
  
  protected HistoricVariableInstanceManager getHistoricVariableInstanceManager() {
    return getSession(HistoricVariableInstanceManager.class);
  }
  
  protected HistoricTaskInstanceManager getHistoricTaskInstanceManager() {
    return getSession(HistoricTaskInstanceManager.class);
  }
  
  protected UserManager getUserManager() {
    return getSession(UserManager.class);
  }
  
  protected GroupManager getGroupManager() {
    return getSession(GroupManager.class);
  }
  
  protected IdentityInfoManager getIdentityInfoManager() {
    return getSession(IdentityInfoManager.class);
  }
  
  protected MembershipManager getMembershipManager() {
    return getSession(MembershipManager.class);
  }
  
  protected AttachmentManager getAttachmentManager() {
    return getSession(AttachmentManager.class);
  }
  
  public void close() {
  }

  public void flush() {
  }
}

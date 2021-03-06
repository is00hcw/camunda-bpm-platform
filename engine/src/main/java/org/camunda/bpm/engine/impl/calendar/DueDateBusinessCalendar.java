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
package org.camunda.bpm.engine.impl.calendar;

import java.util.Date;

import org.camunda.bpm.engine.ProcessEngineException;
import org.joda.time.DateTime;


public class DueDateBusinessCalendar implements BusinessCalendar {

  public static final String NAME = "dueDate";
  
  public Date resolveDuedate(String duedate) {
    try {
      return DateTime.parse(duedate).toDate();

    } catch (Exception e) {
      throw new ProcessEngineException("couldn't resolve duedate: " + e.getMessage(), e);
    }
  }
}


/*
 * Copyright Contributors to the OpenCue Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package com.imageworks.spcue.dao.criteria;

import com.imageworks.spcue.AllocationEntity;
import com.imageworks.spcue.config.DatabaseEngine;
import com.imageworks.spcue.dao.criteria.postgres.HostSearch;
import com.imageworks.spcue.grpc.host.HostSearchCriteria;

public class HostSearchFactory {

    private DatabaseEngine dbEngine;

    public HostSearchInterface create(HostSearchCriteria criteria) {
        return new HostSearch(criteria);
    }

    public HostSearchInterface create(AllocationEntity allocEntity) {
        HostSearchInterface hostSearch = create(HostSearchInterface.criteriaFactory());
        hostSearch.filterByAlloc(allocEntity);
        return hostSearch;
    }

    public DatabaseEngine getDbEngine() {
        return dbEngine;
    }

    public void setDbEngine(DatabaseEngine dbEngine) {
        this.dbEngine = dbEngine;
    }
}

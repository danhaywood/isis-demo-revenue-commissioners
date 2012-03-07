/*
 *  Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */

package ie.revenue.isisdemo.corresp;

import ie.revenue.isisdemo.corresp.incoming.CustomerRequest;
import ie.revenue.isisdemo.corresp.incoming.IncomingCorrespondence;
import ie.revenue.isisdemo.customers.Customer;

import java.util.List;

import org.apache.isis.applib.AbstractFactoryAndRepository;
import org.apache.isis.applib.filter.Filters;

public class MailboxDefault extends AbstractFactoryAndRepository implements Mailbox {

    // {{ Id, iconName
    @Override
    public String getId() {
        return "mailbox";
    }

    public String iconName() {
        return "Mailbox";
    }
    // }}
    
	@SuppressWarnings("unchecked")
	@Override
	public List<CustomerRequest> pendingCorrespondence(final Customer customer) {
		return allMatches(CustomerRequest.class, 
				Filters.and(CorrespondenceAbstract.<IncomingCorrespondence>filterCorrespondenceFor(customer), IncomingCorrespondence.filterPendingAs(true)));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<IncomingCorrespondence> currentCorrespondence(Customer customer) {
		return allMatches(IncomingCorrespondence.class, 
				Filters.and(CorrespondenceAbstract.<IncomingCorrespondence>filterCorrespondenceFor(customer), IncomingCorrespondence.filterPendingAs(false), CorrespondenceAbstract.<IncomingCorrespondence>filterArchivedAs(false)));
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Correspondence> archivedCorrespondence(Customer customer) {
		return allMatches(Correspondence.class, 
				Filters.and(CorrespondenceAbstract.<Correspondence>filterCorrespondenceFor(customer), CorrespondenceAbstract.<Correspondence>filterArchivedAs(true)));
	}

	@Override
	public CorrespondenceHistory correspondenceHistoryFor(Customer customer) {
		return firstMatch(CorrespondenceHistory.class, Customer.<CorrespondenceHistory>filterTo(customer));
	}

	private int maxNoticeNumber = 0;
	@Override
	public int nextNoticeNumber() {
		return ++maxNoticeNumber;
	}

}

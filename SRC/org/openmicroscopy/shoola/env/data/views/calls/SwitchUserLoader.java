/*
 * org.openmicroscopy.shoola.env.data.views.calls.SwitchUserLoader 
 *
 *------------------------------------------------------------------------------
 *  Copyright (C) 2006-2010 University of Dundee. All rights reserved.
 *
 *
 * 	This program is free software; you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation; either version 2 of the License, or
 *  (at your option) any later version.
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *  
 *  You should have received a copy of the GNU General Public License along
 *  with this program; if not, write to the Free Software Foundation, Inc.,
 *  51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 *------------------------------------------------------------------------------
 */
package org.openmicroscopy.shoola.env.data.views.calls;

//Java imports
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;


//Third-party libraries

//Application-internal dependencies
import org.openmicroscopy.shoola.env.Agent;
import org.openmicroscopy.shoola.env.data.util.AgentSaveInfo;
import org.openmicroscopy.shoola.env.data.views.BatchCall;
import org.openmicroscopy.shoola.env.data.views.BatchCallTree;
import pojos.ExperimenterData;


/** 
 * Saves data before switching user's group.
 *
 * @author  Jean-Marie Burel &nbsp;&nbsp;&nbsp;&nbsp;
 * <a href="mailto:j.burel@dundee.ac.uk">j.burel@dundee.ac.uk</a>
 * @author Donald MacDonald &nbsp;&nbsp;&nbsp;&nbsp;
 * <a href="mailto:donald@lifesci.dundee.ac.uk">donald@lifesci.dundee.ac.uk</a>
 * @version 3.0
 * <small>
 * (<b>Internal version:</b> $Revision: $Date: $)
 * </small>
 * @since 3.0-Beta4
 */
public class SwitchUserLoader 
	extends BatchCallTree
{

	/** The experimenter to handle. */
	private ExperimenterData 			experimenter;
	
	/** The identifier of the group. */
	private long 						groupID;
	
	/** The data to save. */
	private Map<Agent, AgentSaveInfo> 	toSave;
	
	/** The partial result. */
	private Object						result;
	
	/**
	 * Saves the data.
	 * 
	 * @param agent The agent to handle.
	 * @param info	The data to save.
	 */
	private void saveAgentData(Agent agent, AgentSaveInfo info)
	{
		agent.save(info.getInstances());
		result = info;
	}
	
	/** Switches the user group. */
	private void switchUser()
	{
		try {
			context.getAdminService().changeExperimenterGroup(experimenter, 
					groupID);
		} catch (Exception e) {
			context.getLogger().error(this, 
        			"Cannot switch user's group: "+e.getMessage());
		}
		result = experimenter;
	}
	
	/**
     * Adds a {@link BatchCall} to the tree for each Agent.
     * The batch call simply invokes 
     * {@link #saveAgentData(Agent, AgentSaveInfo)}.
     * @see BatchCallTree#buildTree()
     */
    protected void buildTree()
    {
    	String description = "Saving Agent's data.";
    	if (toSave != null) {
    		Iterator i = toSave.entrySet().iterator();
    		Entry entry;
    		while (i.hasNext()) {
				entry = (Entry) i.next();
				final Agent agent = (Agent) entry.getKey();
				final AgentSaveInfo info = (AgentSaveInfo) entry.getValue();
				add(new BatchCall(description) {
	        		public void doCall() { 
	        			saveAgentData(agent, info);
	        		}
	        	}); 
			}
    	}
    	if (experimenter  != null) {
    		description = "Switching the user's group.";
    		add(new BatchCall(description) {
        		public void doCall() { 
        			switchUser();
        		}
        	}); 
    	}
    }
    
    /**
     * 
     * @return 
     */
    protected Object getPartialResult() { return result; }
    
    /**
     * Returns <code>null</code> as there's no final result.
     * @see BatchCallTree#getResult()
     */
    protected Object getResult() { return null; }
    
    public SwitchUserLoader(Map<Agent, AgentSaveInfo> toSave, 
    		ExperimenterData experimenter, long groupID)
    {
    	if (toSave == null && experimenter == null)
    		throw new IllegalArgumentException();
    	this.toSave = toSave;
    	this.experimenter = experimenter;
    	this.groupID = groupID;
    }
    
}

/*
 * org.openmicroscopy.shoola.env.data.model.ScriptObject 
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
package org.openmicroscopy.shoola.env.data.model;


//Java imports
import java.util.Map;
import javax.swing.Icon;

//Third-party libraries

//Application-internal dependencies
import pojos.ExperimenterData;

/** 
 * Hosts the information about a given script.
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
public class ScriptObject 
{

	/** The id of the script. */
	private long scriptID;
	
	/** The name of the script. */
	private String name;
	
	/** The owner of the script. */
	private ExperimenterData owner;
	
	/** The parameters of the script. */
	private Map<String, Class> parameterTypes;
	
	/** The values to pass to the script. */
	private Map<String, Object> parameterValues;
	
	/** The 16x16 icon associated to the script. */
	private Icon icon;
	
	/** The 48x48 icon associated to the script. */
	private Icon iconLarge;
	
	/**
	 * Creates a new instance.
	 * 
	 * @param scriptID The id of the script if uploaded.
	 * @param name The name of the script.
	 */
	public ScriptObject(long scriptID, String name)
	{
		this.scriptID = scriptID;
		this.name = name;
	}
	
	/**
	 * Sets the parameters associated to the script.
	 * 
	 * @param parameters The value to set. 
	 */
	public void setParameterTypes(Map<String, Class> parameterTypes)
	{
		this.parameterTypes = parameterTypes;
	}
	
	/**
	 * Returns the id of the script.
	 * 
	 * @return See above.
	 */
	public long getScriptID() { return scriptID; }
	
	/**
	 * Returns the name of the script.
	 * 
	 * @return See above.
	 */
	public String getName() { return name; }
	
	/**
	 * Returns the script of the parameters.
	 * 
	 * @return See above.
	 */
	public Map<String, Class> getParameterTypes() { return parameterTypes; }
	
	/**
	 * Sets the icon.
	 * 
	 * @param icon The icon associated to the script.
	 */
	public void setIcon(Icon icon) { this.icon = icon; }
	
	/**
	 * Sets the 48x48 icon.
	 * 
	 * @param icon The icon associated to the script.
	 */
	public void setIconLarge(Icon icon) { this.iconLarge = icon; }
	
	/**
	 * Returns the icon associated to the script.
	 * 
	 * @return See above.
	 */
	public Icon getIcon() { return icon; }
	
	/**
	 * Returns the 48x48 icon associated to the script.
	 * 
	 * @return See above.
	 */
	public Icon getIconLarge() { return iconLarge; }
	
	/**
	 * Sets the parameters to pass to the script.
	 * 
	 * @param parameterValues The value to set.
	 */
	public void setParameterValues(Map<String, Object> parameterValues)
	{
		this.parameterValues = parameterValues;
	}
	
	/**
	 * Returns the values.
	 * 
	 * @return See above.
	 */
	public Map<String, Object> getParameterValues() { return parameterValues; }
	
}

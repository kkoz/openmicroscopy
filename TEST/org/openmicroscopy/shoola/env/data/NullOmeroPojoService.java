/*
 * org.openmicroscopy.shoola.env.data.NullOmeroPojoService
 *
 *------------------------------------------------------------------------------
 *  Copyright (C) 2006 University of Dundee. All rights reserved.
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

package org.openmicroscopy.shoola.env.data;



//Java imports
import java.util.List;
import java.util.Map;
import java.util.Set;

//Third-party libraries

//Application-internal dependencies
import pojos.AnnotationData;
import pojos.DataObject;
import pojos.GroupData;

/** 
 * 
 *
 * @author  Jean-Marie Burel &nbsp;&nbsp;&nbsp;&nbsp;
 * 				<a href="mailto:j.burel@dundee.ac.uk">j.burel@dundee.ac.uk</a>
 * @author  <br>Andrea Falconi &nbsp;&nbsp;&nbsp;&nbsp;
 *              <a href="mailto:a.falconi@dundee.ac.uk">
 *                  a.falconi@dundee.ac.uk</a>
 * @version 2.2
 * <small>
 * (<b>Internal version:</b> $Revision$ $Date$)
 * </small>
 * @since OME2.2
 */
public class NullOmeroPojoService
    implements OmeroDataService
{

    /**
     * No-op implementation
     * @see OmeroDataService#findCGCPaths(Set, int, Class, long)
     */
    public Set findCGCPaths(Set imgIDs, int algorithm, Class rootLevel,
                            long levelID) 
    	throws DSOutOfServiceException, DSAccessException 
    {
        return null;
    }

    /**
     * No-op implementation
     * @see OmeroDataService#getCollectionCount(Class, String, Set)
     */
    public Map getCollectionCount(Class rootNodeType, String property,
            						Set rootNodeIDs)
    	throws DSOutOfServiceException, DSAccessException
    {
        return null;
    }

    /**
     * No-op implementation
     * @see OmeroDataService#loadContainerHierarchy(Class, Set, boolean, Class,
     *                                              long)
     */
    public Set loadContainerHierarchy(Class rootNodeType, Set rootNodeIDs,
            boolean withLeaves, Class rootLevel, long rootLevelID)
            throws DSOutOfServiceException, DSAccessException
    {
        return null;
    }

    /**
     * No-op implementation
     * @see OmeroDataService#findContainerHierarchy(Class, Set, Class, long)
     */
    public Set findContainerHierarchy(Class rootNodeType, Set leavesIDs,
                Class rootLevel, long rootLevelID)
            throws DSOutOfServiceException, DSAccessException
    {
        return null;
    }

    /**
     * No-op implementation
     * @see OmeroDataService#findAnnotations(Class, Set, Set)
     */
    public Map findAnnotations(Class nodeType, Set nodeIDs, Set annotatorIDs, 
    							boolean forUser)
            throws DSOutOfServiceException, DSAccessException
    {
        return null;
    }

    /**
     * No-op implementation
     * @see OmeroDataService#getImages(Class, Set, Class, long)
     */
    public Set getImages(Class nodeType, Set nodeIDs, Class rootLevel,
                        long rootLevelID)
            throws DSOutOfServiceException, DSAccessException
    {
        return null;
    }

    /**
     * No-op implementation
     * @see OmeroDataService#createDataObject(DataObject, DataObject)
     */
    public DataObject createDataObject(DataObject newObject, DataObject parent)
            throws DSOutOfServiceException, DSAccessException
    {
        return null;
    }

    /**
     * No-op implementation
     * @see OmeroDataService#updateDataObject(DataObject)
     */
    public DataObject updateDataObject(DataObject object)
            throws DSOutOfServiceException, DSAccessException
    {
        return null;
    }

    /**
     * No-op implementation
     * @see OmeroDataService#classify(Set, Set)
     */
    public Set classify(Set images, Set categories)
            throws DSOutOfServiceException, DSAccessException
    {
    	return null;
    }

    /**
     * No-op implementation
     * @see OmeroDataService#declassify(Set, Set)
     */
    public Set declassify(Set images, Set categories)
            throws DSOutOfServiceException, DSAccessException
    {
    	return null;
    }

    /**
     * No-op implementation
     * @see OmeroDataService#createAnnotationFor(DataObject, AnnotationData)
     */
    public DataObject createAnnotationFor(DataObject annotatedObject,
                                            AnnotationData data)
            throws DSOutOfServiceException, DSAccessException
    {
        return null;
    }

    /**
     * No-op implementation
     * @see OmeroDataService#removeAnnotationFrom(DataObject, AnnotationData)
     */
    public DataObject removeAnnotationFrom(DataObject annotatedObject,
                                            AnnotationData data)
            throws DSOutOfServiceException, DSAccessException
    {
        return null;
    }

    /**
     * No-op implementation
     * @see OmeroDataService#updateAnnotationFor(DataObject, AnnotationData)
     */
    public DataObject updateAnnotationFor(DataObject annotatedObject,
                                            AnnotationData data)
            throws DSOutOfServiceException, DSAccessException
    {
        return null;
    }

    /**
     * No-op implementation
     * @see OmeroDataService#loadExistingObjects(Class, Set, Class, long)
     */
    public Set loadExistingObjects(Class nodeType, Set nodeIDs, Class rootLevel,
                long rootID)
            throws DSOutOfServiceException, DSAccessException
    {
        return null;
    }

    /**
     * No-op implementation
     * @see OmeroDataService#addExistingObjects(DataObject, Set)
     */
    public void addExistingObjects(DataObject parent, Set children)
            throws DSOutOfServiceException, DSAccessException {}

    /**
     * No-op implementation
     * @see OmeroDataService#cutAndPaste(Map, Map)
     */
    public void cutAndPaste(Map toPaste, Map toCut)
            throws DSOutOfServiceException, DSAccessException {}

    /**
     * No-op implementation
     * @see OmeroDataService#removeDataObjects(Set, DataObject)
     */
    public Set removeDataObjects(Set children, DataObject parent)
            throws DSOutOfServiceException, DSAccessException
    {
        return null;
    }

    /**
     * No-op implementation
     * @see OmeroDataService#getChannelsMetadata(long)
     */
    public List getChannelsMetadata(long pixelsID)
            throws DSOutOfServiceException, DSAccessException
    {
        return null;
    }

    /**
     * No-op implementation
     * @see OmeroDataService#createAnnotationFor(Set, AnnotationData)
     */
	public List createAnnotationFor(Set toAnnotate, AnnotationData data) 
			throws DSOutOfServiceException, DSAccessException 
    {
		return null;
	}

    /**
     * No-op implementation
     * @see OmeroDataService#updateAnnotationFor(Map)
     */
	public List updateAnnotationFor(Map toUpdate) 
		throws DSOutOfServiceException, DSAccessException
    {
		return null;
	}

    /**
     * No-op implementation
     * @see OmeroDataService#getAvailableGroups()
     */
	public Map<GroupData, Set> getAvailableGroups() 
		throws DSOutOfServiceException, DSAccessException 
	{
		return null;
	}

    /**
     * No-op implementation
     * @see OmeroDataService#getOrphanContainers(Class, boolean, Class, long)
     */
	public Set getOrphanContainers(Class nodeType, boolean b, Class rootLevel, 
			long rootLevelID) 
	throws DSOutOfServiceException, DSAccessException 
	{
		return null;
	}

    /**
     * No-op implementation
     * @see OmeroDataService#getExperimenterImages(long)
     */
	public Set getExperimenterImages(long userID) 
		throws DSOutOfServiceException, DSAccessException 
	{
		return null;
	}

    /**
     * No-op implementation
     * @see OmeroDataService#getArchivedFiles(String, long)
     */
	public Map getArchivedFiles(String location, long pixelsID) 
		throws DSOutOfServiceException, DSAccessException
	{
		return null;
	}

    /**
     * No-op implementation
     * @see OmeroDataService#annotateChildren(Set, AnnotationData)
     */
	public List annotateChildren(Set objects, AnnotationData data) 
		throws DSOutOfServiceException, DSAccessException 
	{
		return null;
	}

    /**
     * No-op implementation
     * @see OmeroDataService#classifyChildren(Set, Set)
     */
	public Set classifyChildren(Set containers, Set categories) 
		throws DSOutOfServiceException, DSAccessException
	{
		return null;
	}

}

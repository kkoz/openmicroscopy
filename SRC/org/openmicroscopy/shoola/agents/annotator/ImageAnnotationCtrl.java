/*
 * org.openmicroscopy.shoola.agents.annotator.ImageAnnotationCtrl
 *
 *------------------------------------------------------------------------------
 *
 *  Copyright (C) 2004 Open Microscopy Environment
 *      Massachusetts Institute of Technology,
 *      National Institutes of Health,
 *      University of Dundee
 *
 *
 *
 *    This library is free software; you can redistribute it and/or
 *    modify it under the terms of the GNU Lesser General Public
 *    License as published by the Free Software Foundation; either
 *    version 2.1 of the License, or (at your option) any later version.
 *
 *    This library is distributed in the hope that it will be useful,
 *    but WITHOUT ANY WARRANTY; without even the implied warranty of
 *    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 *    Lesser General Public License for more details.
 *
 *    You should have received a copy of the GNU Lesser General Public
 *    License along with this library; if not, write to the Free Software
 *    Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 *
 *------------------------------------------------------------------------------
 */

/*------------------------------------------------------------------------------
 *
 * Written by:    Jeff Mellen <jeffm@alum.mit.edu>
 *
 *------------------------------------------------------------------------------
 */
 
package org.openmicroscopy.shoola.agents.annotator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openmicroscopy.ds.st.ImageAnnotation;
import org.openmicroscopy.shoola.agents.annotator.events.AnnotateImage;
import org.openmicroscopy.shoola.agents.annotator.events.ImageAnnotated;
import org.openmicroscopy.shoola.agents.browser.util.Filter;
import org.openmicroscopy.shoola.agents.browser.util.MapOperator;

/**
 * Control for the image annotator.
 *
 * @author Jeff Mellen, <a href="mailto:jeffm@alum.mit.edu">jeffm@alum.mit.edu</a><br>
 * <b>Internal version:</b> $Revision$ $Date$
 * @version 2.2
 * @since OME2.2
 */
public class ImageAnnotationCtrl extends AnnotationCtrl
{
    private int imageID;
    private String imageName;
    private AnnotateImage requestEvent;
    /**
     * Creates an image annotation controller using the specified image
     * as a basis.
     * @param imageID The ID of the image to annotate.
     */
    public ImageAnnotationCtrl(Annotator annotator,
                               AnnotateImage triggeringEvent)
    {
        if(annotator == null || triggeringEvent == null)
        {
            throw new IllegalArgumentException("Cannot construct an" +
                " ImageAnnotationCtrl with null parameters");
        }
        
        this.annotator = annotator;
        this.imageID = triggeringEvent.getID();
        this.imageName = triggeringEvent.getName();
        this.requestEvent = triggeringEvent;
        newAnnotationList = new ArrayList();
        
        List theList = annotator.getImageAnnotations(imageID);
        if(theList == null)
        {
            annotationList = new ArrayList();
        }
        else
        {
            annotationList = new ArrayList(theList);
        }
        attributeList = null; // do not use this for attributes yet (if ever)
    }
    
    /**
     * @see org.openmicroscopy.shoola.agents.annotator.AnnotationCtrl#getTargetDescription()
     */
    public String getTargetDescription()
    {
        return "Image " + imageName;
    }
    
    /**
     * Returns the image ID.
     * @return
     */
    public int getImageID()
    {
        return imageID;
    }
    
    /**
     * @see org.openmicroscopy.shoola.agents.annotator.AnnotationCtrl#getTextAnnotations()
     */
    public List getTextAnnotations()
    {
        return Filter.map(annotationList,new MapOperator()
        {
            public Object execute(Object o)
            {
                ImageAnnotation annotation = (ImageAnnotation)o;
                return annotation.getContent();
            }
        });
    }
    
    public String getAnnotation(int annotationIndex)
    {
        return (String)getTextAnnotations().get(annotationIndex);
    }
    
    public void newAnnotation(String annotation)
    {
        ImageAnnotation ia = annotator.createImageAnnotation(annotation,imageID);
        newAnnotationList.add(ia);
    }
    
    public void setAnnotation(int annotationIndex, String content)
    {
        ImageAnnotation annotation =
            (ImageAnnotation)annotationList.get(annotationIndex);
        annotation.setContent(content);
    }

   
    /**
     * Saves the annotation to DB and indicates such a change.
     */
    public boolean save()
    {
        annotator.commitNewAnnotations(newAnnotationList);
        annotator.updateAnnotations(annotationList);
        
        for(Iterator iter = newAnnotationList.iterator(); iter.hasNext();)
        {
            annotationList.add(0,iter.next());
        }
        newAnnotationList.clear();
        
        ImageAnnotated annotated = new ImageAnnotated(requestEvent);
        // TODO support multiple
        if(annotationList.size() > 0)
        {
            annotated.setAnnotation((ImageAnnotation)annotationList.get(0));
        }
        annotator.respondWithEvent(annotated);
        setSaved(true);
        return true;
    }
}

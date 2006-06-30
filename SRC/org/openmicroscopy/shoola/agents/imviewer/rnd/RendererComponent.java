/*
 * org.openmicroscopy.shoola.agents.imviewer.rnd.RendererComponent
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

package org.openmicroscopy.shoola.agents.imviewer.rnd;


//Java imports
import javax.swing.JFrame;

//Third-party libraries

//Application-internal dependencies
import ome.model.display.CodomainMapContext;
import org.openmicroscopy.shoola.agents.imviewer.view.ImViewer;
import org.openmicroscopy.shoola.util.ui.component.AbstractComponent;

/** 
 * 
 *
 * @author  Jean-Marie Burel &nbsp;&nbsp;&nbsp;&nbsp;
 * 				<a href="mailto:j.burel@dundee.ac.uk">j.burel@dundee.ac.uk</a>
 * @author	Andrea Falconi &nbsp;&nbsp;&nbsp;&nbsp;
 * 				<a href="mailto:a.falconi@dundee.ac.uk">a.falconi@dundee.ac.uk</a>
 * @author	Donald MacDonald &nbsp;&nbsp;&nbsp;&nbsp;
 * 				<a href="mailto:donald@lifesci.dundee.ac.uk">donald@lifesci.dundee.ac.uk</a>
 * @version 3.0
 * <small>
 * (<b>Internal version:</b> $Revision: $ $Date: $)
 * </small>
 * @since OME2.2
 */
class RendererComponent
    extends AbstractComponent
    implements Renderer
{
    
    /** The Model sub-component. */
    private RendererModel   model;
    
    /** The Control sub-component. */
    private RendererControl controller;
    
    /** The View sub-component. */
    private RendererUI      view;
    
    /**
     * Creates a new instance.
     * The {@link #initialize() initialize} method should be called straigh 
     * after to complete the MVC set up.
     * 
     * @param model The Model sub-component. Mustn't be <code>null</code>.
     */
    RendererComponent(RendererModel model)
    {
        if (model == null) throw new NullPointerException("No model.");
        this.model = model;
    }
    
    /** Links up the MVC triad. */
    void initialize()
    {
        model.initialize(this);
    }
    
    /** 
     * Implemented as specified by the {@link Renderer} interface.
     * @see Renderer#discard()
     */
    public void discard()
    {
        model.discard();
        view.setVisible(false);
        view.dispose();
    }

    /** 
     * Implemented as specified by the {@link Renderer} interface.
     * @see Renderer#moveToFront()
     */
    public void moveToFront()
    {
        //if (model.getState() != DISCARDED) return;
        view.deIconify();
    }

    /** 
     * Implemented as specified by the {@link Renderer} interface.
     * @see Renderer#updateCodomainMap(CodomainMapContext)
     */
    public void updateCodomainMap(CodomainMapContext ctx)
    {
        //if (model.getState() != DISCARDED) return;
        model.updateCodomainMap(ctx);
        firePropertyChange(RENDER_PLANE_PROPERTY, Boolean.FALSE, Boolean.TRUE);
    }

    /** 
     * Implemented as specified by the {@link Renderer} interface.
     * @see Renderer#setInputEnd(double, boolean)
     */
    public void setInputEnd(double v, boolean released)
    {
        //if (model.getState() != DISCARDED) return;
        model.setInputEnd(v);
        firePropertyChange(RENDER_PLANE_PROPERTY, Boolean.FALSE, Boolean.TRUE);
    }

    /** 
     * Implemented as specified by the {@link Renderer} interface.
     * @see Renderer#setInputStart(double, boolean)
     */
    public void setInputStart(double v, boolean released)
    {
        //if (model.getState() != DISCARDED) return;
        model.setInputStart(v);
        firePropertyChange(RENDER_PLANE_PROPERTY, Boolean.FALSE, Boolean.TRUE);
    }

    /** 
     * Implemented as specified by the {@link Renderer} interface.
     * @see Renderer#setCodomainEnd(int, boolean)
     */
    public void setCodomainEnd(int v, boolean released)
    {
        //if (model.getState() != DISCARDED) return;
        model.setCodomainEnd(v);
        firePropertyChange(RENDER_PLANE_PROPERTY, Boolean.FALSE, Boolean.TRUE);
    }

    /** 
     * Implemented as specified by the {@link Renderer} interface.
     * @see Renderer#setCodomainStart(int, boolean)
     */
    public void setCodomainStart(int v, boolean released)
    {
        //if (model.getState() != DISCARDED) return;
        model.setCodomainStart(v);
        firePropertyChange(RENDER_PLANE_PROPERTY, Boolean.FALSE, Boolean.TRUE);
    }

    /** 
     * Implemented as specified by the {@link Renderer} interface.
     * @see Renderer#setBitResolution(int)
     */
    public void setBitResolution(int v)
    {
        //if (model.getState() != DISCARDED) return;
        model.setBitResolution(v);
        firePropertyChange(RENDER_PLANE_PROPERTY, Boolean.FALSE, Boolean.TRUE);
    }

    /** 
     * Implemented as specified by the {@link Renderer} interface.
     * @see Renderer#setSelectedChannel(int)
     */
    public void setSelectedChannel(int c)
    {
        //if (model.getState() != DISCARDED) return;
        int selectedChannel  = model.getSelectedChannel();
        if (selectedChannel == c) return;
        model.setSelectedChannel(c);
        firePropertyChange(SELECTED_CHANNEL_PROPERTY, 
                    new Integer(selectedChannel), new Integer(c));
    }

    /** 
     * Implemented as specified by the {@link Renderer} interface.
     * @see Renderer#setFamily(String)
     */
    public void setFamily(String family)
    {
        //if (model.getState() != DISCARDED) return;
        model.setFamily(family);
        firePropertyChange(RENDER_PLANE_PROPERTY, Boolean.FALSE, Boolean.TRUE);
    }

    /** 
     * Implemented as specified by the {@link Renderer} interface.
     * @see Renderer#setCurveCoefficient(double)
     */
    public void setCurveCoefficient(double k)
    {
        //if (model.getState() != DISCARDED) return;
        model.setCurveCoefficient(k);
        firePropertyChange(RENDER_PLANE_PROPERTY, Boolean.FALSE, Boolean.TRUE);
    }

    /** 
     * Implemented as specified by the {@link Renderer} interface.
     * @see Renderer#setNoiseReduction(boolean)
     */
    public void setNoiseReduction(boolean b)
    {
        //if (model.getState() != DISCARDED) return;
        model.setNoiseReduction(b);
        firePropertyChange(RENDER_PLANE_PROPERTY, Boolean.FALSE, Boolean.TRUE);
    }

    /** 
     * Implemented as specified by the {@link Renderer} interface.
     * @see Renderer#getState()
     */
    public int getState() { return model.getState(); }

    /** 
     * Implemented as specified by the {@link Renderer} interface.
     * @see Renderer#getParentModel()
     */
    public ImViewer getParentModel() { return model.getParentModel(); }

    /** 
     * Implemented as specified by the {@link Renderer} interface.
     * @see Renderer#getCodomainMapContext(Class)
     */
    public CodomainMapContext getCodomainMapContext(Class mapType)
    {
        return model.getCodomainMap(mapType);
    }

    /** 
     * Implemented as specified by the {@link Renderer} interface.
     * @see Renderer#removeCodomainMap(Class mapType)
     */
    public void removeCodomainMap(Class mapType)
    {
        model.removeCodomainMap(mapType);
        firePropertyChange(RENDER_PLANE_PROPERTY, Boolean.FALSE, Boolean.TRUE);
    }

    /** 
     * Implemented as specified by the {@link Renderer} interface.
     * @see Renderer#addCodomainMap(Class mapType)
     */
    public void addCodomainMap(Class mapType)
    {
        if (model.getCodomainMap(mapType) != null) return;
        model.addCodomainMap(mapType);
        firePropertyChange(RENDER_PLANE_PROPERTY, Boolean.FALSE, Boolean.TRUE);
    }

    /** 
     * Implemented as specified by the {@link Renderer} interface.
     * @see Renderer#getUI()
     */
    public JFrame getUI() { return view; }

}

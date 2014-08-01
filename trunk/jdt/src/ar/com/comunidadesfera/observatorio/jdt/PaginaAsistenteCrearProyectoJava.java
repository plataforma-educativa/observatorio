/*******************************************************************************
 * Copyright (c) 2000, 2008 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Eclipse Foundation - modified from org.eclipse.jdt.ui.wizards.NewJavaProjectWizardPageOne
 *     IDE4EDU - modified from org.eclipse.soc.ide4edu.ui.view.NewJavaLiteProjectWizardPageOne
 *******************************************************************************/
package ar.com.comunidadesfera.observatorio.jdt;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.ui.wizards.NewJavaProjectWizardPageOne;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

public class PaginaAsistenteCrearProyectoJava extends NewJavaProjectWizardPageOne {

    @Override
    protected Control createInfoControl(Composite composite) {

        Control control = super.createInfoControl(composite);
        control.setVisible(false);
        return control;
    }
    
    @Override
    protected Control createJRESelectionControl(Composite composite) {

        Control control = super.createJRESelectionControl(composite); 
        control.setVisible(false);
        return control;
    }
    
    @Override
    protected Control createLocationControl(Composite composite) {

        Control control = super.createLocationControl(composite); 
        control.setVisible(false);
        return control;
    }
    
    @Override
    protected Control createProjectLayoutControl(Composite composite) {

        Control control = super.createProjectLayoutControl(composite);
        control.setVisible(false);
        return control;
    }
    
    @Override
    protected Control createWorkingSetControl(Composite composite) {

        Control control = super.createWorkingSetControl(composite);
        control.setVisible(false);
        return control;
    }

    @Override
    public IPath getOutputLocation() {

        /* Los binarios, junto con los fuentes, en la raíz del proyecto */
        return new Path(getProjectName()).makeAbsolute();
    }

    @Override
    public IClasspathEntry[] getSourceClasspathEntries() {

        IPath sourceFolderPath = new Path(getProjectName()).makeAbsolute();

        /* Fuerza la localización de los fuentes en la raíz del proyecto */
        return new IClasspathEntry[] {  JavaCore.newSourceEntry(sourceFolderPath) };
    }
    
    @Override
    public IWizardPage getNextPage() {

        return null;
    }
}

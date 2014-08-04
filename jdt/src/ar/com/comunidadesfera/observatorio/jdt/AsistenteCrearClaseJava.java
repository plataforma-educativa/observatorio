/*******************************************************************************
 * Copyright (c) 2000, 2006 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Eclipse Foundation - modified from org.eclipse.jdt.internal.ui.wizards.NewClassCreationWizard
 *     IDE4EDU - modified from org.eclipse.soc.ide4edu.ui.view.NewLiteClassCreationWizard
 *******************************************************************************/
package ar.com.comunidadesfera.observatorio.jdt;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.internal.ui.JavaPlugin;
import org.eclipse.jdt.internal.ui.JavaPluginImages;
import org.eclipse.jdt.internal.ui.wizards.NewElementWizard;
import org.eclipse.jdt.internal.ui.wizards.NewWizardMessages;
import org.eclipse.jdt.ui.wizards.NewClassWizardPage;

public class AsistenteCrearClaseJava extends NewElementWizard {

    private NewClassWizardPage fPage;

    public AsistenteCrearClaseJava() {
    
        setDefaultPageImageDescriptor(JavaPluginImages.DESC_WIZBAN_NEWCLASS);
        setDialogSettings(JavaPlugin.getDefault().getDialogSettings());
        setWindowTitle(NewWizardMessages.NewClassCreationWizard_title);

        fPage = null;
    }

    @Override
    public void addPages() {
        super.addPages();
        if (fPage == null) {
            fPage= new PaginaAsistenteCrearClaseJava();
            fPage.setWizard(this);
            fPage.init(getSelection());
        }

        addPage(fPage);
    }

    @Override
    protected boolean canRunForked() {
        return !fPage.isEnclosingTypeSelected();
    }

    @Override
    protected void finishPage(IProgressMonitor monitor) throws InterruptedException, CoreException {
        fPage.createType(monitor); // use the full progress monitor
    }

    @Override
    public boolean performFinish() {
        warnAboutTypeCommentDeprecation();
        boolean res= super.performFinish();
        if (res) {
            IResource resource= fPage.getModifiedResource();
            if (resource != null) {
                selectAndReveal(resource);
                openResource((IFile) resource);
            }
        }
        return res;
    }

    @Override
    public IJavaElement getCreatedElement() {
        return fPage.getCreatedType();
    }
}
/*******************************************************************************
 * Copyright (c) 2000, 2011 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation 
 *     Eclipse Foundation - modified from org.eclipse.jdt.ui.actions.OpenNewJavaProjectWizardAction
 *     IDE4EDU - modified from org.eclipse.soc.ide4edu.ui.view.OpenNewLiteClassWizardAction 
 *******************************************************************************/
package ar.com.comunidadesfera.observatorio.jdt;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.jdt.internal.ui.IJavaHelpContextIds;
import org.eclipse.jdt.internal.ui.JavaPlugin;
import org.eclipse.jdt.internal.ui.actions.ActionMessages;
import org.eclipse.jdt.ui.actions.AbstractOpenWizardAction;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.PlatformUI;

public class AbrirAsistenteCrearProyectoBatallaEspacial extends AbstractOpenWizardAction {

    private static final String ID = "ar.com.comunidadesfera.observatorio.acciones.AbrirAsistenteCrearProyectoBatallaEspacial";  //$NON-NLS-1$
     
    public AbrirAsistenteCrearProyectoBatallaEspacial() {

        setId(ID);
        setText("Crear Proyecto Batalla Espacial");
        setDescription(ActionMessages.OpenNewJavaProjectWizardAction_description);
        setToolTipText(ActionMessages.OpenNewJavaProjectWizardAction_tooltip);
        PlatformUI.getWorkbench().getHelpSystem().setHelp(this, IJavaHelpContextIds.OPEN_PROJECT_WIZARD_ACTION);
        setShell(JavaPlugin.getActiveWorkbenchShell());
    }

    @Override
    protected final INewWizard createWizard() throws CoreException {

        return (INewWizard) PlatformUI.getWorkbench()
                                .getNewWizardRegistry()
                                .findWizard("ar.com.comunidadesfera.observatorio.asistentes.crearProyectoBatallaEspacial") //$NON-NLS-1$
                                .createWizard();
    }

    @Override
    protected boolean doCreateProjectFirstOnEmptyWorkspace(Shell shell) {
        return true;
    }
}


/*******************************************************************************
 * Copyright (c) 2000, 2008 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Eclipse Foundation - modified from org.eclipse.jdt.ui.wizards.NewClassWizardPage
 *     IDE4EDU - modified from org.eclipse.soc.ide4edu.ui.view.NewLiteClassWizardPage
 *******************************************************************************/
package ar.com.comunidadesfera.observatorio.jdt;

import org.eclipse.jdt.internal.ui.IJavaHelpContextIds;
import org.eclipse.jdt.ui.wizards.NewClassWizardPage;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.PlatformUI;

public class PaginaAsistenteCrearClaseJava extends NewClassWizardPage {

    @Override
    public void createControl(Composite parent) {
        initializeDialogUnits(parent);

        Composite composite= new Composite(parent, SWT.NONE);
        composite.setFont(parent.getFont());

        int nColumns= 4;

        GridLayout layout= new GridLayout();
        layout.numColumns= nColumns;
        composite.setLayout(layout);

        createPackageControls(composite, nColumns);
        createSeparator(composite, nColumns);
        createTypeNameControls(composite, nColumns);
        enableCommentControl(false);

        setControl(composite);
        Dialog.applyDialogFont(composite);
        PlatformUI.getWorkbench().getHelpSystem().setHelp(composite, IJavaHelpContextIds.NEW_CLASS_WIZARD_PAGE);
    }
    
}

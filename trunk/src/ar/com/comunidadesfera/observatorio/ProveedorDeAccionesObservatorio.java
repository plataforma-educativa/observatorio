package ar.com.comunidadesfera.observatorio;

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.ui.navigator.CommonActionProvider;
import org.eclipse.ui.navigator.ICommonActionExtensionSite;
import org.eclipse.ui.navigator.ICommonViewerWorkbenchSite;

import ar.com.comunidadesfera.observatorio.jdt.AbrirAsistenteCrearClaseJava;
import ar.com.comunidadesfera.observatorio.jdt.AbrirAsistenteCrearProyectoJava;

public class ProveedorDeAccionesObservatorio extends CommonActionProvider {

    public static final String GROUP = "group.observatorio"; //$NON-NLS-1$
    
    private boolean contribute = false;

    private AbrirAsistenteCrearProyectoJava abrirAsistenteCrearProyectoJava;
    private AbrirAsistenteCrearClaseJava abrirAsistenteCrearClaseJava;

	
	@Override
	public void init(ICommonActionExtensionSite aSite) {
	    
        if (aSite.getViewSite() instanceof ICommonViewerWorkbenchSite) {

            abrirAsistenteCrearProyectoJava = new AbrirAsistenteCrearProyectoJava();
            abrirAsistenteCrearClaseJava = new AbrirAsistenteCrearClaseJava();
            contribute = true;
        }
	}


	@Override
	public void fillContextMenu(IMenuManager menu) {
		
		if (contribute) {
		    menu.appendToGroup("group.observatorio", abrirAsistenteCrearProyectoJava);
		    menu.appendToGroup("group.observatorio", abrirAsistenteCrearClaseJava);
		}
	}
	
	@Override
	public void dispose() {

	    super.dispose();
	}
}

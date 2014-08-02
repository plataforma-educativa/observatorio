package ar.com.comunidadesfera.observatorio;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.ui.navigator.CommonActionProvider;
import org.eclipse.ui.navigator.ICommonActionExtensionSite;
import org.eclipse.ui.navigator.ICommonViewerWorkbenchSite;

import ar.com.comunidadesfera.observatorio.jdt.AbrirAsistenteCrearClaseJava;
import ar.com.comunidadesfera.observatorio.jdt.AbrirAsistenteCrearProyectoBatallaEspacial;
import ar.com.comunidadesfera.observatorio.jdt.AbrirAsistenteCrearProyectoJava;

public class ProveedorDeAccionesObservatorio extends CommonActionProvider {

    public static final String GROUP = "group.observatorio"; //$NON-NLS-1$
    
    private boolean contribute = false;

    private List<IAction> actions = new LinkedList<IAction>();
	
	@Override
	public void init(ICommonActionExtensionSite aSite) {
	    
        if (aSite.getViewSite() instanceof ICommonViewerWorkbenchSite) {

            actions.add(new AbrirAsistenteCrearProyectoBatallaEspacial());
            actions.add(new AbrirAsistenteCrearProyectoJava());
            actions.add(new AbrirAsistenteCrearClaseJava());
            contribute = true;
        }
	}


	@Override
	public void fillContextMenu(IMenuManager menu) {
		
		if (contribute) {
		    
		    for (IAction action : actions) {
		        
		        menu.appendToGroup(GROUP, action);
		    }
		}
	}
	
	@Override
	public void dispose() {

	    super.dispose();
	}
}

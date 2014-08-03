package ar.com.comunidadesfera.observatorio;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.jdt.core.ClasspathContainerInitializer;
import org.eclipse.jdt.core.IClasspathContainer;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;

public class InicializadorDeDependenciasBatallaEspacial extends ClasspathContainerInitializer {
    
    public static final String ECLIPSE_HOME =  "ECLIPSE_HOME"; //$NON-NLS-1$
    public static final String RUTA = "observatorio"; //$NON-NLS-1$
    public static final String DEPENDENCIA = "batalla-espacial.jar"; //$NON-NLS-1$
    public static final String DESCRIPCION = "Batalla Espacial"; //$NON-NLS-1$
    
    public static class ContenedorBatallaEspacial implements IClasspathContainer {

        private final IClasspathEntry[] fEntries;
        private final IPath fPath;
        
        public ContenedorBatallaEspacial(IPath path, IClasspathEntry[] entries) {

            fPath = path;
            fEntries = entries;
        }
        
        @Override
        public IClasspathEntry[] getClasspathEntries() {

            return fEntries;
        }

        @Override
        public String getDescription() {

            return DESCRIPCION;
        }

        @Override
        public int getKind() {

            return IClasspathContainer.K_APPLICATION;
        }

        @Override
        public IPath getPath() {

            return fPath;
        }
    }
    
    @Override
    public void initialize(IPath containerPath, IJavaProject project) throws CoreException {

        IPath batallaEspacialJar = JavaCore.getClasspathVariable(ECLIPSE_HOME)
                                                    .append(RUTA)
                                                    .append(DEPENDENCIA); 
              
        final ContenedorBatallaEspacial container = new ContenedorBatallaEspacial(
                containerPath,
                new IClasspathEntry[] { JavaCore.newLibraryEntry(batallaEspacialJar, null, null) });

        JavaCore.setClasspathContainer(containerPath, new IJavaProject[] { project },   new IClasspathContainer[] { container }, null);
    }

}

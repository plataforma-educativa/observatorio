package ar.com.comunidadesfera.observatorio;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.jdt.core.ClasspathContainerInitializer;
import org.eclipse.jdt.core.IClasspathContainer;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.internal.junit.buildpath.BuildPathSupport;

public class InicializadorDeDependenciasBatallaEspacial extends ClasspathContainerInitializer {

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

            return "Batalla Espacial";
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

        // TODO
        final ContenedorBatallaEspacial container = new ContenedorBatallaEspacial(
                containerPath,
                new IClasspathEntry[] { BuildPathSupport.getJUnit4LibraryEntry()});
        
        
        JavaCore.setClasspathContainer(containerPath, new IJavaProject[] { project },   new IClasspathContainer[] { container }, null);
    }

}

package ar.com.comunidadesfera.observatorio.jdt;

import java.util.Arrays;

import org.eclipse.core.runtime.Path;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.JavaCore;

public class PaginaAsistenteCrearProyectoBatallaEspacial extends PaginaAsistenteCrearProyectoJava {
   
    private static final String CLASSPATH = "ar.com.comunidadesfera.observatorio.BatallaEspacial";  //$NON-NLS-1$
    
    @Override
    public IClasspathEntry[] getDefaultClasspathEntries() {

        IClasspathEntry[] classpathEntries = super.getDefaultClasspathEntries(); 
        
        classpathEntries = Arrays.copyOf(classpathEntries, classpathEntries.length + 1);
        classpathEntries[classpathEntries.length - 1] = JavaCore.newContainerEntry(new Path(CLASSPATH));
        
        return classpathEntries;
    }
}

package ar.com.comunidadesfera.observatorio;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class ActivadorObservatorio extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "ar.com.comunidadesfera.observatorio"; //$NON-NLS-1$

	// The shared instance
	private static ActivadorObservatorio plugin;
	
	/**
	 * The constructor
	 */
	public ActivadorObservatorio() {
	}

	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static ActivadorObservatorio getDefault() {
		return plugin;
	}

}

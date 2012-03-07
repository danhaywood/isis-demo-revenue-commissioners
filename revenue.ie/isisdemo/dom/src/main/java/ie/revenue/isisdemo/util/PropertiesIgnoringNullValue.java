package ie.revenue.isisdemo.util;

import java.util.Properties;

public class PropertiesIgnoringNullValue extends Properties {
	private static final long serialVersionUID = 1L;
	
	@Override
	public synchronized Object put(Object key, Object value) {
		if(value == null) { return null; }
		return super.put(key, value);
	}
}
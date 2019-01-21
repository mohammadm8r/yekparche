package biz.vrls.util;

import java.util.AbstractMap;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;

import javax.servlet.http.HttpSession;

public class AppTextLabels extends AbstractMap<String, String> {

    // This should be abstracted into ResourceManager service class...

    static ResourceBundle bundle = ResourceBundle.getBundle("ApplicationResources");

    public static final String SUFFIX_LOGGED_IN = ".auth";
    
    private Map<String, String> authMap = new HashMap<String, String>() ;
    private Map<String, String> noAuthMap = new HashMap<String, String>() ;
    private HttpSession session;

    public AppTextLabels(String prefix, HttpSession session) {
        this(prefix, SUFFIX_LOGGED_IN, session);
    }
        
    public AppTextLabels(String prefix, String authSuffix, HttpSession session) {

        int prefixLength = prefix.length();
        int authSuffixLength = authSuffix.length();

        this.session = session;
        Enumeration<String> keys = bundle.getKeys();
        while (keys.hasMoreElements()) {
            String key = keys.nextElement();
            if (key.startsWith(prefix)) {
                String label = key.substring(prefixLength);
                if (label.endsWith(authSuffix)) {
                   authMap.put(label.substring(0, label.length() - authSuffixLength),
                       bundle.getString(key));
                }
                else {
                   noAuthMap.put(label, bundle.getString(key));
                }
            }
        }

        Set<String> onlyInNoAuth = new HashSet<String>(noAuthMap.keySet());
        onlyInNoAuth.removeAll(authMap.keySet());
        for (String key : onlyInNoAuth) {
            authMap.put(key, noAuthMap.get(key));
        }

        Set<String> onlyInAuth = new HashSet<String>(authMap.keySet());
        onlyInAuth.removeAll(noAuthMap.keySet());
        for (String key : onlyInAuth) {
            noAuthMap.put(key, authMap.get(key));
        }
    }        

    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("PLAIN:\n");
        for (String key : authMap.keySet()) {
            String value = (String) authMap.get(key);
            sb.append(key + ": " + value + "\n");
        }
        sb.append("\nAUTH:\n");
        for (String key : noAuthMap.keySet()) {
            String value = (String) noAuthMap.get(key);
            sb.append(key + ": " + value + "\n");
        }
        return sb.toString();
    }
    
    public Set<Map.Entry<String, String>> entrySet() {
        return ((session.getAttribute("customer") != null) ?
            authMap.entrySet() : noAuthMap.entrySet());
    }

}

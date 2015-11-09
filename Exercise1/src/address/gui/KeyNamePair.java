/**
 * 
 */
package address.gui;

/**
 * @author Jesus Ramos
 * @version 1.0
 * @since Nov 8, 2015, JDK 8
 */
public class KeyNamePair {

    private String key;
    private String name;

    public KeyNamePair() {
        this.key = "";
        this.name = "";
    }
    
    public KeyNamePair(String key, String name) {
        this.key = key;
        this.name = name;
    }

    public String getKey() {
        return this.key;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return name;
    }
}

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author by Zeyu Chen
 * @version 1.0
 */
public class DomainBanner {

    /**
     * Constructor
     */
    public  DomainBanner() {
        DomainBannerNode root = new DomainBannerNode();
    }

    /**
     * This method add domain in the domain list.
     * @param domain
     */
    public void add (String domain) {
        
    }

    /**
     * This method delete domain in the domain list.
     * @param domain
     */
    public void delete (String domain) {

    }

    /**
     * This method check if the domain is in the list.
     *
     * @param domain domain waiting for test
     * @param root of banned domains Tree
     * @return true if domain is in the list
     */
    public boolean check(String domain, DomainBannerNode root) {
        return true;
    }
}

class DomainBannerNode {
    private String mDomainPart;
    private HashSet<String> mSet;

    /**
     * Constructor
     * Create a hash set to store the child string.
     * This is the root.
     */
    public DomainBannerNode() {
        mDomainPart = null;
        mSet = new HashSet<>();
    }

    /**
     * Constructor
     * Create a hash set to store the child string.
     * @param domainPart
     */
    public DomainBannerNode(String domainPart) {
        mDomainPart = domainPart;
        mSet = new HashSet<>();
        mSet.add(domainPart);
    }

    /**
     * This method check if it contains coming domainPart
     *
     * @param domainPart
     * @return true if it contains
     */
    public boolean checkIfInChildren(String domainPart) {
        return true;
    }

    /**
     * This method add coming domainPart to the children
     *
     * @param domainPart
     */
    public void addToChildren(String domainPart) {
        mSet.add(domainPart);
    }
}

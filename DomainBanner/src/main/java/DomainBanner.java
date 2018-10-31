import java.util.HashMap;
import java.util.Map;

/**
 * @author by Zeyu Chen
 * @version 1.0
 */
public class DomainBanner {

    private DomainBannerNode root;
    /**
     * Constructor
     */
    public  DomainBanner() {
        root = new DomainBannerNode();
    }

    /**
     * This method add domain in the domain list.
     * @param domain
     */
    public void add (String domain) {
        DomainBannerNode currNode = root;
        String[] splittedDomain = domain.split(".");

        for (int i = splittedDomain.length - 1; i > 0; --i) {
            if (currNode.checkIfInChildren(splittedDomain[i])) {
                continue;
            }
            else {
                currNode.addToChildren(splittedDomain[i]);
            }
            DomainBannerNode nextNode = currNode.getValueByKey(splittedDomain[i]);
            currNode = nextNode;
        }
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
        String[] splittedDomain = domain.split(".");
        DomainBannerNode currNode = root;

        for (int i = splittedDomain.length - 1; i > 0; --i) {
            if (currNode.checkIfInChildren(splittedDomain[i])) {
                currNode = currNode.getValueByKey(splittedDomain[i]);
                continue;
            }
            else {
                return false;
            }
        }

        return true;
    }
}

class DomainBannerNode {
    private String mDomainPart;
    private Map<String, DomainBannerNode> mMap; // children domainPart and its node

    /**
     * Constructor
     * Create a hash set to store the child string.
     * This is the root.
     */
    public DomainBannerNode() {
        mDomainPart = null;
        mMap = new HashMap<>();
    }

    /**
     * Constructor
     * Create a hash set to store the child string.
     * @param domainPart
     */
    public DomainBannerNode(String domainPart) {
        mDomainPart = domainPart;
        mMap = new HashMap<>();
    }

    /**
     * This method check if it contains coming domainPart
     *
     * @param domainPart
     * @return true if it contains
     */
    public boolean checkIfInChildren(String domainPart) {
        return mMap.containsKey(domainPart);
    }

    /**
     * This method add coming domainPart to the children
     *
     * @param domainPart
     */
    public void addToChildren(String domainPart) {
        mMap.put(domainPart, new DomainBannerNode(domainPart));
    }

    /**
     * This method returns the next node which matches the input domain part.
     *
     * @param domainPart
     */
    public DomainBannerNode getValueByKey(String domainPart) {
        // double check
        if (!mMap.containsKey(domainPart)) {
            return null;
        }
        else {
            return  mMap.get(domainPart);
        }
    }
}

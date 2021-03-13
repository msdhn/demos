package eu.msdhn.aad;

import org.json.JSONObject;

import java.security.Policy;
import java.util.ArrayList;
import java.util.List;

public class User extends DirectoryObject {

    protected String objectId;
    protected String objectType;
    protected String accountEnabled;
    protected String city;
    protected String country;
    protected String department;
    protected String dirSyncEnabled;
    protected String displayName;
    protected String facsimileTelephoneNumber;
    protected String givenName;
    protected String jobTitle;
    protected String lastDirSyncTime;
    protected String mail;
    protected String mailNickname;
    protected String mobile;
    protected String password;
    protected String passwordPolicies;
    protected String physicalDeliveryOfficeName;
    protected String postalCode;
    protected String preferredLanguage;
    protected String state;
    protected String streetAddress;
    protected String surname;
    protected String telephoneNumber;
    protected String usageLocation;
    protected String userPrincipalName;
    protected boolean isDeleted;  // this will move to dto
    /**
     * below 4 properties are for future use
     */
    // managerDisplayname of this user
    protected String managerDisplayname;
    // The directReports holds a list of directReports
    private List<User> directReports;
    // The groups holds a list of group entity this user belongs to.
    private List<Policy> groups;
    // The roles holds a list of role entity this user belongs to.
    private List<Policy> roles;

    /**
     * The constructor for the User class. Initializes the dynamic lists and managerDisplayname variables.
     */
    public User() {
        directReports = null;
        groups = new ArrayList<Policy>();
        roles = new ArrayList<Policy>();
        managerDisplayname = null;
    }

    @Override
    public String getObjectId() {
        return objectId;
    }

    @Override
    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    @Override
    public String getObjectType() {
        return objectType;
    }

    @Override
    public void setObjectType(String objectType) {
        this.objectType = objectType;
    }

    public String getAccountEnabled() {
        return accountEnabled;
    }

    public void setAccountEnabled(String accountEnabled) {
        this.accountEnabled = accountEnabled;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDirSyncEnabled() {
        return dirSyncEnabled;
    }

    public void setDirSyncEnabled(String dirSyncEnabled) {
        this.dirSyncEnabled = dirSyncEnabled;
    }

    @Override
    public String getDisplayName() {
        return displayName;
    }

    @Override
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getFacsimileTelephoneNumber() {
        return facsimileTelephoneNumber;
    }

    public void setFacsimileTelephoneNumber(String facsimileTelephoneNumber) {
        this.facsimileTelephoneNumber = facsimileTelephoneNumber;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getLastDirSyncTime() {
        return lastDirSyncTime;
    }

    public void setLastDirSyncTime(String lastDirSyncTime) {
        this.lastDirSyncTime = lastDirSyncTime;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getMailNickname() {
        return mailNickname;
    }

    public void setMailNickname(String mailNickname) {
        this.mailNickname = mailNickname;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordPolicies() {
        return passwordPolicies;
    }

    public void setPasswordPolicies(String passwordPolicies) {
        this.passwordPolicies = passwordPolicies;
    }

    public String getPhysicalDeliveryOfficeName() {
        return physicalDeliveryOfficeName;
    }

    public void setPhysicalDeliveryOfficeName(String physicalDeliveryOfficeName) {
        this.physicalDeliveryOfficeName = physicalDeliveryOfficeName;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getPreferredLanguage() {
        return preferredLanguage;
    }

    public void setPreferredLanguage(String preferredLanguage) {
        this.preferredLanguage = preferredLanguage;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getUsageLocation() {
        return usageLocation;
    }

    public void setUsageLocation(String usageLocation) {
        this.usageLocation = usageLocation;
    }

    public String getUserPrincipalName() {
        return userPrincipalName;
    }

    public void setUserPrincipalName(String userPrincipalName) {
        this.userPrincipalName = userPrincipalName;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public String getManagerDisplayname() {
        return managerDisplayname;
    }

    public void setManagerDisplayname(String managerDisplayname) {
        this.managerDisplayname = managerDisplayname;
    }

    public List<User> getDirectReports() {
        return directReports;
    }

    public void setDirectReports(List<User> directReports) {
        this.directReports = directReports;
    }

    public List<Policy> getGroups() {
        return groups;
    }

    public void setGroups(List<Policy> groups) {
        this.groups = groups;
    }

    public List<Policy> getRoles() {
        return roles;
    }

    public void setRoles(List<Policy> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return new JSONObject(this).toString();
    }
}



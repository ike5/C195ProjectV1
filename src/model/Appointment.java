package model;

import data.DBContacts;
import data.DBCustomers;
import data.DBUsers;

import java.time.LocalDateTime;
import java.util.function.Supplier;

/**
 * Rules: An appointment cannot be made without a customer, user, and contact
 */
public class Appointment {
    // Everything except title and location can be null
    private int appointmentId;         // autogenerated
    private String appointmentTitle;    // must provide a value
    private String appointmentDescription;
    private String appointmentLocation; // must provide a value
    private String type;                // use ApptFactory
    private Customer customer;          // to get customerId
    private User user;
    private Contact contact;
    private int customerId;
    private int userId;
    private int contactId;
    private LocalDateTime start;
    private LocalDateTime end;
    private String startString;
    private String endString;
    private Location locationEnum;
    private Type typeEnum;



    // An appointment has a Contact, User, and Customer in addition to the fields that make up its body
    public Appointment(int appointmentId, String appointmentTitle, String appointmentDescription, String appointmentLocation, String type, Customer customer_customerId, User user_userId, Contact contact_contactId) {
        this.appointmentId = appointmentId;
        this.appointmentTitle = appointmentTitle;
        this.appointmentDescription = appointmentDescription;
        this.appointmentLocation = appointmentLocation;
        this.type = type;
        this.customer = customer_customerId;
        this.user = user_userId;
        this.contact = contact_contactId;
    }

    // Used for the retrieval from database
    public Appointment(int appointmentId, String appointmentTitle, String appointmentDescription, String appointmentLocation, String type, LocalDateTime start, LocalDateTime end, Customer customer_customerId, User user_userId, Contact contact_contactId) {
        this.appointmentId = appointmentId;
        this.appointmentTitle = appointmentTitle;
        this.appointmentDescription = appointmentDescription;
        this.appointmentLocation = appointmentLocation;
        this.type = type;
        this.start = start;
        this.end = end;
        this.customer = customer_customerId;
        this.user = user_userId;
        this.contact = contact_contactId;
    }

    public Appointment(int appointmentId, String appointmentTitle, String appointmentDescription, String appointmentLocation, String type, LocalDateTime start, LocalDateTime end, int customerId, int userId, int contactId) {
        this.appointmentId = appointmentId;
        this.appointmentTitle = appointmentTitle;
        this.appointmentDescription = appointmentDescription;
        this.appointmentLocation = appointmentLocation;
        this.type = type;
        this.start = start;
        this.end = end;
        this.startString = getStart().toString();
        this.endString = getEnd().toString();
        this.customer = DBCustomers.getCustomer(customerId);
        this.user = DBUsers.getUser(userId);
        this.contact = DBContacts.getContact(contactId);
    }

    public Appointment(int appointmentId, String appointmentTitle, String appointmentDescription, Location locationEnum, Type typeEnum, LocalDateTime start, LocalDateTime end, Customer customer, User user, Contact contact) {
        this.appointmentId = appointmentId;
        this.appointmentTitle = appointmentTitle;
        this.appointmentDescription = appointmentDescription;
        this.locationEnum = locationEnum;
        this.typeEnum = typeEnum;
        this.start = start;
        this.end = end;
        this.customer = customer;
        this.user = user;
        this.contact = contact;
    }

    public String getStartString() {
        return startString;
    }

    public void setStartString(String startString) {
        this.startString = startString;
    }

    public String getEndString() {
        return endString;
    }

    public void setEndString(String endString) {
        this.endString = endString;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getContactId() {
        return contactId;
    }

    public void setContactId(int contactId) {
        this.contactId = contactId;
    }

    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }

    public void setAppointmentTitle(String appointmentTitle) {
        this.appointmentTitle = appointmentTitle;
    }

    public void setAppointmentDescription(String appointmentDescription) {
        this.appointmentDescription = appointmentDescription;
    }

    public void setAppointmentLocation(String appointmentLocation) {
        this.appointmentLocation = appointmentLocation;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public void setEnd(LocalDateTime end) {
        this.end = end;
    }

    public int getAppointmentId() {
        return appointmentId;
    }

    public String getAppointmentTitle() {
        return appointmentTitle;
    }

    public String getAppointmentDescription() {
        return appointmentDescription;
    }

    //FIXME - Location is not specific: is it a Division? is it separate and made up by the user?
    public String getAppointmentLocation() {
        return appointmentLocation;
    }

    public String getType() {
        return type;
    }

    public Customer getCustomer() {
        return customer;
    }

    public User getUser() {
        return user;
    }

    public Contact getContact() {
        return contact;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "appointmentId=" + appointmentId +
                ", appointmentTitle='" + appointmentTitle + '\'' +
                ", appointmentDescription='" + appointmentDescription + '\'' +
                ", appointmentLocation='" + appointmentLocation + '\'' +
                ", type='" + type + '\'' +
                ", customer=" + customer +
                ", user=" + user +
                ", contact=" + contact +
                '}';
    }

    //                ApptFactory.getAppt(ApptType.PLAN).getAppointmentTypeDescription()
}

interface Appt {
    String getAppointmentTypeDescription();
}

class PlanningAppt implements Appt {
    static final String DESCRIPTION = "Planning Session";

    @Override
    public String getAppointmentTypeDescription() {
        return DESCRIPTION;
    }
}

class DebriefingAppt implements Appt {
    static final String DESCRIPTION = "De-Briefing";

    @Override
    public String getAppointmentTypeDescription() {
        return DESCRIPTION;
    }
}

enum ApptType {
    PLAN(PlanningAppt::new),
    DEBRIEF(DebriefingAppt::new);

    private final Supplier<Appt> constructor;

    ApptType(Supplier<Appt> constructor) {
        this.constructor = constructor;
    }

    public Supplier<Appt> getConstructor() {
        return constructor;
    }
}

class ApptFactory {
    public static Appt getAppt(ApptType type) {
        return type.getConstructor().get();
    }
}

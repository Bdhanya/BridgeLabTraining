package com.interfaces;

import com.model.Address;
import com.model.AddressBook;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public interface AddressBookInt {
    public static List<AddressBook> add() {
        List<AddressBook> addressBooks = new ArrayList<>();
        addressBooks.add(new AddressBook(1, "Bharath", "B",
                new Address("4/152 Koteshwara", "Kundapura",
                        "Kundapura", "Udupi", "Karnataka", "576222"), "bharath@gmail.com"));
        addressBooks.add(new AddressBook(2, "Vaishnavi", "Adiga",
                new Address("4/156 Govinapura", "Govinapura",
                        "Tiptur", "Tiptur", "Karnataka", "576223"), "Vaish@gmail.com"));
        addressBooks.add(new AddressBook(3, "Pavan", "H",
                new Address("4/152 Koteshwara", "Kundapura",
                        "Bangalore", "Bangalore", "Hyderabad", "576221"), "pavn.hm@gmail.com"));
        return addressBooks;
    }

    public void showAddressBook(List<AddressBook> addressBooks);

    public AddressBook getAddressByEmail(String emailId, List<AddressBook> addressBooks) throws Exception;

    public void removeAddress(String emailId,List<AddressBook> addressBooks);
    public void updateAddressBook(String emailId,List<AddressBook> addressBooks,AddressBook addressBook);
    public Long getNumberOfAddressByState(String state,List<AddressBook> addressBooks);
    public Long getNumberOfAddressByCity(String city,List<AddressBook> addressBooks);
    public Set<AddressBook> showNumberOfContactsFromCity(String city,List<AddressBook> addressBooks);
    public Set<AddressBook> showNumberOfContactsFromState(String state, List<AddressBook> addressBooks);
    public void addToAddressBook(AddressBook addressBook,List<AddressBook> addressBooks);
    public void addMultipleAddressToAddressBook(List<AddressBook>addressBookList,List<AddressBook> addressBooks);
}

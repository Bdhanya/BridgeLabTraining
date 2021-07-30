package com.main;

import com.interfaces.AddressBookInt;
import com.model.Address;
import com.model.AddressBook;
import com.service.AddressBookImpl;

import java.util.ArrayList;
import java.util.List;

public class AddressBookMain {
    public static void main(String[] args) throws Exception {
        List<AddressBook> addressBooks = AddressBookInt.add();
        AddressBookImpl addressBook = new AddressBookImpl();
        addressBook.showAddressBook(addressBooks);
        System.out.println("Find addressbook by ID:::::::");

        System.out.println(addressBook.getAddressByEmail("Kitty@gmail.com", addressBooks));
        addressBook.removeAddress("Kitty@gmail.com", addressBooks);

        System.out.println("After removing the address, addressbook details:::::::::::");
        addressBook.showAddressBook(addressBooks);
        AddressBook addressBook1 = new AddressBook(1, "Bharath", "kumar",
                new Address("4/152 Koteshwara", "Kundapura",
                        "Kundapura", "Udupi", "Karnataka", "576222"), "Bharaths@gmail.com");
        addressBook.updateAddressBook("Bharath@gmail.com", addressBooks, addressBook1);
        System.out.println("After updating  the address, addressbook details::::::::::");
        addressBook.showAddressBook(addressBooks);

        System.out.println("Get Number of addresses  by state:::::::::");
        System.out.println(addressBook.getNumberOfAddressByState("Karnataka", addressBooks));

        System.out.println("Get Number of addresses  by city:::::::::");
        System.out.println(addressBook.getNumberOfAddressByCity("Kundapura", addressBooks));

        System.out.println("Get the addresses by state:::::::");
        System.out.println(addressBook.showNumberOfContactsFromState("Karnataka", addressBooks));

        System.out.println("Get the addresses by City::::::::");
        System.out.println(addressBook.showNumberOfContactsFromCity("Kundapura", addressBooks));

        AddressBook addressBook2 = new AddressBook(1, "Aryan", "Dhanya",
                new Address("4/152 Koteshwara", "Kundapura",
                        "Kundapura", "Udupi", "Karnataka", "576222"), "Bharaths@gmail.com");
        System.out.println("Adding new Address:::: " + addressBook2);
        addressBook.addToAddressBook(addressBook2, addressBooks);
        System.out.println("After adding address book is :::");
        addressBook.showAddressBook(addressBooks);

        AddressBook addressBook3 = new AddressBook(5, "Meghana", "Gowda",
                new Address("4/152 Rajajinagar", "Rajajinagar",
                        "Bangalore", "Bangalore Urban", "Karnataka", "575676"), "Bharaths@gmail.com");
        AddressBook addressBook4 = new AddressBook(4, "Kitty", "Bhatt",
                new Address("4/152 Koteshwara", "Kundapura",
                        "Mysore", "Mysore", "Karnataka", "576543"), "Bharaths@gmail.com");
        AddressBook addressBook5 = new AddressBook(6, "Aryan", "Dhanya",
                new Address("4/152 Koteshwara", "Kundapura",
                        "Kundapura", "Udupi", "Karnataka", "576222"), "Bharaths@gmail.com");
        AddressBook addressBook6 = new AddressBook(7, "Bharath", "Kumar",
                new Address("4/152 Koteshwara", "Kundapura",
                        "Kundapura", "Udupi", "Karnataka", "576222"), "Bharaths@gmail.com");
        List<AddressBook> addressBookList=new ArrayList<>();
        addressBookList.add(addressBook3);
        addressBookList.add(addressBook4);
        addressBookList.add(addressBook5);
        addressBookList.add(addressBook6);
        addressBook.addMultipleAddressToAddressBook(addressBookList,addressBooks);
        System.out.println("After adding multiple address to list------------:::::::");
        addressBook.showAddressBook(addressBooks);

    }
}

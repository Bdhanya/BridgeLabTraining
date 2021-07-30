package com.service;

import com.exceptions.NotFoundException;
import com.interfaces.AddressBookInt;
import com.model.AddressBook;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class AddressBookImpl implements AddressBookInt {

    @Override
    public void showAddressBook(List<AddressBook> addressBooks) {
        addressBooks.forEach(System.out::println);
    }

    @Override
    public AddressBook getAddressByEmail(String emailId, List<AddressBook> addressBooks) throws Exception {
        /*Predicate<AddressBook> addressBookPredicate = addressBook -> addressBook.getEmail() != null && addressBook.getEmail().equalsIgnoreCase(emailId);
        return addressBooks.stream().filter(addressBook -> addressBookPredicate.test(addressBook))
                .findAny()
                .orElseThrow(NotFoundException::new);*/

        return addressBooks.stream().filter(addressBook ->
                emailId != null && addressBook.getEmail().equalsIgnoreCase(emailId)).findAny().orElse(new AddressBook());
    }

    @Override
    public void removeAddress(String emailId, List<AddressBook> addressBooks) {
        try {
            AddressBook addressBook = getAddressByEmail(emailId, addressBooks);
            if (addressBook.getEmail() != null)
                addressBooks.remove(addressBook);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateAddressBook(String emailId, List<AddressBook> addressBooks, AddressBook updAddressBook) {
        try {
            addressBooks.stream().forEach(addressBook -> {
                if (emailId != null && addressBook.getEmail().equalsIgnoreCase(emailId)) {
                    addressBook.setEmail(emailId);
                    addressBook.setFirstName(updAddressBook.getFirstName());
                    addressBook.setLastName(updAddressBook.getLastName());
                    addressBook.setAddress(updAddressBook.getAddress());
                }
            });
        } catch (Exception e) {

        }
    }

    @Override
    public Long getNumberOfAddressByState(String state, List<AddressBook> addressBooks) {
        return addressBooks.stream().filter(addressBook -> state != null && addressBook.getAddress().getState().equalsIgnoreCase(state)).count();
    }

    @Override
    public Long getNumberOfAddressByCity(String city, List<AddressBook> addressBooks) {
        return addressBooks.stream().filter(addressBook -> city != null && addressBook.getAddress().getCity().equalsIgnoreCase(city)).count();
    }

    @Override
    public Set<AddressBook> showNumberOfContactsFromCity(String city, List<AddressBook> addressBooks) {
        return addressBooks.stream().filter(addressBook -> city != null && addressBook.getAddress().getCity().equalsIgnoreCase(city))
                .collect(Collectors.toSet());
    }

    @Override
    public Set<AddressBook> showNumberOfContactsFromState(String state, List<AddressBook> addressBooks) {
        return addressBooks.stream().filter(addressBook -> state != null && addressBook.getAddress().getState().equalsIgnoreCase(state))
                .collect(Collectors.toSet());
    }

    @Override
    public void addToAddressBook(AddressBook addressBook, List<AddressBook> addressBooks) {
        Optional<AddressBook> addressPresent = addressBooks.stream().filter(addressBook1 -> addressBook.getFirstName() != null &&
                addressBook1.getFirstName().equalsIgnoreCase(addressBook.getFirstName())).findAny();
        if (addressPresent.isPresent())
            System.out.println("Contact already present in the address Book");
        else
            addressBooks.add(addressBook);
    }

    @Override
    public void addMultipleAddressToAddressBook(List<AddressBook> addressBookList, List<AddressBook> addressBooks) {
       /* addressBookList.stream().forEach(addressBook -> {
            addToAddressBook(addressBook, addressBooks);
        });*/
        Predicate<AddressBook> notIn2 = s -> addressBooks.stream().noneMatch(mc -> s.getFirstName().equals(mc.getFirstName()));
        List<AddressBook> nonAvailableAddress = addressBookList.stream().filter(notIn2).collect(Collectors.toList());
        nonAvailableAddress.stream().forEach(addressBook -> addressBooks.add(addressBook));
    }
}

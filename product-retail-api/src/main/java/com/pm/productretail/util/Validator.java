package com.pm.productretail.util;

import com.pm.productretail.dto.AppUserDto;
import com.pm.productretail.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author lnurullina
 */

@Component
public class Validator extends ResponseCreator {
    private final String USER_NAMES_REGEX = "^([а-яА-ЯёЁa-zA-Z]\\s*)+$";
    private final String EMAIL_REGEX = "^[-a-z0-9!#$%&'*+/=?^_`{|}~]+(\\.[-a-z0-9!#$%&'*+/=?^_`{|}~]+)*@([a-z0-9]([-a-z0-9]{0,61}[a-z0-9])?\\.)*(aero|arpa|asia|biz|cat|com|coop|edu|gov|info|int|jobs|mil|mobi|museum|name|net|org|pro|tel|travel|[a-z][a-z])$";
    private final String PHONE_REGEX = "^\\s*(?:\\+?(\\d{1,3}))?[-. (]*(\\d{3})[-. )]*(\\d{3})[-. ]*(\\d{4})(?: *x(\\d+))?\\s*$";
    private final String PASSWORD_REGEX = ".{6,20}";
    private final String HOUSE_NUMBER_REGEX = "[0-9]+(\\.[0-9]+){0,1}";
    private final String ROOM_NUBER_REGEX = "[0-9]{1,4}";
    private final String EVENT_NAME_REGEX = ".{1,100}";
    private final String EVENT_DESCRIPTION_REGEX = "((\\s)|(.)){0,500}";
    private final String EVENT_TYPE_REGEX = ".{1,30}";
    private final String EVENT_ADDRESS_REGEX = ".{1,200}";

    private Pattern pattern;
    private Matcher matcher;

    private UserService userService;

    @Autowired
    public Validator(UserService userService) {
        this.userService = userService;
    }


    public boolean isValidSignUpData(AppUserDto appUserDto
    ) throws Exception {
        if (appUserDto.getPassword() == null || !this.isPasswordCorrect(appUserDto.getPassword())) {
            throw new Exception(Errors.INCORRECT_PASSWORD);
        }
        if (appUserDto.getUsername() == null || !this.isNameCorrect(appUserDto.getName())) {
            throw new Exception(Errors.INVALID_USERNAME);
        }
        if (appUserDto.getName() != null)
            if (!this.isNameCorrect(appUserDto.getName())) {
                throw new Exception(Errors.INVALID_FIRSTNAME);
            }
        if (appUserDto.getSurname() != null)
            if (!this.isNameCorrect(appUserDto.getSurname())) {
                throw new Exception(Errors.INVALID_SURNAME);
            }

        if (appUserDto.getPhoneNumber() != null)
            if (!this.isPhoneCorrect(appUserDto.getPhoneNumber())) {
                throw new Exception(Errors.INVALID_PHONENUMBER);
            }
        if (appUserDto.getPhoneNumber() != null)
            if (this.isPhoneAlreadyRegistered(appUserDto.getPhoneNumber())) {
                throw new Exception(Errors.REGISTERED_PHONE);
            }
        return true;
    }

    private boolean isEventDateCorrect(String date) {
        try {
            return new Long(date) > System.currentTimeMillis();
        } catch (Exception e) {
            return false;
        }
    }

    private boolean isEventNameCorrect(String name) {
        pattern = Pattern.compile(EVENT_NAME_REGEX);
        matcher = pattern.matcher(name);
        return matcher.matches();
    }

    private boolean isEventDescriptionCorrect(String description) {
        pattern = Pattern.compile(EVENT_DESCRIPTION_REGEX);
        matcher = pattern.matcher(description);
        return matcher.matches();
    }

    private boolean isEventTypeCorrect(String type) {
        pattern = Pattern.compile(EVENT_TYPE_REGEX);
        matcher = pattern.matcher(type);
        return matcher.matches();
    }

    private boolean isEventAddressCorrect(String address) {
        pattern = Pattern.compile(EVENT_ADDRESS_REGEX);
        matcher = pattern.matcher(address);
        return matcher.matches();
    }

    private boolean isEventCapacityCorrect(int capacity) {
        return capacity > 0;
    }

//    public boolean is

    private boolean isNameCorrect(String name) {
        pattern = Pattern.compile(USER_NAMES_REGEX);
        matcher = pattern.matcher(name);
        return matcher.matches();
    }

    private boolean isEmailCorrect(String email) {
        pattern = Pattern.compile(EMAIL_REGEX);
        matcher = pattern.matcher(email);
        return matcher.matches();
    }

    private boolean isPhoneCorrect(String phone) {
        pattern = Pattern.compile(PHONE_REGEX);
        matcher = pattern.matcher(phone);
        return matcher.matches();
    }

    private boolean isPhoneAlreadyRegistered(String phone) {
        return userService.findOneByPhoneNumber(phone) != null;
    }

    private boolean isHouseNumberCorrect(String houseNumber) {
        pattern = Pattern.compile(HOUSE_NUMBER_REGEX);
        matcher = pattern.matcher(houseNumber);
        return matcher.matches();
    }

    private boolean isRoomNumberCorrect(String roomNumber) {
        if (roomNumber == null || roomNumber.equals("")) {
            return true;
        }
        pattern = Pattern.compile(ROOM_NUBER_REGEX);
        matcher = pattern.matcher(roomNumber);
        return matcher.matches();
    }

    public boolean isPasswordCorrect(String password) {
        pattern = Pattern.compile(PASSWORD_REGEX);
        matcher = pattern.matcher(password);
        return matcher.matches();
    }
}
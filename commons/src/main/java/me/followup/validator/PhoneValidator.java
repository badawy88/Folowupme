package me.followup.validator;

import me.followup.annotation.Phone;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created on June 06, 2018
 * Created by: Badawy Abouads
 *
 * Phone/modbile number validation
 */
public class PhoneValidator implements ConstraintValidator<Phone, String> {
    /**
     *
     * @param phoneNumber required String for validation
     * @param ctx validator context
     * @return valid or not
     */
    @Override
    public boolean isValid(String phoneNumber, ConstraintValidatorContext ctx) {
        if(StringUtils.isEmpty(phoneNumber)){
            return true;
        }

        return phoneNumber.matches("\\d{10}") ||
                        // If the phone number with this format 966-594-7778
                        phoneNumber.matches("\\d{3}[-\\.\\s]\\d{3}[-\\.\\s]\\d{4}");
    }

}

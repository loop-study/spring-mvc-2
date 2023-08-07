package hello.itemservice.validation;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.validation.DefaultMessageCodesResolver;
import org.springframework.validation.MessageCodesResolver;

import static org.assertj.core.api.Assertions.*;

public class MessageCodesResolverTest {

    MessageCodesResolver codesResolver = new DefaultMessageCodesResolver();

    @Test
    void messageCodeResolverObject() throws Exception {

        String[] messageCodes = codesResolver.resolveMessageCodes("required", "item");
//        for (String messageCode : messageCodes) {
//            System.out.println("messageCode = " + messageCode);
//        }

        assertThat(messageCodes).contains("required.item", "required");
    }

    @Test
    void messageCodeResolverField() throws Exception {
        String[] messageCodes = codesResolver.resolveMessageCodes("required", "item", "itemName", String.class);

//        for (String messageCode : messageCodes) {
//            System.out.println("messageCode = " + messageCode);
//        }

        assertThat(messageCodes).containsExactly(
                "required.item.itemName",
                "required.itemName",
                "required.java.lang.String",
                "required"
                );

        /*
        Field error in object 'item' on field 'itemName': rejected value []; codes [required.item.itemName,required.itemName,required.java.lang.String,required]; arguments []; default message [null]
        Field error in object 'item' on field 'price': rejected value [null]; codes [range.item.price,range.price,range.java.lang.Integer,range]; arguments [1000,1000000]; default message [null]
        Field error in object 'item' on field 'quantity': rejected value [null]; codes [max.item.quantity,max.quantity,max.java.lang.Integer,max]; arguments [9999]; default message [null]
         */
    }
}
